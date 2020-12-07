package com.kzmpekos.postcodesdistancecalculatorservice.ApplicationLayer.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.address.addressDetails;
import com.proto.address.addressServerGrpc;
import com.proto.address.getAddressRequest;
import com.proto.address.getAddressResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    public addressDetails getAddress(int id) {
        //creating the channel
        //REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("addressservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        addressServerGrpc.addressServerBlockingStub addressServer = addressServerGrpc.newBlockingStub(channel);
        //Creating and building the message
        getAddressRequest request = getAddressRequest.newBuilder().setAddressId(id).build();
        //Doing the RPC and retrieving the reply
        getAddressResponse details = addressServer.getAddress(request);
        channel.shutdown();
        return details.getAddress();
    }
}
