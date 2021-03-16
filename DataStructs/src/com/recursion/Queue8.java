package com.recursion;

public class Queue8 {
    int max =8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
        System.out.println(judgeCount);

    }

    /**
     * 编写方法放置皇后
     * @param n
     */
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }
    /**
     * 判断放置的皇后是否和之前的放生冲突
     * @param n
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(array[i] == array[n] || Math.abs(n - i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


}
