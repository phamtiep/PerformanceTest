import proto.New;
import proto.Old;
import proto.ProtoTest;
import proto.Test;
import proto.ProtoTest.*;

public class CompatibilityTest {
    public static void run () throws Exception{
        Old old = Old.newBuilder().setAge(30).setName("Ha").build();
        byte[] sen = old.toByteArray();
        New  newObj = New.parseFrom(sen);
    }
}
