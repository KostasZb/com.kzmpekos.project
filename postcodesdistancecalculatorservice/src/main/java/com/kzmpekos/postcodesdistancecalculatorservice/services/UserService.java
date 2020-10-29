package com.kzmpekos.postcodesdistancecalculatorservice.services;

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
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("userservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        UserServerGrpc.UserServerBlockingStub userServer = UserServerGrpc.newBlockingStub(channel);
        //Creating and building the message
        getUserByIdRequest request = getUserByIdRequest.newBuilder().setUserId(userId).build();
        //Doing the RPC and retrieving the reply
        getUserByIdResponse response = userServer.getUserById(request);
        return response.getUser();
    }
}
