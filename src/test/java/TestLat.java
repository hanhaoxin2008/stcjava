import org.junit.jupiter.api.Test;
import org.example.lat;
import org.example.token;
//导入junit的断言
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestLat
{
    @Test
    public void testGetTokenList(){
        lat l = new lat();
        String input = "( \"aaa\" 111 aaa )";
        ArrayList<token> tokenList = l.getTokenList(input);
        for(token t : tokenList){
            System.out.println(t.type + " " + t.value);
        }
        //判断字符串相等
        assertEquals(tokenList.get(0).type, "paren");
        assertEquals(tokenList.get(0).value, "(");

        assertEquals(tokenList.get(1).type, "string");
        assertEquals(tokenList.get(1).value, "aaa");

        assertEquals(tokenList.get(2).type, "number");
        assertEquals(tokenList.get(2).value, "111");

        assertEquals(tokenList.get(3).type, "name");
        assertEquals(tokenList.get(3).value, "aaa");

        assertEquals(tokenList.get(4).type, "paren");
        assertEquals(tokenList.get(4).value, ")");
    }
}
