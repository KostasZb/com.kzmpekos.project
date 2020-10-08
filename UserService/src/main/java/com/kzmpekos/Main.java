package com.kzmpekos;

import com.kzmpekos.users.User;
import com.kzmpekos.userservice.UserServiceImpl;
import com.kzmpekos.util.HibernateUtil;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Building the server, listening on port 5002
        Server server= ServerBuilder.forPort(5002).addService(new UserServiceImpl()).build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{server.shutdown();
        }));
        server.awaitTermination();

    }
}
