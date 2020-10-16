package com.kzmpekos.productsservice.services;

import com.kzmpekos.productsservice.ProductRepository;
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
        com.kzmpekos.productsservice.entities.Product prod = new com.kzmpekos.productsservice.entities.Product();
        prod.setName(product.getName());
        prod.setFarmerId(product.getFarmerId());
        prod.setPricePerUnit(product.getPricePerUnit());
        prod.setQuantity(product.getQuantity());
        String result;
        //Saving the values into the db
        if (prod != null) {
            repository.save(prod);
            result = "successfully added" + prod.getName() + ". Quantity:" + prod.getQuantity();
        } else {
            result = "Could not add the product";
        }
        //Creating and sending the response
        AddproductResponse response = AddproductResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }

    @Override
    public void getProducts(productsRequest request, StreamObserver<ProductsResponse> responseObserver) {
        List<com.kzmpekos.productsservice.entities.Product> products = repository.findAll();
        //Copying the values
        ArrayList<Product> productsList = new ArrayList<>();
        for (com.kzmpekos.productsservice.entities.Product product : products
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
    public void getProduct(productRequest request, StreamObserver<productResponse> responseObserver) {
        int id = request.getProductId();
        Product produc = null;
        //REFERENCE: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html & https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        Optional<com.kzmpekos.productsservice.entities.Product> product = repository.findById(id);
        if (product.isPresent()) {
            com.kzmpekos.productsservice.entities.Product prod = product.get();
            produc = Product.newBuilder()
                    .setName(prod.getName())
                    .setFarmerId(prod.getFarmerId())
                    .setPricePerUnit(prod.getPricePerUnit())
                    .setQuantity(prod.getQuantity())
                    .setProductId(prod.getProductId()).build();
        } else {

        }
        productResponse response = productResponse.newBuilder().setProduct(produc).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }
}
