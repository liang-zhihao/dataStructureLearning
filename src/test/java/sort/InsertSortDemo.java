package sort;

//把n个待排序的元素看成为一个有序表和一个无序表，
// 开始时有序表中只包含一个元素，
// 无序表中包含有n-1个元素，
// 排序过程中每次从无序表中取出第一个元素，
// 把它的排序码依次与有序表元素的排序码进行比较，
// 将它插入到有序表中的适当位置，使之成为新的有序表。
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] arr =new int[]{3,2,4,7,9,10,-1};
        insertSort(arr);
        for (int tmp:arr
        ) {
            System.out.println(tmp);
        }
    }

    public static void insertSort(int[] arr) {
        int len = arr.length;
        int insertIndex, insertVal;
//        将第一个为有序表
        for (int i = 1; i < len; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
//            向前移动
            arr[insertIndex+1]=insertVal;
        }
    }
}
