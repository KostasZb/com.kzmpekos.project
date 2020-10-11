package com.proto.commissions;

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
    comments = "Source: commission.proto")
public final class CommissionServerGrpc {

  private CommissionServerGrpc() {}

  public static final String SERVICE_NAME = "CommissionServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.commissions.AddCommissionRequest,
      com.proto.commissions.AddCommissionResponse> getAddCommissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCommission",
      requestType = com.proto.commissions.AddCommissionRequest.class,
      responseType = com.proto.commissions.AddCommissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.commissions.AddCommissionRequest,
      com.proto.commissions.AddCommissionResponse> getAddCommissionMethod() {
    io.grpc.MethodDescriptor<com.proto.commissions.AddCommissionRequest, com.proto.commissions.AddCommissionResponse> getAddCommissionMethod;
    if ((getAddCommissionMethod = CommissionServerGrpc.getAddCommissionMethod) == null) {
      synchronized (CommissionServerGrpc.class) {
        if ((getAddCommissionMethod = CommissionServerGrpc.getAddCommissionMethod) == null) {
          CommissionServerGrpc.getAddCommissionMethod = getAddCommissionMethod =
              io.grpc.MethodDescriptor.<com.proto.commissions.AddCommissionRequest, com.proto.commissions.AddCommissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCommission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.commissions.AddCommissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.commissions.AddCommissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommissionServerMethodDescriptorSupplier("addCommission"))
              .build();
        }
      }
    }
    return getAddCommissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.commissions.GetCommissionsRequest,
      com.proto.commissions.GetCommissionsResponse> getGetCommissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCommissions",
      requestType = com.proto.commissions.GetCommissionsRequest.class,
      responseType = com.proto.commissions.GetCommissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.commissions.GetCommissionsRequest,
      com.proto.commissions.GetCommissionsResponse> getGetCommissionsMethod() {
    io.grpc.MethodDescriptor<com.proto.commissions.GetCommissionsRequest, com.proto.commissions.GetCommissionsResponse> getGetCommissionsMethod;
    if ((getGetCommissionsMethod = CommissionServerGrpc.getGetCommissionsMethod) == null) {
      synchronized (CommissionServerGrpc.class) {
        if ((getGetCommissionsMethod = CommissionServerGrpc.getGetCommissionsMethod) == null) {
          CommissionServerGrpc.getGetCommissionsMethod = getGetCommissionsMethod =
              io.grpc.MethodDescriptor.<com.proto.commissions.GetCommissionsRequest, com.proto.commissions.GetCommissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCommissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.commissions.GetCommissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.commissions.GetCommissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommissionServerMethodDescriptorSupplier("getCommissions"))
              .build();
        }
      }
    }
    return getGetCommissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommissionServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommissionServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommissionServerStub>() {
        @java.lang.Override
        public CommissionServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommissionServerStub(channel, callOptions);
        }
      };
    return CommissionServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommissionServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommissionServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommissionServerBlockingStub>() {
        @java.lang.Override
        public CommissionServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommissionServerBlockingStub(channel, callOptions);
        }
      };
    return CommissionServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommissionServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommissionServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommissionServerFutureStub>() {
        @java.lang.Override
        public CommissionServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommissionServerFutureStub(channel, callOptions);
        }
      };
    return CommissionServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommissionServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void addCommission(com.proto.commissions.AddCommissionRequest request,
        io.grpc.stub.StreamObserver<com.proto.commissions.AddCommissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCommissionMethod(), responseObserver);
    }

    /**
     */
    public void getCommissions(com.proto.commissions.GetCommissionsRequest request,
        io.grpc.stub.StreamObserver<com.proto.commissions.GetCommissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCommissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddCommissionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.commissions.AddCommissionRequest,
                com.proto.commissions.AddCommissionResponse>(
                  this, METHODID_ADD_COMMISSION)))
          .addMethod(
            getGetCommissionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.commissions.GetCommissionsRequest,
                com.proto.commissions.GetCommissionsResponse>(
                  this, METHODID_GET_COMMISSIONS)))
          .build();
    }
  }

  /**
   */
  public static final class CommissionServerStub extends io.grpc.stub.AbstractAsyncStub<CommissionServerStub> {
    private CommissionServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommissionServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommissionServerStub(channel, callOptions);
    }

    /**
     */
    public void addCommission(com.proto.commissions.AddCommissionRequest request,
        io.grpc.stub.StreamObserver<com.proto.commissions.AddCommissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCommissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCommissions(com.proto.commissions.GetCommissionsRequest request,
        io.grpc.stub.StreamObserver<com.proto.commissions.GetCommissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCommissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommissionServerBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommissionServerBlockingStub> {
    private CommissionServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommissionServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommissionServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.commissions.AddCommissionResponse addCommission(com.proto.commissions.AddCommissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddCommissionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.commissions.GetCommissionsResponse getCommissions(com.proto.commissions.GetCommissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCommissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommissionServerFutureStub extends io.grpc.stub.AbstractFutureStub<CommissionServerFutureStub> {
    private CommissionServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommissionServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommissionServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.commissions.AddCommissionResponse> addCommission(
        com.proto.commissions.AddCommissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCommissionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.commissions.GetCommissionsResponse> getCommissions(
        com.proto.commissions.GetCommissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCommissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_COMMISSION = 0;
  private static final int METHODID_GET_COMMISSIONS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommissionServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommissionServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_COMMISSION:
          serviceImpl.addCommission((com.proto.commissions.AddCommissionRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.commissions.AddCommissionResponse>) responseObserver);
          break;
        case METHODID_GET_COMMISSIONS:
          serviceImpl.getCommissions((com.proto.commissions.GetCommissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.commissions.GetCommissionsResponse>) responseObserver);
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

  private static abstract class CommissionServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommissionServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.commissions.CommissionOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommissionServer");
    }
  }

  private static final class CommissionServerFileDescriptorSupplier
      extends CommissionServerBaseDescriptorSupplier {
    CommissionServerFileDescriptorSupplier() {}
  }

  private static final class CommissionServerMethodDescriptorSupplier
      extends CommissionServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommissionServerMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommissionServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommissionServerFileDescriptorSupplier())
              .addMethod(getAddCommissionMethod())
              .addMethod(getGetCommissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
