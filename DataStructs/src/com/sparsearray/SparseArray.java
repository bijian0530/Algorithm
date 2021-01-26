package com.sparsearray;

/**
 * 稀疏数组的实现
 */

public class SparseArray {
    public static void main(String[] args) {
        //创建一个11*11的二位数组
        //0 没有棋子 ；1 黑子；2 蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始二位数组
        System.out.println("原始的二位数组>>>");
        for (int[] row:chessArr1
             ) {
            for (int data:row
                 ) {
                System.out.print(data+" ");
            }
            System.out.println();
        }

        //将数组转化成为稀疏数组
        //1.先遍历二位数组 得到非0值的个数
        int sum = 0;
        for (int i =0; i<chessArr1.length; i++){
            for (int j=0; j<chessArr1[i].length; j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二位数组，将非0的值放到数组中
        int count = 0;
        for (int i=0; i<chessArr1.length; i++){
            for (int j=0; j<chessArr1[i].length; j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //3.输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组表示>>>");
        for (int i =0; i<sparseArr.length; i++){
            System.out.println(sparseArr[i][0]+" "+sparseArr[i][1]+" "+sparseArr[i][2]);
        }

        //将稀疏数组恢复成为二位数组

        //1.创建原始二位数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.读取稀疏数组的数值，并传给二位数组
        for (int i=1; i< sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //遍历恢复后的二位数组
        for (int[] row:chessArr2
             ) {
            for (int data:row
                 ) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }
}
