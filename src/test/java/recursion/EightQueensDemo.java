package recursion;

public class EightQueensDemo {
    private static int count = 0;

    public static void main(String[] args) {
//        map[i]=val means put queen in No.i row No.val col
        int[] map = new int[8];
        check(map,0);
        System.out.println(count);
    }
//1) 第一个皇后先放第一行第一列
//2) 第二个皇后放在第二行第一列、然后判断是否OK[即判断是冲突]， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
//3) 继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
//4) 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
//5) 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤
    public static void showResult(int[] map) {
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if(map[i]==j){
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
                System.out.printf(" ");

            }
            System.out.println();
        }
        count++;
        for (int i = 0; i < 8; i++) {
            System.out.print(map[i] + " ");
        }
        System.out.println();
        System.out.println("========================");
    }
//    put No. 8 queens
    public static void check(int[] map, int n) {
        if (n == 8) {
            showResult(map);
            return;
        }
//        col loop
        for (int i = 0; i < 8; i++) {
            map[n] = i;
            if (!isConflictive(map, n)) {
//                move to next row
                check(map, n + 1);
            }
        }
    }



    public static boolean isConflictive(int[] map, int n) {
        for (int j = 0; j < n; j++) {
            if (map[j] == map[n] || Math.abs(j - n) == Math.abs(map[j] - map[n])) {
                return true;
            }

        }
        return false;
    }


}
