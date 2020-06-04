package binaryTree;

public class arrayToBinaryTreeDemo {
    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,7};
        infixOrder(arr,0);

    }
    public static void infixOrder(int[] arr,int n){
        if(n>=7){
            return;
        }
        infixOrder(arr, 2*n+1);
        System.out.println(arr[n]);
        infixOrder(arr,2*n+2);

    }
}
