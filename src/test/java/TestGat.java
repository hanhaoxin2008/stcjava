import org.junit.jupiter.api.Test;
import org.example.lat;
import org.example.token;
//导入junit的断言
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.example.gat;
import org.example.ASTnode;

public class TestGat
{
    @Test
    public void testGat(){
        String input ="(add (mul 2 3) (div 4 5))";
        lat l = new lat();
        ArrayList<token> tokens = l.getTokenList(input);
        for(token t : tokens){
            System.out.println(t.type + " " + t.value);
        }
        gat g = new gat();
        ASTnode ast = g.getAST(tokens);


        ast.tostring();

    }
}
