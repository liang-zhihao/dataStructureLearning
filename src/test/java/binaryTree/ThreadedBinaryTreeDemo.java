package binaryTree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
//        int[] tree = {1, 3, 6, 8, 10, 14};
        ThreadedBinaryTreeNode root = new ThreadedBinaryTreeNode(1);
        ThreadedBinaryTreeNode node2 = new ThreadedBinaryTreeNode(3);
        ThreadedBinaryTreeNode node3 = new ThreadedBinaryTreeNode(6);
        ThreadedBinaryTreeNode node4 = new ThreadedBinaryTreeNode(8);
        ThreadedBinaryTreeNode node5 = new ThreadedBinaryTreeNode(10);
        ThreadedBinaryTreeNode node6 = new ThreadedBinaryTreeNode(14);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
        tree.threadedNodes();
        System.out.println(node5.getLeft().getNo());

    }

}

class ThreadedBinaryTree {
    private ThreadedBinaryTreeNode root;
    private ThreadedBinaryTreeNode pre = null;
    public void threadedNodes(){
        threaded(root);
    }
    public void threaded(ThreadedBinaryTreeNode node) {
        if (node == null) {
            return;
        }
        threaded(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftNodeType(1);
        }
//        处理后驱node

        if (pre != null && pre.getRight() == null) {
//            前驱
            pre.setRight(node);
            pre.setRightNodeType(1);
        }
//        左边不需要 因为一直在向下递归 右边的后驱node 才要pre来指向后驱node
        pre = node;
        threaded(node.getRight());


    }

    public ThreadedBinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedBinaryTreeNode root) {
        this.root = root;
    }

    public ThreadedBinaryTreeNode getPre() {
        return pre;
    }

    public void setPre(ThreadedBinaryTreeNode pre) {
        this.pre = pre;
    }

    public ThreadedBinaryTree(ThreadedBinaryTreeNode root) {
        this.root = root;
    }
}

class ThreadedBinaryTreeNode {
    private ThreadedBinaryTreeNode left;
    private ThreadedBinaryTreeNode right;
    private int leftNodeType = 0;
    private int rightNodeType = 0;
    private int no;


    public ThreadedBinaryTreeNode(int no) {
        this.no = no;
    }


    public ThreadedBinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryTreeNode left) {
        this.left = left;
    }

    public ThreadedBinaryTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryTreeNode right) {
        this.right = right;
    }

    public int getLeftNodeType() {
        return leftNodeType;
    }

    public void setLeftNodeType(int leftNodeType) {
        this.leftNodeType = leftNodeType;
    }

    public int getRightNodeType() {
        return rightNodeType;
    }

    public void setRightNodeType(int rightNodeType) {
        this.rightNodeType = rightNodeType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}