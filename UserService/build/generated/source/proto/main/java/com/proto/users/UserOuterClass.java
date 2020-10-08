// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.proto.users;

public final class UserOuterClass {
  private UserOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SignUpRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SignUpRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SignUpResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SignUpResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LogInRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LogInRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LogInResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LogInResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserDetails_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserDetails_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nuser.proto\"$\n\rSignUpRequest\022\023\n\004user\030\001 " +
      "\001(\0132\005.User\" \n\016SignUpResponse\022\016\n\006result\030\001" +
      " \001(\t\"1\n\014LogInRequest\022!\n\013UserDetails\030\001 \001(" +
      "\0132\014.UserDetails\"$\n\rLogInResponse\022\023\n\004user" +
      "\030\001 \001(\0132\005.User\"k\n\004User\022\016\n\006userId\030\003 \001(\005\022\014\n" +
      "\004name\030\001 \001(\t\022\022\n\naddress_id\030\002 \001(\005\022\r\n\005email" +
      "\030\004 \001(\t\022\020\n\010password\030\005 \001(\t\022\020\n\010isFarmer\030\006 \001" +
      "(\010\".\n\013UserDetails\022\r\n\005email\030\001 \001(\t\022\020\n\010pass" +
      "word\030\002 \001(\t2c\n\nUserServer\022+\n\006SignUp\022\016.Sig" +
      "nUpRequest\032\017.SignUpResponse\"\000\022(\n\005LogIn\022\r" +
      ".LogInRequest\032\016.LogInResponse\"\000B\023\n\017com.p" +
      "roto.usersP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_SignUpRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SignUpRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SignUpRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_SignUpResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_SignUpResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SignUpResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_LogInRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_LogInRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LogInRequest_descriptor,
        new java.lang.String[] { "UserDetails", });
    internal_static_LogInResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_LogInResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LogInResponse_descriptor,
        new java.lang.String[] { "User", });
    internal_static_User_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_User_descriptor,
        new java.lang.String[] { "UserId", "Name", "AddressId", "Email", "Password", "IsFarmer", });
    internal_static_UserDetails_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_UserDetails_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserDetails_descriptor,
        new java.lang.String[] { "Email", "Password", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
