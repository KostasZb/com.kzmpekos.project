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
       //Getting the next available Eureka registered service based on round robin
       // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
       //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
       EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
       InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("postcodesdistancecalculatorservice", false);
       ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();

       distanceCalculatorServerGrpc.distanceCalculatorServerBlockingStub distanceCalculatorServer = distanceCalculatorServerGrpc.newBlockingStub(channel);
       //Building the message
       getProductsWithDistanceRequest request= getProductsWithDistanceRequest.newBuilder().setUserId(userId).build();
       //Doing the RPC and retrieving the reply
       getProductsWithDistanceResponse response=distanceCalculatorServer.getProductsWithDistance(request);
       return response.getProductWithDistanceList();
   }


}
