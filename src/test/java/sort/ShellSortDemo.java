package sort;



//希尔排序是把记录按下标的一定增量分组，
// 对每组使用直接插入排序算法排序；
// 随着增量逐渐减少，
// 每组包含的关键词越来越多，
// 当增量减至1时，
// 整个文件恰被分成一组，
// 算法便终止


public class ShellSortDemo {
    public static void main(String[] args) {
        int[] arr =new int[]{3,2,4,7,9,10,-1};
        shellSort(arr);
        for (int tmp:arr
        ) {
            System.out.println(tmp);
        }
    }

    public static void shellSort(int[] arr) {
        int len = arr.length, gap;
//        gap为增量
        for (int i = len / 2; i > 0; i /= 2) {
            gap = i;
            ShellInsertSort(arr,gap);
        }
    }

    public static void ShellInsertSort(int[] arr, int gap) {
        int arrLen = arr.length;
        int insertIndex, insertVal;
//        多少增量意味着多少内部插入排序
        for (int i = 0; i < gap; i++) {
            //        将第一个为有序表

            for (int j = i+gap; j < arrLen; j+=gap) {
                insertVal = arr[j];
                insertIndex = j - gap;
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex-=gap;
                }
//            向前移动
                arr[insertIndex + gap] = insertVal;
            }
        }

    }
}
