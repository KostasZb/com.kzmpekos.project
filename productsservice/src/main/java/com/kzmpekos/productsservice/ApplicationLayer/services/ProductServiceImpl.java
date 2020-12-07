package com.kzmpekos.productsservice.ApplicationLayer.services;

import com.kzmpekos.productsservice.DomainLayer.repositories.ProductRepository;
import com.proto.products.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@GRpcService
public class ProductServiceImpl extends ProductServerGrpc.ProductServerImplBase {
    @Autowired
    private ProductRepository repository;

    @Override
    public void addProduct(AddProductRequest request, StreamObserver<AddproductResponse> responseObserver) {
        //Getting the product out of the request
        Product product = request.getProduct();
        //Copying the values into a product object
        com.kzmpekos.productsservice.DomainLayer.entities.Product prod = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        prod.setName(product.getName());
        prod.setFarmerId(product.getFarmerId());
        prod.setPricePerUnit(product.getPricePerUnit());
        prod.setQuantity(product.getQuantity());
        String result;
        //Saving the values into the db
        if (prod != null) {
            com.kzmpekos.productsservice.DomainLayer.entities.Product pro=repository.save(prod);
            result = "successfully added " + pro.getName() + ". Quantity: " + pro.getQuantity();
        } else {
            result = "Could not add the product";
        }
        //Creating and sending the response
        AddproductResponse response = AddproductResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getProducts(ProductsRequest request, StreamObserver<ProductsResponse> responseObserver) {
        //Getting a list of the available products from the database
        List<com.kzmpekos.productsservice.DomainLayer.entities.Product> products = repository.findAll();
        //Copying the values
        ArrayList<Product> productsList = new ArrayList<>();
        for (com.kzmpekos.productsservice.DomainLayer.entities.Product product : products
        ) {
            Product prod = Product.newBuilder().setProductId(product.getProductId()).
                    setName(product.getName()).setFarmerId(product.getFarmerId()).setQuantity(product.getQuantity()).
                    setPricePerUnit(product.getPricePerUnit()).build();
            productsList.add(prod);
        }

        //creating the response and completing the rpc
        ProductsResponse response = ProductsResponse.newBuilder().addAllProducts(productsList).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        //Getting the product's id out of the request
        int id = request.getProductId();
        Product produc = null;
        //REFERENCE: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html & https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        Optional<com.kzmpekos.productsservice.DomainLayer.entities.Product> product = repository.findById(id);
        //Copying the values if the product object is present in the optional
        if (product.isPresent()) {
            com.kzmpekos.productsservice.DomainLayer.entities.Product prod = product.get();
            produc = Product.newBuilder()
                    .setName(prod.getName())
                    .setFarmerId(prod.getFarmerId())
                    .setPricePerUnit(prod.getPricePerUnit())
                    .setQuantity(prod.getQuantity())
                    .setProductId(prod.getProductId()).build();
        } else {

        }
        //creating the response and completing the rpc
        ProductResponse response = ProductResponse.newBuilder().setProduct(produc).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getProductsByFarmerId(ProductByFarmerIdRequest request, StreamObserver<ProductByFarmerIdResponse> responseObserver) {
        //Getting the farmer's id out of the request
        int id = request.getFarmerId();
        //Finding all product related to the farmer's id from the database
        List<com.kzmpekos.productsservice.DomainLayer.entities.Product> products = repository.findAllByFarmerId(id);
        List<Product> prods = new ArrayList<>();
        //Copying the values
        for (com.kzmpekos.productsservice.DomainLayer.entities.Product product : products
        ) {
            Product prod = Product.newBuilder()
                    .setProductId(product.getProductId()).
                            setName(product.getName())
                    .setFarmerId(product.getFarmerId())
                    .setQuantity(product.getQuantity())
                    .setPricePerUnit(product.getPricePerUnit()).build();
            prods.add(prod);
        }
        //creating the response and completing the rpc
        ProductByFarmerIdResponse response = ProductByFarmerIdResponse.newBuilder().addAllProducts(prods).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void delete(deleteRequest request, StreamObserver<deleteResponse> responseObserver) {
        //Getting the product's id out of the request
        int productId = request.getProductId();
        //Finding the product from the database
        com.kzmpekos.productsservice.DomainLayer.entities.Product prod = repository.findByProductId(productId);
        //Copying the values
        Product product = Product.newBuilder().setQuantity(prod.getQuantity())
                .setPricePerUnit(prod.getPricePerUnit())
                .setName(prod.getName())
                .setProductId(prod.getProductId())
                .setFarmerId(prod.getFarmerId())
                .build();
        //Deleting the product from the database
        repository.deleteById(productId);
        //creating the response and completing the rpc
        deleteResponse response = deleteResponse.newBuilder().setResponse("product deleted").setProduct(product).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateRequest request, StreamObserver<UpdateResponse> responseObserver) {
        //Getting the product out of the request
        Product product=request.getProduct();
        int id =product.getProductId();
        Optional<com.kzmpekos.productsservice.DomainLayer.entities.Product> prod=repository.findById(id);
        //Updating the product in the database if it is present in the optional
        if(prod.isPresent()){
            com.kzmpekos.productsservice.DomainLayer.entities.Product produc=prod.get();
            produc.setQuantity(product.getQuantity());
            produc.setPricePerUnit(product.getPricePerUnit());
            repository.save(produc);
        }
        //creating the response and completing the rpc
        UpdateResponse response=UpdateResponse.newBuilder().setResponse("product "+ id +" updated successfully").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getFarmerId(GetFarmerIdRequest request, StreamObserver<GetFarmerIdResponse> responseObserver) {
        //Getting the product's id out of the request
        int productId=request.getProductId();
        //Finding the product in the database
        com.kzmpekos.productsservice.DomainLayer.entities.Product product=repository.findByProductId(productId);
        //Getting the farmer's id
        int farmerId=product.getFarmerId();
        //creating the response and completing the rpc
        GetFarmerIdResponse response=GetFarmerIdResponse.newBuilder().setFarmerId(farmerId).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
