package com.kzmpekos.commissionservice;

import com.kzmpekos.commissionservice.ApplicationLayer.services.CommissionServiceImpl;
import com.kzmpekos.commissionservice.ApplicationLayer.services.ProductsService;
import com.kzmpekos.commissionservice.DomainLayer.repositories.CommissionRepository;
import com.proto.commissions.*;
import com.proto.products.Product;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


@SpringBootTest
@SpringJUnitConfig(classes = TestConfiguration.class)
public class CommissionServiceImplTest {
    @Autowired
    private CommissionServiceImpl commissionService;
    @MockBean
    private CommissionRepository repository;
    @MockBean
    private ProductsService productsService;

    @Test
    void testAddCommission() throws Exception {
        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        Commission commission=Commission.newBuilder().setTotalPrice(1).setUserId(1).setProductId(1).build();
        com.kzmpekos.commissionservice.DomainLayer.entities.Commission comm=new com.kzmpekos.commissionservice.DomainLayer.entities.Commission();
        comm.setOrderId(1);
        //Mocking the repository
        when(repository.save(Mockito.any(com.kzmpekos.commissionservice.DomainLayer.entities.Commission.class))).thenReturn(comm);
        Product product=Product.newBuilder().setProductId(1).setQuantity(1).setPricePerUnit(1).setFarmerId(1).build();
        //Mocking the products service
        when(productsService.getProductById(1)).thenReturn(product);
        //Creating a request
        AddCommissionRequest request= AddCommissionRequest.newBuilder().setCommission(commission).build();
        //REFERENCE: https://grpc.github.io/grpc-java/javadoc/io/grpc/testing/StreamRecorder.html
        StreamRecorder<AddCommissionResponse> responseObserver=StreamRecorder.create();
        //failing the test if it takes too long to respond
        commissionService.addCommission(request,responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<AddCommissionResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        AddCommissionResponse response=results.get(0);
        assertEquals("Order 1 created",response.getResult());
    }
    @Test
    void testGetCommissions() throws Exception {
        com.kzmpekos.commissionservice.DomainLayer.entities.Commission commission=new com.kzmpekos.commissionservice.DomainLayer.entities.Commission();
        commission.setQuantity(1);
        commission.setProductName("Name");
        commission.setOrderId(1);
        commission.setTotalCost(1);
        commission.setProductId(1);
        commission.setUserId(1);
        ArrayList<com.kzmpekos.commissionservice.DomainLayer.entities.Commission> commissionList=new ArrayList<>();
        commissionList.add(commission);
        when(repository.findAllByFarmerId(1)).thenReturn(commissionList);
        //Creating a request
        GetCommissionsRequest request=GetCommissionsRequest.newBuilder().setUserId(1).build();
        //REFERENCE: https://grpc.github.io/grpc-java/javadoc/io/grpc/testing/StreamRecorder.html
        StreamRecorder<GetCommissionsResponse> responseObserver=StreamRecorder.create();
        commissionService.getCommissions(request,responseObserver);
        //failing the test if it takes too long to respond
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<GetCommissionsResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        GetCommissionsResponse response=results.get(0);
        assertEquals(commission.getProductId(),response.getCommissions(0).getProductId());
        assertEquals(commission.getProductName(),response.getCommissions(0).getProductName());
        assertEquals(commission.getQuantity(),response.getCommissions(0).getQuantity());
        assertEquals(commission.getTotalCost(),response.getCommissions(0).getTotalPrice());
    }
}
