package org.example.visitors;

import org.example.ASTnode;
import org.example.jsASTnode;
import org.example.visitor;

public class NumberLiteral extends visitor {
    public void enter(ASTnode node, ASTnode parent){
        jsASTnode jsNode = new jsASTnode();
        jsNode.type = "NumberLiteral";
        jsNode.value=node.value;
        parent.content.add(jsNode);

    }
    public void exit(ASTnode node, ASTnode parent){

    }
}