package com.stack.PolandNotation;

import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.stack.PolandNotation.InfixIntoSuffiixExpression.calculate;
import static com.stack.PolandNotation.InfixIntoSuffiixExpression.getListString;

public class Test {
    public static void main(String[] args) {
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getListString(suffixExpression);
        System.out.println("list="+list);

        int res = calculate(list);
        System.out.println("计算的结果是"+res);

    }









}
