package sparseArray;

import org.junit.Test;

//
//二维数组 转 稀疏数组的思路
//        1. 遍历  原始的二维数组，得到有效数据的个数 sum
//        2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
//        3. 将二维数组的有效数据数据存入到 稀疏数组
//
//        稀疏数组转原始的二维数组的思路
//
//        1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
//        2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.

public class SparseArray {
    public static void main(String[] args) {
//        create a original array 11*11
//        0:没棋子 1：黑子 2：白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row : chessArr1
        ) {
            for (int data : row
            ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();

        }
//        the idea to be sparseArray from 2D array
//        1.has  traversal of the 2D array to get the number of non-zero data
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }

            }
        }
        int[][] sparseArr = createSparseArr(chessArr1, 11, 11, sum);
        System.out.println(toStringArray(sparseArr));
        int[][] arr=toTowDArray(sparseArr);
        System.out.println(toStringArray(arr));

    }

    public static int[][] createSparseArr(int[][] chessArr, int row, int col, int sum) {
        int[][] sparseArr = new int[sum + 1][3];
//       the number of meaningful value, row and col saved in first row
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;
        int k = 1;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
//                2.has  traversal of the 2D array to get the number of non-zero data to save into sparseArr array
                if (chessArr[i][j] != 0) {
//                    save the position of the data
                    sparseArr[k][0] = i;
                    sparseArr[k][1] = j;
//                    save the value
                    sparseArr[k][2] = chessArr[i][j];
                    k++;
                }

            }
        }
        return sparseArr;

    }

    public static int[][] toTowDArray(int[][] sparseArr) {
/*
*
* 1.read the first row of the spareArr to create the original array(we can know row col and the number of useful data)
* 2.read the rest row of the spareArr to assign original array
*
*
*
* */
        int sum = sparseArr[0][2];
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] array = new int[row][col];
        for (int i = 0; i < sum; i++) {
            int tRow = sparseArr[i+1][0];
            int tCol = sparseArr[i+1][1];
            int value = sparseArr[i+1][2];
            array[tRow][tCol] = value;
        }
        return array;
    }

    public static String toStringArray(int[][] array) {
        String str = "";
        for (int[] row : array
        ) {
            for (int data : row
            ) {
                str += data + "\t";
            }
            str += "\n";
        }
        return str;
    }
}
