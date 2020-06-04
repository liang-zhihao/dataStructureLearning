package search;

public class insertValueSearchDemo {
    //插值查找算法的 举例说明
//
//数组  arr = [1, 2, 3, ......., 100]
//
//假如我们需要查找的值  1
//
//使用二分查找的话，我们需要多次递归，才能找到 1
//
//使用插值查找算法
//int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])
//
//int mid = 0 + (99 - 0) * (1 - 1)/ (100 - 1) = 0 + 99 * 0 / 99 = 0
//
//比如我们查找的值 100
//
//int mid = 0 + (99 - 0) * (100 - 1) / (100 - 1) = 0 + 99 * 99 / 99 = 0 + 99 = 99
    public static void main(String[] args) {
    int[] arr=new int[]{1,2,3};
        System.out.println(insertValueSearchByFor(arr,9));

    }

    public static int insertValueSearchByFor(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length - 1;
//        findval可能很大，影响mid求值，越界
        if (arr[arr.length - 1] < findVal || arr[0] > findVal) {
            return -1;
        }
        while (left <= right) {
            int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
            int midVal = arr[mid];
            if (findVal < midVal) {
                right = mid - 1;
            } else if (findVal > midVal) {
                left = mid + 1;
            } else if (findVal == midVal) {
                return mid;
            }
        }

        return -1;
    }
}
