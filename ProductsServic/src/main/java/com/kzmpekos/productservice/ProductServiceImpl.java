package com.kzmpekos.productservice;

import com.proto.products.*;
import io.grpc.stub.StreamObserver;
import com.kzmpekos.util.*;

import java.util.ArrayList;
import java.util.List;


public class ProductServiceImpl extends ProductServerGrpc.ProductServerImplBase {
    @Override
    public void addProduct(AddProductRequest request, StreamObserver<AddproductResponse> responseObserver) {
        Product product= request.getProduct();
        //Getting the values
        com.kzmpekos.products.Product prod=new com.kzmpekos.products.Product();
        prod.setName(product.getName());
        prod.setFarmerId(product.getFarmerId());
        prod.setPricePerUnit(product.getPricePerUnit());
        prod.setQuantity(product.getQuantity());
        //Saving the values into the db
        HibernateUtil util=new HibernateUtil();
        String result=util.addProduct(prod);
        //Creating and sending the response
        AddproductResponse response=AddproductResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(productRequest request, StreamObserver<productResponse> responseObserver) {
        int id=request.getProductId();
        com.kzmpekos.products.Product product= HibernateUtil.getProductById(id);
        //copying the values
        //REFERENCE:https://developers.google.com/protocol-buffers/docs/reference/java-generated
        Product prod= Product.newBuilder().setProductId(product.getProductId()).
                setName(product.getName()).setFarmerId(product.getFarmerId()).setQuantity(product.getQuantity()).
                setPricePerUnit((float)product.getPricePerUnit()).build();

        //Creating the response and completing the RPC
        productResponse response=productResponse.newBuilder().setProduct(prod).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProducts(productsRequest request, StreamObserver<ProductsResponse> responseObserver) {
        List<com.kzmpekos.products.Product> products=HibernateUtil.getAllProducts();
        //Copying the values
        ArrayList<Product> productsList=new ArrayList<>();
        for (com.kzmpekos.products.Product product:products
             ) {
            Product prod= Product.newBuilder().setProductId(product.getProductId()).
                    setName(product.getName()).setFarmerId(product.getFarmerId()).setQuantity(product.getQuantity()).
                    setPricePerUnit((float)product.getPricePerUnit()).build();
            productsList.add(prod);
        }
        //creating the response and completing the rpc
        ProductsResponse response=ProductsResponse.newBuilder().addAllProducts(productsList).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
