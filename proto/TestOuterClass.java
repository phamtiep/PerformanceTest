// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/test.proto

// Protobuf Java Version: 3.25.8
package proto;

public final class TestOuterClass {
  private TestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Test_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Test_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031src/main/proto/test.proto\"\221\001\n\004Test\022\013\n\003" +
      "one\030\001 \001(\t\022\013\n\003two\030\002 \001(\t\022\r\n\005three\030\003 \001(\t\022\014\n" +
      "\004four\030\004 \001(\t\022\014\n\004five\030\005 \001(\t\022\013\n\003six\030\006 \001(\t\022\r" +
      "\n\005seven\030\007 \001(\t\022\r\n\005eight\030\010 \001(\t\022\014\n\004nine\030\t \001" +
      "(\t\022\013\n\003ten\030\n \001(\tB\t\n\005protoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Test_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Test_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Test_descriptor,
        new java.lang.String[] { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
