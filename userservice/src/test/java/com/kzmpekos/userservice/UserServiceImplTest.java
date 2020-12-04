package com.kzmpekos.userservice;

import com.kzmpekos.userservice.DomainLayer.repositories.UserRepository;
import com.kzmpekos.userservice.ApplicationLayer.services.UserServiceImpl;
import com.proto.users.*;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@SpringJUnitConfig(classes = TestConfiguration.class)
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @MockBean
    private UserRepository repository;

    @Test
    void signUpTest() throws Exception {

        User user=User.newBuilder().setUserId(1).build();
        com.kzmpekos.userservice.DomainLayer.entities.User usr=new com.kzmpekos.userservice.DomainLayer.entities.User();
        usr.setName("User");
        when(repository.save(Mockito.any(com.kzmpekos.userservice.DomainLayer.entities.User.class))).thenReturn(usr);
        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        //Creating a request
        SignUpRequest request= SignUpRequest.newBuilder().setUser(user).build();
        //REFERENCE: https://grpc.github.io/grpc-java/javadoc/io/grpc/testing/StreamRecorder.html
        StreamRecorder<SignUpResponse> responseObserver=StreamRecorder.create();
        //failing the test if it takes too long to respond
        userService.signUp(request,responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<SignUpResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        SignUpResponse response=results.get(0);
        assertEquals("User"+ usr.getName()+"successfully added",response.getResult());

    }

    @Test
    void getUserByEmailTest() throws Exception {
        com.kzmpekos.userservice.DomainLayer.entities.User user=new com.kzmpekos.userservice.DomainLayer.entities.User();
        user.setName("name");
        user.setUserId(1);
        user.setAddressId(1);
        user.setFarmer(true);
        user.setPassword("password");
        when(repository.findByEmail("Email")).thenReturn(user);
        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        //Creating a request
        getUserByEmailRequest request= getUserByEmailRequest.newBuilder().setEmail("Email").build();
        //REFERENCE: https://grpc.github.io/grpc-java/javadoc/io/grpc/testing/StreamRecorder.html
        StreamRecorder<getUserByEmailResponse> responseObserver=StreamRecorder.create();
        //failing the test if it takes too long to respond
        userService.getUserByEmail(request,responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<getUserByEmailResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        getUserByEmailResponse response=results.get(0);
        assertEquals(user.getAddressId(),response.getUser().getAddressId());
        assertEquals(user.getIsFarmer(),response.getUser().getIsFarmer());
        assertEquals(user.getPassword(),response.getUser().getPassword());
        assertEquals(user.getName(),response.getUser().getName());
        assertEquals(user.getUserId(),response.getUser().getUserId());
    }


    @Test
    void getUserById() throws Exception {
        com.kzmpekos.userservice.DomainLayer.entities.User user=new com.kzmpekos.userservice.DomainLayer.entities.User();
        user.setName("name");
        user.setUserId(1);
        user.setAddressId(1);
        user.setFarmer(true);
        user.setEmail("email");
        when(repository.findByUserId(1)).thenReturn(user);
        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        //Creating a request
        getUserByIdRequest request= getUserByIdRequest.newBuilder().setUserId(1).build();
        //REFERENCE: https://grpc.github.io/grpc-java/javadoc/io/grpc/testing/StreamRecorder.html
        StreamRecorder<getUserByIdResponse> responseObserver=StreamRecorder.create();
        //failing the test if it takes too long to respond
        userService.getUserById(request,responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)){
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<getUserByIdResponse> results=responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1,results.size());
        //Getting the result
        getUserByIdResponse response=results.get(0);
        assertEquals(user.getAddressId(),response.getUser().getAddressId());
        assertEquals(user.getIsFarmer(),response.getUser().getIsFarmer());
        assertEquals(user.getName(),response.getUser().getName());
        assertEquals(user.getUserId(),response.getUser().getUserId());
    }
}
