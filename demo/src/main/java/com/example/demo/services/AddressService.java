package com.example.demo.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.address.addressServerGrpc;
import com.proto.address.getAddressRequest;
import com.proto.address.getAddressResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    public void getAddress(int id) {

//REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();


        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("addressservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        addressServerGrpc.addressServerBlockingStub addressServer = addressServerGrpc.newBlockingStub(channel);




        getAddressRequest request = getAddressRequest.newBuilder().setAddressId(id).build();
        getAddressResponse details = addressServer.getAddress(request);

    }
}
