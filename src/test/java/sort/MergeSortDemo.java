package sort;
//归并排序是用分治思想，分治模式在每一层递归上有三个步骤：
//
//分解（Divide）：将n个元素分成个含n/2个元素的子序列。
//解决（Conquer）：用合并排序法对两个子序列递归的排序。
//合并（Combine）：合并两个已排序的子序列已得到排序结果。
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 1, 3, 9, 34, 27, 18, 28, 87, 73, 90};
        mergeSort(arr);
        for (int tmp : arr
        ) {
            System.out.println(tmp);
        }
    }

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {

        //对于递归，要处理递归到底的判断，这里就是left>=right。
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        //将左右两部分，利用临时数组进行归并
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        /*减去的left是原数组相对于临时数组的偏移量*/

        int[] temp = new int[right - left + 1];
        for (int k = left; k <= right; k++) {
            temp[k - left] = arr[k];
        }
        for (int k = left; k <= right; k++) {
//            左半边用尽
            if (i > mid) {
                arr[k] = temp[j - left];
                j++;
//            右半边用尽
            } else if (j > right) {
                arr[k] = temp[i - left];
                i++;
            } else if (temp[i - left] > temp[j - left]) {
                arr[k] = temp[j - left];
                j++;
            } else if (temp[i - left] <= temp[j - left]) {
                arr[k] = temp[i - left];
                i++;
            }
        }
    }
}
