package com.example.demo.services;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.users.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    //Adding a user
    public String signUpUser(User user) {
        //Creating the channel
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("userservice", false);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5002).usePlaintext().build();
        UserServerGrpc.UserServerBlockingStub userServer = UserServerGrpc.newBlockingStub(channel);

        //Creating and building the message
        SignUpRequest request = SignUpRequest.newBuilder().setUser(user).build();

        //Doing the RPC and retrieving the reply
        SignUpResponse response = userServer.signUp(request);
        return response.getResult();
    }

    //Logging in a user
    public User LogInUser(String email, String password) {

        //Creating the channel
        EurekaClient eurekaClient= DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("userservice",false);
        ManagedChannel channel=ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(),instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5002).usePlaintext().build();
        UserServerGrpc.UserServerBlockingStub userServer = UserServerGrpc.newBlockingStub(channel);

        //Creating and building the message
        UserDetails details = UserDetails.newBuilder().setEmail(email).setPassword(password).build();
        LogInRequest request = LogInRequest.newBuilder().setUserDetails(details).build();
        //Doing the RPC and retrieving the reply
        LogInResponse response = userServer.logIn(request);
        return response.getUser();
    }

    //Getting a user based on username
    public User getUser(String email){
        //Creating the channel
        EurekaClient eurekaClient= DiscoveryManager.getInstance().getEurekaClient();
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("userservice",false);
        ManagedChannel channel=ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(),instanceInfo.getPort()).usePlaintext().build();
        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5002).usePlaintext().build();
        UserServerGrpc.UserServerBlockingStub userServer = UserServerGrpc.newBlockingStub(channel);
        //Creating and building the message
        getUserByEmailRequest request=getUserByEmailRequest.newBuilder().setEmail(email).build();
        //Doing the RPC and retrieving the reply
        getUserByEmailResponse response=userServer.getUserByEmail(request);

        return response.getUser();
    }

}
