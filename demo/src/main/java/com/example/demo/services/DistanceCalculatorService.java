package com.example.demo.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.distanceCalculator.distanceCalculatorServerGrpc;
import com.proto.distanceCalculator.getProductsWithDistanceRequest;
import com.proto.distanceCalculator.getProductsWithDistanceResponse;
import com.proto.distanceCalculator.productWithDistance;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceCalculatorService {
   public List<productWithDistance> getListwithDistance(int userId){
       //Creating the channel
       EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
       InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("postcodesdistancecalculatorservice", false);
       ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
       distanceCalculatorServerGrpc.distanceCalculatorServerBlockingStub distanceCalculatorServer = distanceCalculatorServerGrpc.newBlockingStub(channel);
       getProductsWithDistanceRequest request= getProductsWithDistanceRequest.newBuilder().setUserId(userId).build();
       getProductsWithDistanceResponse response=distanceCalculatorServer.getProductsWithDistance(request);
       return response.getProductWithDistanceList();
   }


}
