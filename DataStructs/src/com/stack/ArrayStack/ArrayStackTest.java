package com.stack.ArrayStack;

import java.util.Scanner;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show: 表示入栈");
            System.out.println("exit: 表示退出");
            System.out.println("push: 表示数据添加到栈");
            System.out.println("pop: 表示数据离开栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":

                     int res = arrayStack.pop();
                     System.out.println("出栈的数字是["+res+"]");

                 break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
