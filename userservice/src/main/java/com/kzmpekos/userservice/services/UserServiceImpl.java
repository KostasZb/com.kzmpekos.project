package com.kzmpekos.userservice.services;

import com.kzmpekos.userservice.UserRepository;
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
        //Copying the values
        User user = request.getUser();
        com.kzmpekos.userservice.entities.User usr = new com.kzmpekos.userservice.entities.User();
        usr.setName(user.getName());
        usr.setPassword(user.getPassword());
        usr.setEmail(user.getEmail());
        usr.setFarmer(user.getIsFarmer());
        usr.setAddressId(user.getAddressId());
        //Saving the user in the db
        String result;
        if (usr != null && repository.findByEmail(user.getEmail())==null) {
            repository.save(usr);
            result = "User successfully added";
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
        String email=request.getUserDetails().getEmail();
        String password=request.getUserDetails().getPassword();
        com.kzmpekos.userservice.entities.User user=repository.findByEmailAndPassword(email,password);
        User usr=null;
        if(user!=null){
            usr=User.newBuilder().
                    setUserId(user.getUserId()).
                    setName(user.getName()).
                    setAddressId(user.getAddressId()).
                    setIsFarmer(user.getIsFarmer()).build();
        }
        //Building the response and completing the RPC
        LogInResponse response=LogInResponse.newBuilder().setUser(usr).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
