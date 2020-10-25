package com.kzmpekos.commissionservice.services;

import com.kzmpekos.commissionservice.CommissionRepository;
import com.proto.commissions.*;
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

    @Override
    public void addCommission(AddCommissionRequest request, StreamObserver<AddCommissionResponse> responseObserver) {
        Commission commission = request.getCommission();
        com.kzmpekos.commissionservice.entities.Commission comm = new com.kzmpekos.commissionservice.entities.Commission();

        comm.setProductId(commission.getProductId());
        comm.setUserId(commission.getUserId());
        Timestamp time = new Timestamp(System.currentTimeMillis());
        comm.setTimestamp(time);
        comm.setTotalCost(commission.getTotalPrice());
        com.kzmpekos.commissionservice.entities.Commission commiss = repository.save(comm);
        String result = "Order " + commiss.getOrderId() + " created";
        AddCommissionResponse response = AddCommissionResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCommissions(GetCommissionsRequest request, StreamObserver<GetCommissionsResponse> responseObserver) {
        int userId = request.getUserId();
        List<com.kzmpekos.commissionservice.entities.Commission> commissions = repository.findAllByUserId(userId);
        ArrayList<Commission> commissionsList = new ArrayList<>();
        for (com.kzmpekos.commissionservice.entities.Commission commission : commissions
        ) {
            Commission com = Commission.newBuilder().
                    setProductId(commission.getProductId()).
                    setTotalPrice(commission.getTotalCost()).
                    setUserId(commission.getUserId()).build();
        }
        GetCommissionsResponse response = GetCommissionsResponse.newBuilder().addAllCommissions(commissionsList).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
