package search;

public class BinarySearchDemo {
    public static void main(String[] args) {

    }

    //二分查找的思路分析
//1. 首先确定该数组的中间的下标
//mid = (left + right) / 2
//2. 然后让需要查找的数 findVal 和 arr[mid] 比较
//2. 1 findVal > arr[mid] ,  说明你要查找的数在mid 的右边, 因此需要递归的向右查找
//2.2 findVal < arr[mid], 说明你要查找的数在mid 的左边, 因此需要递归的向左查找
//2.3  findVal == arr[mid] 说明找到，就返回
//
////什么时候我们需要结束递归.
//1) 找到就结束递归
//2) 递归完整个数组，仍然没有找到findVal ，也需要结束递归  当 left > right 就需要退出
    public static int binarySearchByRecursion(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal < midVal) {
            binarySearchByRecursion(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) {
            binarySearchByRecursion(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
        return -1;
    }

    public static int binarySearchByFor(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length - 1;
        if(arr[arr.length - 1]<findVal||arr[0]>findVal){
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = arr[mid];
            if (findVal < midVal) {
                right = mid - 1;
            } else if (findVal > midVal) {
                left = mid + 1;
            } else if (findVal == midVal){
                return mid;
            }
        }

        return -1;
    }
}
