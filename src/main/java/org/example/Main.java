package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {
        //获取命令行参数
        String filepath = args[0];
        //读取文件内容,io流

        String content = "";
        File inputFile = new File(filepath);
        String inputFileName = inputFile.getName();

        if (inputFileName.endsWith(".lsp") || inputFileName.endsWith(".lisp")) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(filepath));
                String line = "";
                while ((line = br.readLine())!= null) {
                    content += line + "\n";
                }
                //System.out.println(content);
            } catch (IOException e) {
                System.out.println("文件读取失败");
            }
            String output = toCode(content);
            //提取文件名
            String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf("."))+".js";
            //获取目录路径
            String outputFilePath = inputFile.getParent()+"\\";
            //写入文件
            try {
                File outputFile = new File(outputFilePath+outputFileName);
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }
                FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
                fw.write(output);
                fw.close();
            } catch (IOException e) {
                System.out.println("文件写入失败");
            }

        }else{
            System.out.println("文件格式不正确");
        }

    }
    private static String toCode(String input) {
        lat l = new lat();
        ArrayList<token> tokens = l.getTokenList(input);
        gat g = new gat();
        ASTnode ast = g.getAST(tokens);
        converter c = new converter();
        jsASTnode jsast = c.convertToJSASTnode(ast);
        codeGenerator cg = new codeGenerator();
        String output = cg.toCode(jsast);
        return output;
    }
}