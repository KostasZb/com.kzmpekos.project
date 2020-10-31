package com.example.demo.services;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.proto.users.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserService{


    //Adding a user
    public String signUpUser(User user) {
        //Creating the channel
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
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


    //Getting a user based on username
    public User getUser(String email){
        //Creating the channel.
        //Getting the next available Eureka registered service based on round robin
        // REFERENCE: http://javadox.com/com.netflix.eureka/eureka-client/1.1.136/com/netflix/discovery/DiscoveryClient.html#getNextServerFromEureka(java.lang.String,%20boolean)
        //REFERENCE: https://www.programcreek.com/java-api-examples/?code=Kixeye%2Fchassis%2Fchassis-master%2Fchassis-support%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkixeye%2Fchassis%2Fsupport%2Ftest%2Feureka%2FChassisEurekaRegistrationTest.java
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
