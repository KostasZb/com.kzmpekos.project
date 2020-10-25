package com.example.demo.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.commissions.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionService {

    public String addCommission(int productId,int userId, float totalPrice) {

        //Creating the channel
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("commissionservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        CommissionServerGrpc.CommissionServerBlockingStub commissionServer = CommissionServerGrpc.newBlockingStub(channel);

        //Creating and building the message
        Commission commission = Commission.newBuilder().setUserId(userId).setProductId(productId).setTotalPrice(totalPrice).build();
        AddCommissionRequest request = AddCommissionRequest.newBuilder().setCommission(commission).build();
        //Doing the RPC and retrieving the reply
        AddCommissionResponse response = commissionServer.addCommission(request);
        return response.getResult();
    }

    public void getCommissions(int userId) {

        //Creating the channel
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        //Getting the next available Eureka registered service based on round robin REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("commissionservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5003).usePlaintext().build();
        CommissionServerGrpc.CommissionServerBlockingStub commissionServer = CommissionServerGrpc.newBlockingStub(channel);

        //Creating and building the message
        GetCommissionsRequest request = GetCommissionsRequest.newBuilder().setUserId(userId).build();
        //Doing the RPC and retrieving the reply
        List response = commissionServer.getCommissions(request).getCommissionsList();

    }

}
