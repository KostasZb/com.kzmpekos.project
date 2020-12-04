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
    }

}
