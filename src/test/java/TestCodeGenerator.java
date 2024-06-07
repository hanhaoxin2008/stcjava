import org.junit.jupiter.api.Test;
import org.example.lat;
import org.example.token;
//导入junit的断言
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.example.gat;
import org.example.ASTnode;
import org.example.converter;
import org.example.jsASTnode;
import org.example.codeGenerator;
public class TestCodeGenerator {
    @Test
    public void testToCode() {
        String input = "(add 1 2)";
        lat l = new lat();
        ArrayList<token> tokens = l.getTokenList(input);
        gat g = new gat();
        ASTnode ast = g.getAST(tokens);

        converter c = new converter();
        jsASTnode jsast = c.convertToJSASTnode(ast);
        codeGenerator cg = new codeGenerator();
        String output = cg.toCode(jsast);
        System.out.println(output);
    }
}
