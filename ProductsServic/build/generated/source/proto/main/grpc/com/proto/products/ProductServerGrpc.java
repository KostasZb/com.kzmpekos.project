package com.proto.products;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: products.proto")
public final class ProductServerGrpc {

  private ProductServerGrpc() {}

  public static final String SERVICE_NAME = "ProductServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.products.AddProductRequest,
      com.proto.products.AddproductResponse> getAddProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddProduct",
      requestType = com.proto.products.AddProductRequest.class,
      responseType = com.proto.products.AddproductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.products.AddProductRequest,
      com.proto.products.AddproductResponse> getAddProductMethod() {
    io.grpc.MethodDescriptor<com.proto.products.AddProductRequest, com.proto.products.AddproductResponse> getAddProductMethod;
    if ((getAddProductMethod = ProductServerGrpc.getAddProductMethod) == null) {
      synchronized (ProductServerGrpc.class) {
        if ((getAddProductMethod = ProductServerGrpc.getAddProductMethod) == null) {
          ProductServerGrpc.getAddProductMethod = getAddProductMethod =
              io.grpc.MethodDescriptor.<com.proto.products.AddProductRequest, com.proto.products.AddproductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.products.AddProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.products.AddproductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServerMethodDescriptorSupplier("AddProduct"))
              .build();
        }
      }
    }
    return getAddProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.products.productsRequest,
      com.proto.products.ProductsResponse> getGetProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProducts",
      requestType = com.proto.products.productsRequest.class,
      responseType = com.proto.products.ProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.products.productsRequest,
      com.proto.products.ProductsResponse> getGetProductsMethod() {
    io.grpc.MethodDescriptor<com.proto.products.productsRequest, com.proto.products.ProductsResponse> getGetProductsMethod;
    if ((getGetProductsMethod = ProductServerGrpc.getGetProductsMethod) == null) {
      synchronized (ProductServerGrpc.class) {
        if ((getGetProductsMethod = ProductServerGrpc.getGetProductsMethod) == null) {
          ProductServerGrpc.getGetProductsMethod = getGetProductsMethod =
              io.grpc.MethodDescriptor.<com.proto.products.productsRequest, com.proto.products.ProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.products.productsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.products.ProductsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServerMethodDescriptorSupplier("GetProducts"))
              .build();
        }
      }
    }
    return getGetProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.products.productRequest,
      com.proto.products.productResponse> getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProduct",
      requestType = com.proto.products.productRequest.class,
      responseType = com.proto.products.productResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.products.productRequest,
      com.proto.products.productResponse> getGetProductMethod() {
    io.grpc.MethodDescriptor<com.proto.products.productRequest, com.proto.products.productResponse> getGetProductMethod;
    if ((getGetProductMethod = ProductServerGrpc.getGetProductMethod) == null) {
      synchronized (ProductServerGrpc.class) {
        if ((getGetProductMethod = ProductServerGrpc.getGetProductMethod) == null) {
          ProductServerGrpc.getGetProductMethod = getGetProductMethod =
              io.grpc.MethodDescriptor.<com.proto.products.productRequest, com.proto.products.productResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.products.productRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.products.productResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServerMethodDescriptorSupplier("GetProduct"))
              .build();
        }
      }
    }
    return getGetProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServerStub>() {
        @java.lang.Override
        public ProductServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServerStub(channel, callOptions);
        }
      };
    return ProductServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServerBlockingStub>() {
        @java.lang.Override
        public ProductServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServerBlockingStub(channel, callOptions);
        }
      };
    return ProductServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServerFutureStub>() {
        @java.lang.Override
        public ProductServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServerFutureStub(channel, callOptions);
        }
      };
    return ProductServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductServerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Adding one product
     * </pre>
     */
    public void addProduct(com.proto.products.AddProductRequest request,
        io.grpc.stub.StreamObserver<com.proto.products.AddproductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddProductMethod(), responseObserver);
    }

    /**
     * <pre>
     *Getting all the products
     * </pre>
     */
    public void getProducts(com.proto.products.productsRequest request,
        io.grpc.stub.StreamObserver<com.proto.products.ProductsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductsMethod(), responseObserver);
    }

    /**
     * <pre>
     *Getting one Product
     * </pre>
     */
    public void getProduct(com.proto.products.productRequest request,
        io.grpc.stub.StreamObserver<com.proto.products.productResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.products.AddProductRequest,
                com.proto.products.AddproductResponse>(
                  this, METHODID_ADD_PRODUCT)))
          .addMethod(
            getGetProductsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.products.productsRequest,
                com.proto.products.ProductsResponse>(
                  this, METHODID_GET_PRODUCTS)))
          .addMethod(
            getGetProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.products.productRequest,
                com.proto.products.productResponse>(
                  this, METHODID_GET_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class ProductServerStub extends io.grpc.stub.AbstractAsyncStub<ProductServerStub> {
    private ProductServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServerStub(channel, callOptions);
    }

    /**
     * <pre>
     *Adding one product
     * </pre>
     */
    public void addProduct(com.proto.products.AddProductRequest request,
        io.grpc.stub.StreamObserver<com.proto.products.AddproductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Getting all the products
     * </pre>
     */
    public void getProducts(com.proto.products.productsRequest request,
        io.grpc.stub.StreamObserver<com.proto.products.ProductsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProductsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Getting one Product
     * </pre>
     */
    public void getProduct(com.proto.products.productRequest request,
        io.grpc.stub.StreamObserver<com.proto.products.productResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductServerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductServerBlockingStub> {
    private ProductServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Adding one product
     * </pre>
     */
    public com.proto.products.AddproductResponse addProduct(com.proto.products.AddProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddProductMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Getting all the products
     * </pre>
     */
    public com.proto.products.ProductsResponse getProducts(com.proto.products.productsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProductsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Getting one Product
     * </pre>
     */
    public com.proto.products.productResponse getProduct(com.proto.products.productRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductServerFutureStub extends io.grpc.stub.AbstractFutureStub<ProductServerFutureStub> {
    private ProductServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Adding one product
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.products.AddproductResponse> addProduct(
        com.proto.products.AddProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Getting all the products
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.products.ProductsResponse> getProducts(
        com.proto.products.productsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProductsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Getting one Product
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.products.productResponse> getProduct(
        com.proto.products.productRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCT = 0;
  private static final int METHODID_GET_PRODUCTS = 1;
  private static final int METHODID_GET_PRODUCT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCT:
          serviceImpl.addProduct((com.proto.products.AddProductRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.products.AddproductResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCTS:
          serviceImpl.getProducts((com.proto.products.productsRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.products.ProductsResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct((com.proto.products.productRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.products.productResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProductServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.products.Products.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductServer");
    }
  }

  private static final class ProductServerFileDescriptorSupplier
      extends ProductServerBaseDescriptorSupplier {
    ProductServerFileDescriptorSupplier() {}
  }

  private static final class ProductServerMethodDescriptorSupplier
      extends ProductServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServerFileDescriptorSupplier())
              .addMethod(getAddProductMethod())
              .addMethod(getGetProductsMethod())
              .addMethod(getGetProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
