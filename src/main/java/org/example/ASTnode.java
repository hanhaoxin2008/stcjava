package org.example;

import java.util.ArrayList;
import org.example.jsASTnode;
public class ASTnode {
    public String value;
    public String type;
    public ArrayList<ASTnode> params;
    public ArrayList<jsASTnode> content;

    public   ASTnode(String value, String type,boolean haveChildren) {
        this.value = value;
        this.type = type;
        if (haveChildren) {
            ArrayList<ASTnode> temp = new ArrayList<ASTnode>();
            this.params = temp;
        }
        else {
            this.params = null;
        }
    }
    public void tostring() {
        System.out.println("value: " + value);
        System.out.println("type: " + type);
        if (params != null) {
            System.out.println("params: ");
            System.out.println("******"+value+"*******");

            for (ASTnode node : params) {
                if (node != null) {
                    node.tostring();

                }
            }
            System.out.println("******"+value+"*******");



        }


    }
}
