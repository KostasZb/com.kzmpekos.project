package com.kzmpekos.addressservice.services;

import com.kzmpekos.addressservice.AddressRepository;
import com.kzmpekos.addressservice.entties.Address;
import com.proto.address.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@GRpcService
public class AddressServiceImpl extends addressServerGrpc.addressServerImplBase{

    @Autowired
    private AddressRepository repository;


    @Override
    public void getAddress(getAddressRequest request, StreamObserver<getAddressResponse> responseObserver) {
        int addressId=request.getAddressId();
        addressDetails details=null;
        //REFERENCE: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html & https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
        Optional<Address> address= repository.findById(addressId);
        if(address.isPresent()){
            Address addr=address.get();
            details=addressDetails.newBuilder().
                    setAddress(addr.getAddress()).
                    setCity(addr.getCity()).
                    setPostcode(addr.getPostcode()).build();

        }else{

        }
        getAddressResponse response=getAddressResponse.newBuilder().setAddress(details).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addAddress(addAddressRequest request, StreamObserver<addAddressResponse> responseObserver) {
        super.addAddress(request, responseObserver);
    }
}
