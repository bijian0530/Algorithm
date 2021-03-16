package com.stack.zhongzhui;

import com.stack.ArrayStack.ArrayStack;

public class Test {
    public static void main(String[] args) {
        String expression = "4+6*2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 oprStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int opr = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true){
            ch = expression.substring(index,index + 1).charAt(0);
            if (oprStack.isOpr(ch)){

                if (!oprStack.isEmpty()){

                    if (oprStack.priority(ch) <= oprStack.priority(oprStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opr = oprStack.pop();
                        res = numStack.cal(num1,num2,opr);
                        numStack.push(res);
                        oprStack.push(opr);
                    }else {
                        oprStack.push(ch);
                    }
                }else {
                    oprStack.push(ch);
                }
            }else {
                keepNum += ch;
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (oprStack.isOpr(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        while (true){
            if (oprStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            opr = oprStack.pop();
            res = numStack.cal(num1,num2,opr);
            numStack.push(res);
            int res2 =  numStack.pop();
            System.out.println("表达式的结果是["+res2+"]");
        }





    }
}
