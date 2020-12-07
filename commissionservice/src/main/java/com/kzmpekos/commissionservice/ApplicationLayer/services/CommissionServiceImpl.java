package com.kzmpekos.commissionservice.ApplicationLayer.services;

import com.kzmpekos.commissionservice.DomainLayer.repositories.CommissionRepository;
import com.proto.commissions.*;
import com.proto.products.Product;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@GRpcService
public class CommissionServiceImpl extends CommissionServerGrpc.CommissionServerImplBase {
    @Autowired
    private CommissionRepository repository;
    @Autowired
    private ProductsService productsService;

    @Override
    public void addCommission(AddCommissionRequest request, StreamObserver<AddCommissionResponse> responseObserver) {
        // Getting the commission object from the request
        Commission commission = request.getCommission();
        // Creating the commission object and copying the values from the request object
        com.kzmpekos.commissionservice.DomainLayer.entities.Commission comm = new com.kzmpekos.commissionservice.DomainLayer.entities.Commission();
        comm.setProductId(commission.getProductId());
        comm.setUserId(commission.getUserId());
        Timestamp time = new Timestamp(System.currentTimeMillis());
        comm.setTimestamp(time);
        comm.setTotalCost(commission.getTotalPrice());
        //Getting the product object based on the given id
        Product product=productsService.getProductById(comm.getProductId());
        //Copying the values into the commission object
        comm.setFarmerId(product.getFarmerId());
        comm.setProductName(product.getName());
        comm.setQuantity(product.getQuantity());
        // Saving the commmission object into the database
        com.kzmpekos.commissionservice.DomainLayer.entities.Commission commiss = repository.save(comm);
        //Creating and building the response
        String result = "Order " + commiss.getOrderId() + " created";
        AddCommissionResponse response = AddCommissionResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCommissions(GetCommissionsRequest request, StreamObserver<GetCommissionsResponse> responseObserver) {
        //Getting the user's id
        int userId = request.getUserId();
        //Getting all commissions based on the user's id
        List<com.kzmpekos.commissionservice.DomainLayer.entities.Commission> commissions = repository.findAllByFarmerId(userId);
        ArrayList<CommissionWithDetails> commissionsList = new ArrayList<>();
        //Copying the values
        for (com.kzmpekos.commissionservice.DomainLayer.entities.Commission commission : commissions
        ) {
            CommissionWithDetails com = CommissionWithDetails.newBuilder().
                    setProductName(commission.getProductName()).
                    setQuantity(commission.getQuantity()).
                    setTotalPrice(commission.getTotalCost()).
                    setProductId(commission.getProductId()).
                    setUserId(commission.getUserId())
                    .build();


            commissionsList.add(com);
        }
        //Creating and building the response
        GetCommissionsResponse response = GetCommissionsResponse.newBuilder().addAllCommissions(commissionsList).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
