package com.example.demo.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.commissions.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


public class CommissionService {


    //Creating the channel
    EurekaClient eurekaClient= DiscoveryManager.getInstance().getEurekaClient();

    InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("commissionservice",false);
    ManagedChannel channel=ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(),instanceInfo.getPort()).usePlaintext().build();
    //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5003).usePlaintext().build();
    CommissionServerGrpc.CommissionServerBlockingStub commissionServer = CommissionServerGrpc.newBlockingStub(channel);

    public void addCommission() {


        //Creating and building the message
        /*TO BE CHANGED*/
        Commission commission = Commission.newBuilder().setUserId(2).setFarmerId(2).setTotalPrice(3).build();
        AddCommissionRequest request = AddCommissionRequest.newBuilder().setCommission(commission).build();
        //Doing the RPC and retrieving the reply
        AddCommissionResponse response = commissionServer.addCommission(request);
    }

    public void getCommissions(int userId) {

        //Creating and building the message
        GetCommissionsRequest request = GetCommissionsRequest.newBuilder().setUserId(userId).build();
        //Doing the RPC and retrieving the reply
        List response = commissionServer.getCommissions(request).getCommissionsList();

    }

}
