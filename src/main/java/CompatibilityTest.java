import proto.New;

public class CompatibilityTest {
    public static void run () throws Exception{
        Old old = Old.newBuilder().setAge(30).setName("Ha").build();
        byte[] sen = old.toByteArray();
        New  newObj = New.parseFrom(sen);
        System.out.println(newObj);
    }
}
