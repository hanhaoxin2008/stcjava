package org.example;
import org.example.visitors.*;
import java.util.ArrayList;
public class converter {
    public void traverseNode(ASTnode node,ASTnode parent){
        //System.out.println(node.type+" "+node.value);
        if(node.type.equals("Program")){
            traverseTree(node.params, node);
        }else {
            try {
                String className = "org.example.visitors." + node.type;
                Class cls = Class.forName(className);
                visitor v = (visitor) cls.newInstance();
                v.enter(node, parent);
                switch (node.type) {
                    case "NumberLiteral":
                        break;
                    case "StringLiteral":
                        break;
                    case "CallExpression":
                        traverseTree(node.params, node);
                        break;
                    default:
                        throw new RuntimeException("Unknown node type: " + node.type);
                }
                v.exit(node, parent);
            }catch(ClassNotFoundException e){
                //throw new RuntimeException("Class not found: " + node.type);
                e.printStackTrace();
            }catch (IllegalAccessException e){
                //throw new RuntimeException("Could not instantiate class: " + node.type);
                e.printStackTrace();
            }catch (InstantiationException e){
                //throw new RuntimeException("Could not instantiate class: " + node.type);
                e.printStackTrace();
            }
        }
    }

    private void traverseTree(ArrayList<ASTnode> tree, ASTnode parent) {


        for (ASTnode node : tree) {
            traverseNode(node, parent);
        }
    }
    public jsASTnode convertToJSASTnode(ASTnode ast){
        jsASTnode jsTree = new jsASTnode();
        jsTree.type = "Program";
        jsTree.body=new ArrayList<jsASTnode>();
        ast.content=jsTree.body;
        traverseNode(ast,null);
        return jsTree;
    }
}






