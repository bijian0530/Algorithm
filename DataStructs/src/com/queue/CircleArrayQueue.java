package com.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        System.out.println("测试环形模拟数组");
        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("s,显示队列");
            System.out.println("e,退出程序");
            System.out.println("a,添加数据到队列");
            System.out.println("g,获取数据");
            System.out.println("h,查看头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res =queue.getQueue();
                        System.out.println(res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println(res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出");
    }
}
class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    public boolean isEmpty(){
        return rear == front;
    }
    public void addQueue(int a){
        if(isFull()){
            System.out.println("列表满了！");
            return;
        }
        arr[rear] = a;
        rear = (rear+1) % maxSize;
    }
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空的！");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("空的");
        }
        for (int i = front; i < front+size(); i++) {
            System.out.println(arr[i]);
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("空的");
        }
        return arr[front];
    }
}