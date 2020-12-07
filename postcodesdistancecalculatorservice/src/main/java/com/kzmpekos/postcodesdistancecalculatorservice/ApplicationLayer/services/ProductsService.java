package com.kzmpekos.postcodesdistancecalculatorservice.ApplicationLayer.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.products.Product;
import com.proto.products.ProductServerGrpc;
import com.proto.products.ProductsRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    //Getting all available products
    public List<Product> getProducts() {
        //creating the channel
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("productservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        ProductServerGrpc.ProductServerBlockingStub productServer = ProductServerGrpc.newBlockingStub(channel);
        //Creating and building the message
        ProductsRequest request = ProductsRequest.newBuilder().setRequest("").build();
        //Doing the RPC and retrieving the reply
        List products = productServer.getProducts(request).getProductsList();
        channel.shutdown();
        return products;
    }

}
