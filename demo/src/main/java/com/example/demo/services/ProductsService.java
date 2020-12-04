package com.example.demo.services;

import com.example.demo.models.NewProduct;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.products.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {




    //Adding a product
    public void addProduct(NewProduct newProduct) {
        //creating the channel
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6564).usePlaintext().build();
        ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);
        Product product=Product.newBuilder()
                .setQuantity(newProduct.getQuantity())
                .setPricePerUnit(newProduct.getPricePerUnit())
                .setFarmerId(newProduct.getFarmerId())
                .setName(newProduct.getName())
                .build();
        //Creating and building the message
        AddProductRequest request = AddProductRequest.newBuilder().setProduct(product).build();

        //Doing the RPC and retrieving the reply
        AddproductResponse response = productServer.addProduct(request);
        channel.shutdown();
    }

    //Getting a product according to its id
    public Product retrieveProduct(int productId) {
        //creating the channel
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6564).usePlaintext().build();
        ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);


        //Creating and building the message
        ProductRequest request = ProductRequest.newBuilder().setProductId(productId).build();

        //Doing the RPC and retrieving the reply
        ProductResponse response = productServer.getProduct(request);
        channel.shutdown();
        return response.getProduct();
    }
/*
    //Getting all available products
    public List<Product> getProducts() {
        //creating the channel
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6564).usePlaintext().build();
        ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);


        //Creating and building the message
        ProductsRequest request = ProductsRequest.newBuilder().setRequest("").build();
        //Doing the RPC and retrieving the reply
        List products = productServer.getProducts(request).getProductsList();
        channel.shutdown();
        return products;
    }*/

    public List<Product> getProductsByFarmerId(int id){
        //creating the channel
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);

        //Creating and building the message
        ProductByFarmerIdRequest request=ProductByFarmerIdRequest.newBuilder().setFarmerId(id).build();
        List products=productServer.getProductsByFarmerId(request).getProductsList();
        channel.shutdown();
        return products;
    }
    public String updateProduct(Product product){
        //creating the channel
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);

        //Creating and building the message
        UpdateRequest request=UpdateRequest.newBuilder().setProduct(product).build();
        String response=productServer.update(request).getResponse();
        channel.shutdown();
        return response;
    }

    public Product deleteProductById(int id){
        //creating the channel
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);
        //Creating and building the message
        deleteRequest request= deleteRequest.newBuilder().setProductId(id).build();
        Product product=productServer.delete(request).getProduct();
        channel.shutdown();
        return product;
    }


}
