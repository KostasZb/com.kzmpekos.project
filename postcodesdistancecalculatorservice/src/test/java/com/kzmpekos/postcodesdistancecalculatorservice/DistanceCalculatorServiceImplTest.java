package com.kzmpekos.postcodesdistancecalculatorservice;


import com.kzmpekos.postcodesdistancecalculatorservice.DomainLayer.repositories.PostcodesWithCoordinatesRepository;
import com.kzmpekos.postcodesdistancecalculatorservice.DomainLayer.services.DistanceCalculatorService;
import com.kzmpekos.postcodesdistancecalculatorservice.ApplicationLayer.services.*;
import com.proto.address.addressDetails;
import com.proto.distanceCalculator.getProductsWithDistanceRequest;
import com.proto.distanceCalculator.getProductsWithDistanceResponse;
import com.proto.products.Product;
import com.proto.users.User;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.Test;
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
public class DistanceCalculatorServiceImplTest {
    @Autowired
    private DistanceCalculatorServiceImpl distanceCalculatorServiceImpl;
    @MockBean
    private UserService userService;
    @MockBean
    private ProductsService productsService;
    @MockBean
    private AddressService addressService;
    @MockBean
    private DistanceCalculatorService distanceCalculatorService;
    @MockBean
    private PostcodesWithCoordinatesRepository repository;

    @Test
    void testGetProductsWithDistance() throws Exception {
        //Setting up the mock objects
        User user= User.newBuilder().setAddressId(1).build();
        when(userService.getUserWithId(1)).thenReturn(user);
        addressDetails addressDetails= com.proto.address.addressDetails.newBuilder().setPostcode("EH11 1PW").build();
        when(addressService.getAddress(1)).thenReturn(addressDetails);
        Product product=Product.newBuilder().setProductId(1).setFarmerId(1).build();
        ArrayList<Product> productsList=new ArrayList<>();
        productsList.add(product);
        when(productsService.getProducts()).thenReturn(productsList);
        when(distanceCalculatorService.calculate("EH11 1PW","EH11 1PW")).thenReturn((float) 0);
        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        //Creating a request
        getProductsWithDistanceRequest request=getProductsWithDistanceRequest.newBuilder().setUserId(1).build();
        //REFERENCE: https://grpc.github.io/grpc-java/javadoc/io/grpc/testing/StreamRecorder.html
        StreamRecorder<getProductsWithDistanceResponse> responseObserver=StreamRecorder.create();
        distanceCalculatorServiceImpl.getProductsWithDistance(request,responseObserver);
        //failing the test if it takes too long to respond
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<getProductsWithDistanceResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        getProductsWithDistanceResponse response=results.get(0);
        assertEquals(0,response.getProductWithDistance(0).getDistance());



    }
}
