package com.example.demo.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.products.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProductsService {

    //creating the channel
    EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();

    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
    ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();

    //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6564).usePlaintext().build();
    ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);


    //Adding a product
    public void addProduct() {


        //Creating and building the message
        /*TO BE CHANGED*/
        Product product = Product.newBuilder().setName("asasda").setPricePerUnit(2).setQuantity(5).build();
        AddProductRequest request = AddProductRequest.newBuilder().setProduct(product).build();

        //Doing the RPC and retrieving the reply
        AddproductResponse response = productServer.addProduct(request);
        channel.shutdown();
    }

    //Getting a product according to its id
    public void retrieveProduct(int productId) {

        //Creating and building the message
        productRequest request = productRequest.newBuilder().setProductId(productId).build();

        //Doing the RPC and retrieving the reply
        productResponse response = productServer.getProduct(request);
        channel.shutdown();
    }

    //Getting all available products
    public void getProducts() {

        //Creating and building the message
        productsRequest request = productsRequest.newBuilder().setRequest("").build();
        //Doing the RPC and retrieving the reply
        List products = productServer.getProducts(request).getProductsList();

        channel.shutdown();
    }


}
