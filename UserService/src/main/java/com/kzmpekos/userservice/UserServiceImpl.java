package com.kzmpekos.userservice;

import com.kzmpekos.util.HibernateUtil;
import com.proto.users.*;
import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServerGrpc.UserServerImplBase {
    //Sign up implementation
    @Override
    public void signUp(SignUpRequest request, StreamObserver<SignUpResponse> responseObserver) {
        //Getting the user details
        User user=request.getUser();
        com.kzmpekos.users.User usr=new com.kzmpekos.users.User();
        usr.setName(user.getName());
        usr.setPassword(user.getPassword());
        usr.setEmail(user.getEmail());
        usr.setFarmer(user.getIsFarmer());
        usr.setAddressId(user.getAddressId());
        //Saving the user in the db
        HibernateUtil util=new HibernateUtil();
        String result=util.addUser(usr);
        //Building the response and completing the RPC
        SignUpResponse response=SignUpResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
    //Log in implementation
    @Override
    public void logIn(LogInRequest request, StreamObserver<LogInResponse> responseObserver) {
        String email =request.getUserDetails().getEmail();
        String password=request.getUserDetails().getPassword();
        //Getting the user corresponding to the email and password provided
        HibernateUtil util=new HibernateUtil();
        com.kzmpekos.users.User user=util.getUser(email,password);
        //Getting the details of the user retrieved
        User usr=User.newBuilder().setAddressId(user.getAddressId()).setEmail(user.getEmail()).setIsFarmer(user.getIsFarmer())
                .setName(user.getName()).setUserId(user.getUserId()).build();
        //Building the response and completing the RPC
        LogInResponse response=LogInResponse.newBuilder().setUser(usr).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
