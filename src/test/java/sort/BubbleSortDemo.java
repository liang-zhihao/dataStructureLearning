package sort;

//通过对待
//排序序列从前向后（从下标较小的元素开始）,依次比较
//相邻元素的值，若发现逆序则交换，使值较大
//的元素逐渐从前移向后部，就象水底下的气泡一样逐渐
//向上冒。
//
//因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下
//来没有进行过交换，就说明序列有序，因此要在排序过程中设置
//一个标志flag判断元素是否进行过交换。从而减少不必要的比较。(这里说的优化，可以在冒泡排序写好后，在进行)
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr =new int[]{3,2,4,7,9,10,-1};
        bubbleSort(arr);
        for (int tmp:arr
             ) {
            System.out.println(tmp);
        }
    }

    //    每排序一次确定最大值(最大值会一直向右交换)
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        if (len == 0 || len == 1) {
            return;
        }
//        一共len-1次排序，最后一个数不用排序
        for (int i = 0; i < len - 1; i++) {
//            越界
            int flag = 1;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = 0;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
//            优化，没交换break
            if (flag == 1) {
                break;
            }
        }

    }
}
