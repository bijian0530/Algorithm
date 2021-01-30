package com.queue;

import java.util.Scanner;

public class ArrayQueueDemo{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key =' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s,显示队列");
            System.out.println("e,退出程序");
            System.out.println("a,添加数据到队列");
            System.out.println("g,从队列中取出数据");
            System.out.println("h,查看队头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.println("取出的数据是 "+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println("队列头的数据是 "+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满了");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //获取数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，没有数据！");
        }
        front++;
        return arr[front];
    }
    //显示所有队列的数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }
    //显示队列头的数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("没有数据！");
        }
        return arr[front++];
    }
}