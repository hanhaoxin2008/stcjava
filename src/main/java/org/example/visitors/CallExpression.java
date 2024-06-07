package org.example.visitors;

import org.example.ASTnode;
import org.example.jsASTnode;
import org.example.visitor;

import java.util.ArrayList;

public class CallExpression extends visitor {
    public void enter(ASTnode node, ASTnode parent){
        jsASTnode jsNode = new jsASTnode();
        jsNode.type = "CallExpression";
        jsNode.callee = new jsASTnode();
        jsNode.callee.type = "Identifier";
        jsNode.callee.name = node.value;
        jsNode.arguments = new ArrayList<jsASTnode>();
        node.content=jsNode.arguments;
        if (! parent.type.equals("CallExpression")) {
            jsASTnode expression = new jsASTnode();
            expression.type = "ExpressionStatement";
            expression.expression = jsNode;
            parent.content.add(expression);
            return;
        }

        parent.content.add(jsNode);

    }
    public void exit(ASTnode node, ASTnode parent){

    }

}
