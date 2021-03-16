package com.stack.PolandNotation;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.zip.Adler32;

import static com.stack.PolandNotation.Operation.getValue;

public class InfixIntoSuffiixExpression {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List="+infixExpressionList);

        List<String> suffixExpressionList = parseSuffixExresssionList(infixExpressionList);
        System.out.println("后缀表达式对应的List="+suffixExpressionList);

        System.out.println("最终的运算结果是"+calculate(suffixExpressionList));
    }


    /**
     * 将中缀List转成成为后缀List
     * @param ls
     * @return
     */
    private static List<String> parseSuffixExresssionList(List<String> ls) {
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        for (String item:ls) {
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size()!=0 && getValue(s1.peek()) >= getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        return s2;
    }




    /**
     * 将中缀表达式转化成为List
     * @param s
     * @return
     */
    private static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<String >();
        int i =0;
        String str;
        char c;
        do{
            if ((c= s.charAt(i)) < 48 || (c= s.charAt(i))>57){
                list.add(""+c);
                i++;
            }else{
                str = "";
                while(i<s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }while (i < s.length());
            return list;
        }





    /**
     * 将后缀表达式放到ArrayList中去
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele:split
        ) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 计算逆波兰表达式
     * @param ls
     * @return
     */
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item:ls) {
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                //pop出两个数，然后在压栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符出现了错误");
//                   System.out.println("运算符出现了错误");
                }
                stack.push(" "+ res);
            }
        }
        //最后留在stack中的数据就是最后的运算结果
        return Integer.parseInt(stack.pop());
    }
}



class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}