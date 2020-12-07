package com.kzmpekos.addressservice.ApplicationLayer.services;

import com.kzmpekos.addressservice.DomainLayer.repositories.AddressRepository;
import com.kzmpekos.addressservice.DomainLayer.entties.Address;
import com.proto.address.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@GRpcService
public class AddressServiceImpl extends addressServerGrpc.addressServerImplBase {

    @Autowired
    private AddressRepository repository;



    @Override
    public void getAddress(getAddressRequest request, StreamObserver<getAddressResponse> responseObserver) {
        //Getting the id of the address
        int addressId = request.getAddressId();
        addressDetails details = null;
        //REFERENCE: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
        //Getting the optional of address
        Optional<Address> address = repository.findById(addressId);
        //Copying the values if the address optional contains the address object
        if (address.isPresent()) {
            Address addr = address.get();
            details = addressDetails.newBuilder().
                    setAddress(addr.getAddress()).
                    setCity(addr.getCity()).
                    setPostcode(addr.getPostcode()).build();

        } else {

        }
        //Adding the object in the response
        getAddressResponse response = getAddressResponse.newBuilder().setAddress(details).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addAddress(addAddressRequest request, StreamObserver<addAddressResponse> responseObserver) {
        addressDetails address = request.getAddress();
        Address addr=new Address();
        //Copying the values
        addr.setPostcode(address.getPostcode());
        addr.setAddress(address.getAddress());
        addr.setCity(address.getCity());

        //saving in the db
        Address add=repository.save(addr);
        int result=add.getAddressId();

        //Building the response and completing the RPC
        addAddressResponse response=addAddressResponse.newBuilder().setAddressId(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
