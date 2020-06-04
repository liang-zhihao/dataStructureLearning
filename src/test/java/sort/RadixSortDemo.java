package sort;
//将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
public class RadixSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 1, 3, 9, 34, 27, 18, 28, 87, 73, 90};
        radixSort(arr);
        for (int tmp : arr
        ) {
            System.out.println(tmp);
        }
    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
//        确定有效数据长度，注意清零
        int[] elementCounts = new int[10];
        int max = arr[0], len = arr.length;
// 确定排序多少次
        for (int i = 1; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxDig = (max + "").length();

        for (int i = 0; i < maxDig; i++) {
            for (int j = 0; j < len; j++) {
//                根据位数的数字决定装桶
                int digitOfEle = arr[j] / (int)Math.pow(10,i) % 10;
                bucket[digitOfEle][elementCounts[digitOfEle]++] = arr[j];

            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                if (elementCounts[j] != 0) {
                    for (int k = 0; k < elementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
//清零
                elementCounts[j] = 0;
            }
        }


    }
}
