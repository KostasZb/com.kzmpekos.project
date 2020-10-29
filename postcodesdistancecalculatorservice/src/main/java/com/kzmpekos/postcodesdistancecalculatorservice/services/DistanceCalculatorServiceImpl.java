package com.kzmpekos.postcodesdistancecalculatorservice.services;

import com.kzmpekos.postcodesdistancecalculatorservice.PostcodesWithCoordinatesRepository;
import com.proto.distanceCalculator.distanceCalculatorServerGrpc;
import com.proto.distanceCalculator.getProductsWithDistanceRequest;
import com.proto.distanceCalculator.getProductsWithDistanceResponse;
import com.proto.distanceCalculator.productWithDistance;
import com.proto.products.Product;
import com.proto.users.User;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GRpcService
public class DistanceCalculatorServiceImpl extends distanceCalculatorServerGrpc.distanceCalculatorServerImplBase {
    @Autowired
    private PostcodesWithCoordinatesRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private AddressService addressService;
    @Autowired
    DistanceCalculatorService distanceCalculatorService;

    @Override
    public void getProductsWithDistance(getProductsWithDistanceRequest request, StreamObserver<getProductsWithDistanceResponse> responseObserver) {
        //Getting the user's Id
        int userId = request.getUserId();
        //Getting the user's address Id
        int userAddressId = userService.getUserWithId(userId).getAddressId();
        //Getting the user's postcode
        String userPostcode = addressService.getAddress(userAddressId).getPostcode();
        //Getting a list of all available products
        List<Product> products = productsService.getProducts();
        ArrayList<productWithDistance> productsWithDistance = new ArrayList<>();
        for (Product product : products
        ) {
            int farmerId=product.getFarmerId();
            User farmer=userService.getUserWithId(farmerId);
            String farmerPostcode=addressService.getAddress(farmer.getAddressId()).getPostcode();
            float distance=distanceCalculatorService.calculate(userPostcode,farmerPostcode);
            productWithDistance productWithDistance= com.proto.distanceCalculator.productWithDistance.newBuilder()
                    .setDistance(distance)
                    .setProductId(product.getProductId())
                    .setFarmerName(farmer.getName())
                    .setName(product.getName())
                    .setQuantity(product.getQuantity())
                    .setPricePerUnit(product.getPricePerUnit())
                    .build();
            productsWithDistance.add(productWithDistance);
        }

        getProductsWithDistanceResponse response=getProductsWithDistanceResponse.newBuilder().addAllProductWithDistance(productsWithDistance).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }
}
