import com.kzmpekos.productservice.ProductServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Building the Grpc Server, listening to port 5001
        Server server= ServerBuilder.forPort(5001).addService(new ProductServiceImpl()).build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{server.shutdown();
        }));
        server.awaitTermination();
    }
}
