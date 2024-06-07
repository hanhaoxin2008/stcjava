package org.example;
import org.example.ASTnode;
import org.example.token;
import java.util.ArrayList;

public class gat {
    private int currentTokenIndex ;
    private ArrayList<token> tokens ;
    public ASTnode getAST(ArrayList<token> tokens) {
        this.tokens = tokens ;
        this.currentTokenIndex = 0 ;
        ASTnode root = new ASTnode(null,"Program",true);
        while(currentTokenIndex<tokens.size()){
            root.params.add(walk());
        }
        return root ;
    }
    private ASTnode walk() {
        token t=tokens.get(currentTokenIndex);
        if(t.type.equals("number")){
            currentTokenIndex++;
            return new ASTnode(t.value,"NumberLiteral",false);
        }
        else if(t.type.equals("string")) {
            currentTokenIndex++;
            return new ASTnode(t.value, "StringLiteral", false);

        }

        if(t.type.equals("paren")&&t.value.equals("(")){
            currentTokenIndex++;
            t=tokens.get(currentTokenIndex);
            ASTnode node=new ASTnode(
                    t.value,
                    "CallExpression",
                    true);
            currentTokenIndex++;
            t=tokens.get(currentTokenIndex);

            while(!t.type.equals("paren")||!t.value.equals(")")){
                node.params.add(walk());
                t=tokens.get(currentTokenIndex);
            }

            currentTokenIndex++;
            return node;

        }

        currentTokenIndex++;
        return null ;
    }
}
