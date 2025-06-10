import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.rest.TestRest;
import proto.Test;

public class PeformanceTest {
    private static final int ITERATIONS = 1000000;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void run () throws Exception{
        // Chuẩn bị dữ liệu test
        Test protoObj = Test.newBuilder()
                .setOne("Value 1")
                .setTwo("Value 2")
                .setThree("Value 3")
                .setFour("Value 4")
                .setFive("Value 5")
                .setSix("Value 6")
                .setSeven("Value 7")
                .setEight("Value 8")
                .setNine("Value 9")
                .setTen("Value 10")
                .build();

        TestRest testRest = new TestRest();
        testRest.setOne("Value 1");
        testRest.setTwo("Value 2");
        testRest.setThree("Value 3");
        testRest.setFour("Value 4");
        testRest.setFive("Value 5");
        testRest.setSix("Value 6");
        testRest.setSeven("Value 7");
        testRest.setEight("Value 8");
        testRest.setNine("Value 9");
        testRest.setTen("Value 10");

        // Warm up JVM
        for (int i = 0; i < 1000; i++) {
            protoObj.toByteArray();
            objectMapper.writeValueAsBytes(testRest);
        }

        System.out.println("Starting benchmark...");
        System.out.println("Iterations: " + ITERATIONS);
        System.out.println("-------------------");

        // Test Serialization
        long protoSerializationTime = testProtoSerialization(protoObj);
        long jsonSerializationTime = testJsonSerialization(testRest);

        // Test Deserialization
        byte[] protoBytes = protoObj.toByteArray();
        byte[] jsonBytes = objectMapper.writeValueAsBytes(testRest);

        long protoDeserializationTime = testProtoDeserialization(protoBytes);
        long jsonDeserializationTime = testJsonDeserialization(jsonBytes);

        // Calculate sizes
        int protoSize = protoBytes.length;
        int jsonSize = jsonBytes.length;

        // Print results
        System.out.println("\nResults:");
        System.out.println("Serialization Time (ms):");
        System.out.println("Protocol Buffers: " + protoSerializationTime);
        System.out.println("JSON: " + jsonSerializationTime);
        System.out.println("\nDeserialization Time (ms):");
        System.out.println("Protocol Buffers: " + protoDeserializationTime);
        System.out.println("JSON: " + jsonDeserializationTime);
        System.out.println("\nMessage Size (bytes):");
        System.out.println("Protocol Buffers: " + protoSize);
        System.out.println("JSON: " + jsonSize);
    }

    private static long testProtoSerialization(Test protoObj) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            protoObj.toByteArray();
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long testJsonSerialization(TestRest testRest) throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            objectMapper.writeValueAsBytes(testRest);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long testProtoDeserialization(byte[] bytes) throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            Test.parseFrom(bytes);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long testJsonDeserialization(byte[] bytes) throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            objectMapper.readValue(bytes, TestRest.class);
        }
        return System.currentTimeMillis() - startTime;
    }
}
