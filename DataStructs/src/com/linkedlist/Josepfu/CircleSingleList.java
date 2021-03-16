package com.linkedlist.Josepfu;

public class CircleSingleList {
    private Boy first = null;

    //构建环形链表
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("输入的nums值不正确");
            return;
        }
        //构建辅助指针
        Boy curboy = new Boy(-1);
        for (int i = 0; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curboy = first;
            }else {
                curboy.setNext(boy);
                boy.setNext(first);
                curboy = boy;
            }
        }
    }


    //遍历当前环形链表
    public void showBoy(){
        if (first == null){
            System.out.println("没有数据");
            return;
        }

        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号"+curBoy.getNo()+".");
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    //根据用户的输入，计算出小孩的出圈顺序
    public void countBoy(int startNo,int countNum,int nums){
        if (first == null || startNo < 1 ||startNo >nums){
            System.out.println("参数输入错误");
            return;
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }


        //小孩开始报数，first和helper都向后移动counNum-1位，然后出圈
        while (true){
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈的小孩是"+first.getNo()+".");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("留在圈中的是"+first.getNo()+".");
    }


}
