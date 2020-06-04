package sort;

//选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
// 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
// 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
// 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
// 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
public class SelectSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 7, 9, 10, -1};
        selectSort(arr);
        for (int tmp : arr
        ) {
            System.out.println(tmp);
        }
    }

    public static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }

            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }

        }
    }


}
