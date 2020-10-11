// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: commission.proto

package com.proto.commissions;

/**
 * Protobuf type {@code AddCommissionRequest}
 */
public final class AddCommissionRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:AddCommissionRequest)
    AddCommissionRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AddCommissionRequest.newBuilder() to construct.
  private AddCommissionRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddCommissionRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AddCommissionRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AddCommissionRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.proto.commissions.Commission.Builder subBuilder = null;
            if (commission_ != null) {
              subBuilder = commission_.toBuilder();
            }
            commission_ = input.readMessage(com.proto.commissions.Commission.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(commission_);
              commission_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.proto.commissions.CommissionOuterClass.internal_static_AddCommissionRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.proto.commissions.CommissionOuterClass.internal_static_AddCommissionRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.proto.commissions.AddCommissionRequest.class, com.proto.commissions.AddCommissionRequest.Builder.class);
  }

  public static final int COMMISSION_FIELD_NUMBER = 1;
  private com.proto.commissions.Commission commission_;
  /**
   * <code>.Commission commission = 1;</code>
   * @return Whether the commission field is set.
   */
  @java.lang.Override
  public boolean hasCommission() {
    return commission_ != null;
  }
  /**
   * <code>.Commission commission = 1;</code>
   * @return The commission.
   */
  @java.lang.Override
  public com.proto.commissions.Commission getCommission() {
    return commission_ == null ? com.proto.commissions.Commission.getDefaultInstance() : commission_;
  }
  /**
   * <code>.Commission commission = 1;</code>
   */
  @java.lang.Override
  public com.proto.commissions.CommissionOrBuilder getCommissionOrBuilder() {
    return getCommission();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (commission_ != null) {
      output.writeMessage(1, getCommission());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (commission_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getCommission());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.proto.commissions.AddCommissionRequest)) {
      return super.equals(obj);
    }
    com.proto.commissions.AddCommissionRequest other = (com.proto.commissions.AddCommissionRequest) obj;

    if (hasCommission() != other.hasCommission()) return false;
    if (hasCommission()) {
      if (!getCommission()
          .equals(other.getCommission())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasCommission()) {
      hash = (37 * hash) + COMMISSION_FIELD_NUMBER;
      hash = (53 * hash) + getCommission().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.proto.commissions.AddCommissionRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.commissions.AddCommissionRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.proto.commissions.AddCommissionRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.commissions.AddCommissionRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.proto.commissions.AddCommissionRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code AddCommissionRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:AddCommissionRequest)
      com.proto.commissions.AddCommissionRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.proto.commissions.CommissionOuterClass.internal_static_AddCommissionRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.proto.commissions.CommissionOuterClass.internal_static_AddCommissionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.proto.commissions.AddCommissionRequest.class, com.proto.commissions.AddCommissionRequest.Builder.class);
    }

    // Construct using com.proto.commissions.AddCommissionRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (commissionBuilder_ == null) {
        commission_ = null;
      } else {
        commission_ = null;
        commissionBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.proto.commissions.CommissionOuterClass.internal_static_AddCommissionRequest_descriptor;
    }

    @java.lang.Override
    public com.proto.commissions.AddCommissionRequest getDefaultInstanceForType() {
      return com.proto.commissions.AddCommissionRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.proto.commissions.AddCommissionRequest build() {
      com.proto.commissions.AddCommissionRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.proto.commissions.AddCommissionRequest buildPartial() {
      com.proto.commissions.AddCommissionRequest result = new com.proto.commissions.AddCommissionRequest(this);
      if (commissionBuilder_ == null) {
        result.commission_ = commission_;
      } else {
        result.commission_ = commissionBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.proto.commissions.AddCommissionRequest) {
        return mergeFrom((com.proto.commissions.AddCommissionRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.proto.commissions.AddCommissionRequest other) {
      if (other == com.proto.commissions.AddCommissionRequest.getDefaultInstance()) return this;
      if (other.hasCommission()) {
        mergeCommission(other.getCommission());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.proto.commissions.AddCommissionRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.proto.commissions.AddCommissionRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.proto.commissions.Commission commission_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.proto.commissions.Commission, com.proto.commissions.Commission.Builder, com.proto.commissions.CommissionOrBuilder> commissionBuilder_;
    /**
     * <code>.Commission commission = 1;</code>
     * @return Whether the commission field is set.
     */
    public boolean hasCommission() {
      return commissionBuilder_ != null || commission_ != null;
    }
    /**
     * <code>.Commission commission = 1;</code>
     * @return The commission.
     */
    public com.proto.commissions.Commission getCommission() {
      if (commissionBuilder_ == null) {
        return commission_ == null ? com.proto.commissions.Commission.getDefaultInstance() : commission_;
      } else {
        return commissionBuilder_.getMessage();
      }
    }
    /**
     * <code>.Commission commission = 1;</code>
     */
    public Builder setCommission(com.proto.commissions.Commission value) {
      if (commissionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        commission_ = value;
        onChanged();
      } else {
        commissionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Commission commission = 1;</code>
     */
    public Builder setCommission(
        com.proto.commissions.Commission.Builder builderForValue) {
      if (commissionBuilder_ == null) {
        commission_ = builderForValue.build();
        onChanged();
      } else {
        commissionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Commission commission = 1;</code>
     */
    public Builder mergeCommission(com.proto.commissions.Commission value) {
      if (commissionBuilder_ == null) {
        if (commission_ != null) {
          commission_ =
            com.proto.commissions.Commission.newBuilder(commission_).mergeFrom(value).buildPartial();
        } else {
          commission_ = value;
        }
        onChanged();
      } else {
        commissionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Commission commission = 1;</code>
     */
    public Builder clearCommission() {
      if (commissionBuilder_ == null) {
        commission_ = null;
        onChanged();
      } else {
        commission_ = null;
        commissionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Commission commission = 1;</code>
     */
    public com.proto.commissions.Commission.Builder getCommissionBuilder() {
      
      onChanged();
      return getCommissionFieldBuilder().getBuilder();
    }
    /**
     * <code>.Commission commission = 1;</code>
     */
    public com.proto.commissions.CommissionOrBuilder getCommissionOrBuilder() {
      if (commissionBuilder_ != null) {
        return commissionBuilder_.getMessageOrBuilder();
      } else {
        return commission_ == null ?
            com.proto.commissions.Commission.getDefaultInstance() : commission_;
      }
    }
    /**
     * <code>.Commission commission = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.proto.commissions.Commission, com.proto.commissions.Commission.Builder, com.proto.commissions.CommissionOrBuilder> 
        getCommissionFieldBuilder() {
      if (commissionBuilder_ == null) {
        commissionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.proto.commissions.Commission, com.proto.commissions.Commission.Builder, com.proto.commissions.CommissionOrBuilder>(
                getCommission(),
                getParentForChildren(),
                isClean());
        commission_ = null;
      }
      return commissionBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:AddCommissionRequest)
  }

  // @@protoc_insertion_point(class_scope:AddCommissionRequest)
  private static final com.proto.commissions.AddCommissionRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.proto.commissions.AddCommissionRequest();
  }

  public static com.proto.commissions.AddCommissionRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddCommissionRequest>
      PARSER = new com.google.protobuf.AbstractParser<AddCommissionRequest>() {
    @java.lang.Override
    public AddCommissionRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AddCommissionRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddCommissionRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AddCommissionRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.proto.commissions.AddCommissionRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

