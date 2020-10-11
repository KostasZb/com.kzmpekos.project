import com.kzmpekos.commissions.Commission;

import com.kzmpekos.commissionservice.CommissionServiceImpl;
import com.kzmpekos.util.HibernateUtil;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Building the server, listening on port 5002
        Server server= ServerBuilder.forPort(5003).addService(new CommissionServiceImpl()).build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{server.shutdown();
        }));
        server.awaitTermination();
    }
}
