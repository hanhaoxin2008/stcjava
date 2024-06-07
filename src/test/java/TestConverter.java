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

public class TestConverter {
    @Test
    public void testTraverseNode() {
        String input = "(add (sub 2) 1 )";
        lat l = new lat();
        ArrayList<token> tokens = l.getTokenList(input);
        gat g = new gat();
        ASTnode ast = g.getAST(tokens);
        ast.tostring();
        converter c = new converter();
        jsASTnode jsast = c.convertToJSASTnode(ast);
        for (jsASTnode node : jsast.body){
            System.out.println(node.type);
        }
        jsASTnode e=jsast.body.get(0);
        System.out.println(e.type);
        System.out.println(e.expression);
        jsASTnode ca=e.expression;
        System.out.println(ca.type);
        System.out.println(ca.callee.type+" "+ca.callee.value);
        for (jsASTnode arg : ca.arguments){
            System.out.println(arg.type);
            System.out.println(arg.value);
        }



    }
        //
}

// cannot access a member of with package access的原因

