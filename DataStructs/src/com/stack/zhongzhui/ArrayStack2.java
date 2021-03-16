package com.stack.zhongzhui;

import com.stack.ArrayStack.ArrayStack;

public class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
        }
        top++;
        stack[top] = value;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        int temp = stack[top];
        top--;
        return temp;
    }
    //遍历栈的情况
    public void list(){
        if (isEmpty()){
            System.out.println("栈中没有数据");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println("stack=["+stack[i]+"]");
        }
    }

    /**
     * 判断字符优先级
     * @return
     */
    public int priority(int opr){
        if (opr == '*' || opr == '/'){
            return 1;
        }
       else if (opr == '+' || opr == '-'){
            return 0;
        }else {
           return -1;
        }
    }

    /**
     * 判断是否是一个字符
     * @param val
     * @return
     */
    public boolean isOpr(char val){
        return val =='+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param opr
     * @return
     */
    public int cal(int num1,int num2,int opr){
        int res = 0;
        switch (opr){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}
