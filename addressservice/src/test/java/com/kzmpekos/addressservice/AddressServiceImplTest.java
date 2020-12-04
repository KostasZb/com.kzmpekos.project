package com.kzmpekos.addressservice;

import com.kzmpekos.addressservice.DomainLayer.entties.Address;
import com.kzmpekos.addressservice.DomainLayer.repositories.AddressRepository;
import com.kzmpekos.addressservice.ApplicationLayer.services.AddressServiceImpl;
import com.proto.address.*;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
@SpringJUnitConfig(classes = TestConfiguration.class)
public class AddressServiceImplTest {
    @Autowired
    private AddressServiceImpl addressService;
    @MockBean
    private AddressRepository repository;

    @Test
    void testGetAddress() throws Exception {
        //Setting up the mock object and repository
        Address adress=new Address();
        adress.setCity("city");
        adress.setAddressId(1);
        adress.setAddress("address");
        adress.setPostcode("postcode");
        when(repository.findById(1)).thenReturn(Optional.of(adress));

        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        //Creating a request
        getAddressRequest request= getAddressRequest.newBuilder().setAddressId(1).build();
        //REFERENCE: https://grpc.github.io/grpc-java/javadoc/io/grpc/testing/StreamRecorder.html
        StreamRecorder<getAddressResponse> responseObserver=StreamRecorder.create();
        //failing the test if it takes too long to respond
        addressService.getAddress(request,responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<getAddressResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        getAddressResponse response=results.get(0);
        //Asserting that the results match the predefined values
        assertEquals(response.getAddress().getAddress(),adress.getAddress());
        assertEquals(response.getAddress().getCity(),adress.getCity());
        assertEquals(response.getAddress().getPostcode(),adress.getPostcode());

    }
    @Test
    void testSetAddress() throws Exception {

        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        //Setting up the mock objects
        addressDetails details=addressDetails.newBuilder().setPostcode("postcode").setCity("city").build();
        Address addr=new Address();
        addr.setAddressId(1);
        when(repository.save(Mockito.any(Address.class))).thenReturn(addr);
        addAddressRequest request= addAddressRequest.newBuilder().setAddress(details).build();
        StreamRecorder<addAddressResponse> responseObserver=StreamRecorder.create();
        //failing the test if it takes too long to respond
        addressService.addAddress(request,responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<addAddressResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        addAddressResponse response=results.get(0);
        assertEquals(response.getAddressId(),1);
    }

}
