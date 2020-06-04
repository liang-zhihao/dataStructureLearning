package search;

import java.util.Arrays;

public class FibonacciSearchDemo {
    public static void main(String[] args) {

    }

    //    斐波那契查找原理与前两种相似，仅仅改变了中间结点（mid）的位置，mid不再是中间或插值得到，而是位于黄金分割点附近，即mid=low+F(k-1)-1（F代表斐波那契数列），如下图所示
//
//对F(k-1)-1的理解：
//由斐波那契数列 F[k]=F[k-1]+F[k-2] 的性质，可以得到 （F[k]-1）=（F[k-1]-1）+（F[k-2]-1）+1 。该式说明：只要顺序表的长度为F[k]-1，则可以将该表分成长度为F[k-1]-1和F[k-2]-1的两段，即如上图所示。从而中间位置为mid=low+F(k-1)-1
//
//类似的，每一子段也可以用相同的方式分割
//但顺序表长度n不一定刚好等于F[k]-1，所以需要将原来的顺序表长度n增加至F[k]-1。这里的k值只要能使得F[k]-1恰好大于或等于n即可，由以下代码得到,顺序表长度增加后，新增的位置（从n+1到F[k]-1位置），都赋为n位置的值即可。
    public static int FibonacciSearchByFor(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length - 1;
//        分割点
        int k = 0;
        int mid = 0;
        int f[] = fib();
        while (right > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        while (left <= right) {
            mid = left + f[k - 1] + 1;
            if (findVal < temp[mid]) {
                right = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                left = mid + 1;
                k -= 2;
            } else if (findVal == temp[mid]) {
//              有无越界
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }

            }
        }
        return -1;
    }

    public static int[] fib() {
        int size = 20;
        int[] f = new int[size];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < size - 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;

    }
}
