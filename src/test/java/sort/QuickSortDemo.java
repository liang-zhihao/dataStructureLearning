package sort;

//这时候，跳出上面大的while循环之后，i和j肯定是相等的，因为上面循环的条件是i<j，所以，跳出循环时，i和j是相等的
//        /**
//         * 假如最好的情况是一个有序序列 1 3 5 7 9
//         * temp = 1
//         * i = 0    arr[i] = 1
//         * j = 4    arr[j] = 9
//         * 而且在这里，如果先从左边开始寻找的话，一直往右寻找大于1的数，直到i变成4还没有找到就停止了；但是下面的语句就会把9赋值在1上了
//         * 如果先从右边开始寻找的话，一直往左寻找小于1的数，直到j变成0还没有找到然后停止，此时i和j都是0，所以就是把自身交换一下并不影响顺序。
//         * 这也是为什么强调如果选择数组左边第一个数作为基准值的时候，得先从右边开始查找数。
//         */
//        // 最后将基准位与i和j相等位置的数字交换
//        // 下面的i和j其实相等的，所以用哪一个都一样。


//通过一趟排序将要排序的数据分割成独立的两部分，
// 其中一部分的所有数据都比另外一部分的所有数据都要小，
// 然后再按此方法对这两部分数据分别进行快速排序，
// 整个排序过程可以递归进行，
// 以此达到整个数据变成有序序列
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 1, 3, 9, 34, 27, 18, 28, 87, 73, 90};
        quickSort(arr);
        for (int tmp : arr
        ) {
            System.out.println(tmp);
        }
    }

    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        int start = left, end = right, temp;
        if (left > right) {
            return;
        }
        int basic = arr[left];
        while (start < end) {
//            别减过头了
            while (arr[end] >= basic && start < end) {
                end--;
            }
//            别加 过头了
            while (arr[start] <= basic && start < end) {
                start++;
            }
            if (start < end) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        arr[left] = arr[start];
        arr[start] = basic;
        sort(arr, left, start - 1);
        sort(arr, start + 1, right);
    }
}
