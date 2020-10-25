package com.proto.users;

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
    comments = "Source: user.proto")
public final class UserServerGrpc {

  private UserServerGrpc() {}

  public static final String SERVICE_NAME = "UserServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.users.SignUpRequest,
      com.proto.users.SignUpResponse> getSignUpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignUp",
      requestType = com.proto.users.SignUpRequest.class,
      responseType = com.proto.users.SignUpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.users.SignUpRequest,
      com.proto.users.SignUpResponse> getSignUpMethod() {
    io.grpc.MethodDescriptor<com.proto.users.SignUpRequest, com.proto.users.SignUpResponse> getSignUpMethod;
    if ((getSignUpMethod = UserServerGrpc.getSignUpMethod) == null) {
      synchronized (UserServerGrpc.class) {
        if ((getSignUpMethod = UserServerGrpc.getSignUpMethod) == null) {
          UserServerGrpc.getSignUpMethod = getSignUpMethod =
              io.grpc.MethodDescriptor.<com.proto.users.SignUpRequest, com.proto.users.SignUpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignUp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.users.SignUpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.users.SignUpResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServerMethodDescriptorSupplier("SignUp"))
              .build();
        }
      }
    }
    return getSignUpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.users.LogInRequest,
      com.proto.users.LogInResponse> getLogInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogIn",
      requestType = com.proto.users.LogInRequest.class,
      responseType = com.proto.users.LogInResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.users.LogInRequest,
      com.proto.users.LogInResponse> getLogInMethod() {
    io.grpc.MethodDescriptor<com.proto.users.LogInRequest, com.proto.users.LogInResponse> getLogInMethod;
    if ((getLogInMethod = UserServerGrpc.getLogInMethod) == null) {
      synchronized (UserServerGrpc.class) {
        if ((getLogInMethod = UserServerGrpc.getLogInMethod) == null) {
          UserServerGrpc.getLogInMethod = getLogInMethod =
              io.grpc.MethodDescriptor.<com.proto.users.LogInRequest, com.proto.users.LogInResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LogIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.users.LogInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.users.LogInResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServerMethodDescriptorSupplier("LogIn"))
              .build();
        }
      }
    }
    return getLogInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.users.getUserByEmailRequest,
      com.proto.users.getUserByEmailResponse> getGetUserByEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserByEmail",
      requestType = com.proto.users.getUserByEmailRequest.class,
      responseType = com.proto.users.getUserByEmailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.users.getUserByEmailRequest,
      com.proto.users.getUserByEmailResponse> getGetUserByEmailMethod() {
    io.grpc.MethodDescriptor<com.proto.users.getUserByEmailRequest, com.proto.users.getUserByEmailResponse> getGetUserByEmailMethod;
    if ((getGetUserByEmailMethod = UserServerGrpc.getGetUserByEmailMethod) == null) {
      synchronized (UserServerGrpc.class) {
        if ((getGetUserByEmailMethod = UserServerGrpc.getGetUserByEmailMethod) == null) {
          UserServerGrpc.getGetUserByEmailMethod = getGetUserByEmailMethod =
              io.grpc.MethodDescriptor.<com.proto.users.getUserByEmailRequest, com.proto.users.getUserByEmailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserByEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.users.getUserByEmailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.users.getUserByEmailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServerMethodDescriptorSupplier("GetUserByEmail"))
              .build();
        }
      }
    }
    return getGetUserByEmailMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServerStub>() {
        @java.lang.Override
        public UserServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServerStub(channel, callOptions);
        }
      };
    return UserServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServerBlockingStub>() {
        @java.lang.Override
        public UserServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServerBlockingStub(channel, callOptions);
        }
      };
    return UserServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServerFutureStub>() {
        @java.lang.Override
        public UserServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServerFutureStub(channel, callOptions);
        }
      };
    return UserServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void signUp(com.proto.users.SignUpRequest request,
        io.grpc.stub.StreamObserver<com.proto.users.SignUpResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSignUpMethod(), responseObserver);
    }

    /**
     */
    public void logIn(com.proto.users.LogInRequest request,
        io.grpc.stub.StreamObserver<com.proto.users.LogInResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogInMethod(), responseObserver);
    }

    /**
     */
    public void getUserByEmail(com.proto.users.getUserByEmailRequest request,
        io.grpc.stub.StreamObserver<com.proto.users.getUserByEmailResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserByEmailMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSignUpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.users.SignUpRequest,
                com.proto.users.SignUpResponse>(
                  this, METHODID_SIGN_UP)))
          .addMethod(
            getLogInMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.users.LogInRequest,
                com.proto.users.LogInResponse>(
                  this, METHODID_LOG_IN)))
          .addMethod(
            getGetUserByEmailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.users.getUserByEmailRequest,
                com.proto.users.getUserByEmailResponse>(
                  this, METHODID_GET_USER_BY_EMAIL)))
          .build();
    }
  }

  /**
   */
  public static final class UserServerStub extends io.grpc.stub.AbstractAsyncStub<UserServerStub> {
    private UserServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServerStub(channel, callOptions);
    }

    /**
     */
    public void signUp(com.proto.users.SignUpRequest request,
        io.grpc.stub.StreamObserver<com.proto.users.SignUpResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logIn(com.proto.users.LogInRequest request,
        io.grpc.stub.StreamObserver<com.proto.users.LogInResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserByEmail(com.proto.users.getUserByEmailRequest request,
        io.grpc.stub.StreamObserver<com.proto.users.getUserByEmailResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserByEmailMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServerBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServerBlockingStub> {
    private UserServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.users.SignUpResponse signUp(com.proto.users.SignUpRequest request) {
      return blockingUnaryCall(
          getChannel(), getSignUpMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.users.LogInResponse logIn(com.proto.users.LogInRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogInMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.users.getUserByEmailResponse getUserByEmail(com.proto.users.getUserByEmailRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserByEmailMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServerFutureStub extends io.grpc.stub.AbstractFutureStub<UserServerFutureStub> {
    private UserServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.users.SignUpResponse> signUp(
        com.proto.users.SignUpRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.users.LogInResponse> logIn(
        com.proto.users.LogInRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.users.getUserByEmailResponse> getUserByEmail(
        com.proto.users.getUserByEmailRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserByEmailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIGN_UP = 0;
  private static final int METHODID_LOG_IN = 1;
  private static final int METHODID_GET_USER_BY_EMAIL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIGN_UP:
          serviceImpl.signUp((com.proto.users.SignUpRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.users.SignUpResponse>) responseObserver);
          break;
        case METHODID_LOG_IN:
          serviceImpl.logIn((com.proto.users.LogInRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.users.LogInResponse>) responseObserver);
          break;
        case METHODID_GET_USER_BY_EMAIL:
          serviceImpl.getUserByEmail((com.proto.users.getUserByEmailRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.users.getUserByEmailResponse>) responseObserver);
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

  private static abstract class UserServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.users.UserOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserServer");
    }
  }

  private static final class UserServerFileDescriptorSupplier
      extends UserServerBaseDescriptorSupplier {
    UserServerFileDescriptorSupplier() {}
  }

  private static final class UserServerMethodDescriptorSupplier
      extends UserServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServerMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServerFileDescriptorSupplier())
              .addMethod(getSignUpMethod())
              .addMethod(getLogInMethod())
              .addMethod(getGetUserByEmailMethod())
              .build();
        }
      }
    }
    return result;
  }
}
