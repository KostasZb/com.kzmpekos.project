package com.kzmpekos.productsservice;

import com.kzmpekos.productsservice.DomainLayer.repositories.ProductRepository;
import com.kzmpekos.productsservice.ApplicationLayer.services.ProductServiceImpl;
import com.proto.products.*;
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
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @MockBean
    private ProductRepository repository;

    @Test
    void testAddProduct() throws Exception {
        //REFERENCE: https://yidongnan.github.io/grpc-spring-boot-starter/en/server/testing.html
        //Setting up the mock objects
        Product product = Product.newBuilder().setName("name").setFarmerId(1).setPricePerUnit(1).setQuantity(1).setProductId(1).build();
        com.kzmpekos.productsservice.DomainLayer.entities.Product prod = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        prod.setPricePerUnit(1);
        prod.setQuantity(1);
        prod.setProductId(1);
        prod.setName("name");
        prod.setFarmerId(1);
        when(repository.save(Mockito.any(com.kzmpekos.productsservice.DomainLayer.entities.Product.class))).thenReturn(prod);
        AddProductRequest request = AddProductRequest.newBuilder().setProduct(product).build();
        StreamRecorder<AddproductResponse> responseObserver = StreamRecorder.create();
        //failing the test if it takes too long to respond
        productService.addProduct(request, responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<AddproductResponse> results = responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1, results.size());
        //Getting the result
        AddproductResponse response = results.get(0);
        assertEquals("successfully added name. Quantity: 1", response.getResult());
    }

    @Test
    void testGetProducts() throws Exception {
        //Setting up mock objects
        com.kzmpekos.productsservice.DomainLayer.entities.Product product = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        product.setFarmerId(1);
        product.setName("Name");
        product.setProductId(1);
        product.setQuantity(1);
        product.setPricePerUnit(1);
        ArrayList<com.kzmpekos.productsservice.DomainLayer.entities.Product> productsList = new ArrayList<>();
        productsList.add(product);
        when(repository.findAll()).thenReturn(productsList);
        ProductsRequest request = ProductsRequest.newBuilder().build();
        StreamRecorder<ProductsResponse> responseObserver = StreamRecorder.create();
        //failing the test if it takes too long to respond
        productService.getProducts(request, responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<ProductsResponse> results = responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1, results.size());
        ProductsResponse response = results.get(0);
        assertEquals(1, response.getProducts(0).getFarmerId());
        assertEquals("Name", response.getProducts(0).getName());
        assertEquals(1, response.getProducts(0).getProductId());
        assertEquals(1, response.getProducts(0).getQuantity());
        assertEquals(1, response.getProducts(0).getPricePerUnit());
    }

    @Test
    void testGetProduct() throws Exception {
        //Setting up Mock objects
        com.kzmpekos.productsservice.DomainLayer.entities.Product product = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        product.setFarmerId(1);
        product.setName("Name");
        product.setProductId(1);
        product.setQuantity(1);
        product.setPricePerUnit(1);
        when(repository.findById(1)).thenReturn(java.util.Optional.of(product));
        ProductRequest request =ProductRequest.newBuilder().setProductId(1).build();
        StreamRecorder<ProductResponse> responseObserver = StreamRecorder.create();
        //failing the test if it takes too long to respond
        productService.getProduct(request, responseObserver);
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<ProductResponse> results = responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1, results.size());
        ProductResponse response = results.get(0);
        assertEquals(1,response.getProduct().getFarmerId());
        assertEquals("Name",response.getProduct().getName());
        assertEquals(1,response.getProduct().getProductId());
        assertEquals(1,response.getProduct().getQuantity());
        assertEquals(1,response.getProduct().getPricePerUnit());
    }

    @Test
    void testGetProductsByFarmerId() throws Exception {
        //Setting up Mock objects
        com.kzmpekos.productsservice.DomainLayer.entities.Product product = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        product.setFarmerId(1);
        product.setName("Name");
        product.setProductId(1);
        product.setQuantity(1);
        product.setPricePerUnit(1);
        ArrayList<com.kzmpekos.productsservice.DomainLayer.entities.Product> productsList = new ArrayList<>();
        productsList.add(product);
        when(repository.findAllByFarmerId(1)).thenReturn(productsList);
        ProductByFarmerIdRequest request=ProductByFarmerIdRequest.newBuilder().setFarmerId(1).build();
        StreamRecorder<ProductByFarmerIdResponse> responseObserver=StreamRecorder.create();
        productService.getProductsByFarmerId(request,responseObserver);
        //failing the test if it takes too long to respond
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<ProductByFarmerIdResponse> results = responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1, results.size());
        ProductByFarmerIdResponse response = results.get(0);
        assertEquals(1, response.getProducts(0).getFarmerId());
        assertEquals("Name", response.getProducts(0).getName());
        assertEquals(1, response.getProducts(0).getProductId());
        assertEquals(1, response.getProducts(0).getQuantity());
        assertEquals(1, response.getProducts(0).getPricePerUnit());
    }
    @Test
    void testDelete() throws Exception {
        //Setting up mock objects
        com.kzmpekos.productsservice.DomainLayer.entities.Product product = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        product.setFarmerId(1);
        product.setName("Name");
        product.setProductId(1);
        product.setQuantity(1);
        product.setPricePerUnit(1);
        when(repository.findByProductId(1)).thenReturn(product);
        deleteRequest request=deleteRequest.newBuilder().setProductId(1).build();
        StreamRecorder<deleteResponse> responseObserver=StreamRecorder.create();
        productService.delete(request,responseObserver);
        //failing the test if it takes too long to respond
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<deleteResponse> results = responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1, results.size());
        deleteResponse response = results.get(0);
        assertEquals("product deleted",response.getResponse());
        assertEquals(1,response.getProduct().getFarmerId());
        assertEquals("Name",response.getProduct().getName());
        assertEquals(1,response.getProduct().getProductId());
        assertEquals(1,response.getProduct().getQuantity());
        assertEquals(1,response.getProduct().getPricePerUnit());
    }
    @Test
    void testUpdate() throws Exception {
        //Setting up mock objects
        com.kzmpekos.productsservice.DomainLayer.entities.Product product = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        product.setFarmerId(1);
        product.setName("Name");
        product.setProductId(1);
        product.setQuantity(1);
        product.setPricePerUnit(1);
        when(repository.findById(1)).thenReturn(java.util.Optional.of(product));
        Product prod=Product.newBuilder().setFarmerId(1).setName("Name").setProductId(1).setQuantity(1).setPricePerUnit(1).build();
        UpdateRequest request=UpdateRequest.newBuilder().setProduct(prod).build();
        StreamRecorder<UpdateResponse> responseObserver=StreamRecorder.create();
        productService.update(request,responseObserver);
        //failing the test if it takes too long to respond
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<UpdateResponse> results = responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1, results.size());
        UpdateResponse response = results.get(0);
        assertEquals("product 1 updated successfully",response.getResponse());
    }
    @Test
    void testGetFarmerId() throws Exception {
        //Setting up Mock objects
        com.kzmpekos.productsservice.DomainLayer.entities.Product product = new com.kzmpekos.productsservice.DomainLayer.entities.Product();
        product.setFarmerId(1);
        product.setName("Name");
        product.setProductId(1);
        product.setQuantity(1);
        product.setPricePerUnit(1);
        when(repository.findByProductId(1)).thenReturn(product);
        GetFarmerIdRequest request=GetFarmerIdRequest.newBuilder().setProductId(1).build();
        StreamRecorder<GetFarmerIdResponse> responseObserver=StreamRecorder.create();
        productService.getFarmerId(request,responseObserver);
        //failing the test if it takes too long to respond
        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        //Getting a list of the results
        List<GetFarmerIdResponse> results = responseObserver.getValues();
        //asserting that the results contain 1 entry
        assertEquals(1, results.size());
        GetFarmerIdResponse response = results.get(0);
        assertEquals(1,response.getFarmerId());
    }
}
