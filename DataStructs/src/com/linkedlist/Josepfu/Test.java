package com.linkedlist.Josepfu;

public class Test {
    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.addBoy(5);
        circleSingleList.showBoy();
        System.out.println("============");
        circleSingleList.countBoy(1,2,5);  //2 4 1 5 3
    }
}
