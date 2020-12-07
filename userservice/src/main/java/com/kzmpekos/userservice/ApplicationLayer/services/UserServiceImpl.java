package com.kzmpekos.userservice.ApplicationLayer.services;

import com.kzmpekos.userservice.DomainLayer.repositories.UserRepository;
import com.proto.users.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class UserServiceImpl extends UserServerGrpc.UserServerImplBase {
    @Autowired
    private UserRepository repository;

    @Override
    public void signUp(SignUpRequest request, StreamObserver<SignUpResponse> responseObserver) {
        //Getting the user object out of the request
        User user = request.getUser();
        //Copying the values
        com.kzmpekos.userservice.DomainLayer.entities.User usr = new com.kzmpekos.userservice.DomainLayer.entities.User();
        usr.setName(user.getName());
        usr.setPassword(user.getPassword());
        usr.setEmail(user.getEmail());
        usr.setFarmer(user.getIsFarmer());
        usr.setAddressId(user.getAddressId());
        //Saving the user in the db
        String result;
        if (usr != null && repository.findByEmail(user.getEmail()) == null) {
            com.kzmpekos.userservice.DomainLayer.entities.User createduser = repository.save(usr);
            result = "User" + createduser.getName() + "successfully added";
        } else {
            result = "Could not add user";
        }
        //Building the response and completing the RPC
        SignUpResponse response = SignUpResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void logIn(LogInRequest request, StreamObserver<LogInResponse> responseObserver) {
        //Getting the user details from the request
        String email = request.getUserDetails().getEmail();
        String password = request.getUserDetails().getPassword();
        //Finding the user in the database
        com.kzmpekos.userservice.DomainLayer.entities.User user = repository.findByEmailAndPassword(email, password);
        //Copying the values of the user object
        User usr = null;
        if (user != null) {
            usr = User.newBuilder().
                    setUserId(user.getUserId()).
                    setName(user.getName()).
                    setAddressId(user.getAddressId()).
                    setIsFarmer(user.getIsFarmer()).build();
        }
        //Building the response and completing the RPC
        LogInResponse response = LogInResponse.newBuilder().setUser(usr).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserByEmail(getUserByEmailRequest request, StreamObserver<getUserByEmailResponse> responseObserver) {
        //Getting the user's email out of the request
        String email = request.getEmail();
        //Finding the user in the database
        com.kzmpekos.userservice.DomainLayer.entities.User user = repository.findByEmail(email);
        //Copying the values of the user object
        User usr = null;
        if (user != null) {
            usr = User.newBuilder().
                    setUserId(user.getUserId()).
                    setName(user.getName()).
                    setAddressId(user.getAddressId()).
                    setIsFarmer(user.getIsFarmer()).
                    setPassword(user.getPassword()).build();

        }
        //Building the response and completing the RPC
        getUserByEmailResponse response = getUserByEmailResponse.newBuilder().setUser(usr).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserById(getUserByIdRequest request, StreamObserver<getUserByIdResponse> responseObserver) {
        //Getting the user's id out of the request
        int userId = request.getUserId();
        //Finding the user in the database
        com.kzmpekos.userservice.DomainLayer.entities.User user = repository.findByUserId(userId);
        //Copying the values of the user object
        User usr = User.newBuilder()
                .setIsFarmer(user.getIsFarmer())
                .setAddressId(user.getAddressId())
                .setUserId(user.getUserId())
                .setEmail(user.getEmail())
                .setName(user.getName())
                .build();
        //Building the response and completing the RPC
        getUserByIdResponse response = getUserByIdResponse.newBuilder().setUser(usr).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
