package org.example;
import org.example.ASTnode;

abstract public class visitor {
    abstract public void enter(ASTnode node, ASTnode parent);
    abstract public void exit(ASTnode node, ASTnode parent);
    public void visit() {
    }
}
