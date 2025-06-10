import proto.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.rest.TestRest;
import proto.Test;

import java.util.ArrayList;
import java.util.List;
public class TestSerializer {
    public  static void run() throws Exception{
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
        byte[] sen = protoObj.toByteArray();
        System.out.println(sen);
        Test de = Test.parseFrom(sen);
        System.out.println(de);
    }
}
