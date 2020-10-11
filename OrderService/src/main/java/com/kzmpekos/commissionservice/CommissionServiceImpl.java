package com.kzmpekos.commissionservice;

import com.kzmpekos.util.HibernateUtil;
import com.proto.commissions.*;
import io.grpc.stub.StreamObserver;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommissionServiceImpl extends CommissionServerGrpc.CommissionServerImplBase {

    @Override
    public void addCommission(AddCommissionRequest request, StreamObserver<AddCommissionResponse> responseObserver) {
        //Copying the values
        Commission commission=request.getCommission();
        com.kzmpekos.commissions.Commission comm=new com.kzmpekos.commissions.Commission();
        comm.setFarmerId(commission.getFarmerId());
        comm.setUserId(commission.getUserId());
        Timestamp time=new Timestamp(System.currentTimeMillis());
        comm.setTimestamp(time);
        comm.setTotalCost(commission.getTotalPrice());
        //saving in the db
        HibernateUtil util=new HibernateUtil();
        //Building the response and completing the RPC
        String result=util.addCommission(comm);
        AddCommissionResponse response= AddCommissionResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void getCommissions(GetCommissionsRequest request, StreamObserver<GetCommissionsResponse> responseObserver) {

        int userId=request.getUserId();
        //retrieving the orders from the db
        List<com.kzmpekos.commissions.Commission> commissions=HibernateUtil.retrieveOrdersByUserId(userId);
        ArrayList<Commission> commissionsList=new ArrayList<>();
        for (com.kzmpekos.commissions.Commission commission:commissions
             ) {
            Commission comm =Commission.newBuilder().setFarmerId(commission.getFarmerId()).setTotalPrice(commission.getTotalCost()).build();
            commissionsList.add(comm);
        }
        //Creating the response and completing the RPC
        GetCommissionsResponse response= GetCommissionsResponse.newBuilder().addAllCommissions(commissionsList).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }
}
