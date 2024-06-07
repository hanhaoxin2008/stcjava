package org.example;
import org.example.jsASTnode;

public class codeGenerator {
    public String toCode(jsASTnode node){
        switch(node.type){
            case "Program":
                return node.body.stream().map(this::toCode).reduce("", (a, b) -> a.isEmpty()?b:a +"\n"+ b);
            case "ExpressionStatement":
                return toCode(node.expression)+";";

            case "CallExpression":
                return (toCode(node.callee)+
                        "("+node.arguments.stream().map(this::toCode).reduce("", (a, b) ->a.isEmpty()?b:a+","+b)
                        +")");

            case "Identifier":
                return node.name;
            case "NumberLiteral":
                return node.value;
            case "StringLiteral":
                return "\""+node.value+"\"";
        }
        return null;
    }

}
// 解释return node.body.stream().map(this::toCode).reduce("", (a, b) -> a + b);
// 这段代码的作用是将node.body中的每一个元素都用toCode方法转换成代码，然后用reduce方法将所有代码合并成一个字符串。
