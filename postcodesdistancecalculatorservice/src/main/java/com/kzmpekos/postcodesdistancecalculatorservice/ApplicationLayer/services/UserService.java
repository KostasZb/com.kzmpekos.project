package com.kzmpekos.postcodesdistancecalculatorservice.ApplicationLayer.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.users.User;
import com.proto.users.UserServerGrpc;
import com.proto.users.getUserByIdRequest;
import com.proto.users.getUserByIdResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserWithId(int userId) {
        //Creating the channel
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("userservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        UserServerGrpc.UserServerBlockingStub userServer = UserServerGrpc.newBlockingStub(channel);
        //Creating and building the message
        getUserByIdRequest request = getUserByIdRequest.newBuilder().setUserId(userId).build();
        //Doing the RPC and retrieving the reply
        getUserByIdResponse response = userServer.getUserById(request);
        channel.shutdown();
        return response.getUser();
    }
}
