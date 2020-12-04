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
        Product product = request.getProduct();
        //Getting the values
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
        int id = request.getProductId();
        Product produc = null;
        //REFERENCE: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html & https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        Optional<com.kzmpekos.productsservice.DomainLayer.entities.Product> product = repository.findById(id);
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
        ProductResponse response = ProductResponse.newBuilder().setProduct(produc).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getProductsByFarmerId(ProductByFarmerIdRequest request, StreamObserver<ProductByFarmerIdResponse> responseObserver) {
        int id = request.getFarmerId();
        List<com.kzmpekos.productsservice.DomainLayer.entities.Product> products = repository.findAllByFarmerId(id);
        List<Product> prods = new ArrayList<>();
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
        int productId = request.getProductId();
        com.kzmpekos.productsservice.DomainLayer.entities.Product prod = repository.findByProductId(productId);
        Product product = Product.newBuilder().setQuantity(prod.getQuantity())
                .setPricePerUnit(prod.getPricePerUnit())
                .setName(prod.getName())
                .setProductId(prod.getProductId())
                .setFarmerId(prod.getFarmerId())
                .build();
        repository.deleteById(productId);
        deleteResponse response = deleteResponse.newBuilder().setResponse("product deleted").setProduct(product).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateRequest request, StreamObserver<UpdateResponse> responseObserver) {
        Product product=request.getProduct();
        int id =product.getProductId();
        Optional<com.kzmpekos.productsservice.DomainLayer.entities.Product> prod=repository.findById(id);
        if(prod.isPresent()){
            com.kzmpekos.productsservice.DomainLayer.entities.Product produc=prod.get();
            produc.setQuantity(product.getQuantity());
            produc.setPricePerUnit(product.getPricePerUnit());
            repository.save(produc);
        }
        UpdateResponse response=UpdateResponse.newBuilder().setResponse("product "+ id +" updated successfully").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getFarmerId(GetFarmerIdRequest request, StreamObserver<GetFarmerIdResponse> responseObserver) {
        int productId=request.getProductId();
        com.kzmpekos.productsservice.DomainLayer.entities.Product product=repository.findByProductId(productId);
        int farmerId=product.getFarmerId();
        GetFarmerIdResponse response=GetFarmerIdResponse.newBuilder().setFarmerId(farmerId).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
