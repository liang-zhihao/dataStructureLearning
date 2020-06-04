package binaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new BinaryTreeNode(3));
    }
}

class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        }
        return null;

    }

    public BinaryTreeNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        }
        return null;

    }

    public BinaryTreeNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        }
        return null;

    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }

    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }

    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }

    }

    public void del(int no) {
        if (root != null) {
            if (no == root.getNo()) {
                root = null;
            } else {
                root.del(no);
            }
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
}

class BinaryTreeNode {
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int no;

    public BinaryTreeNode(int no) {
        this.no = no;
    }

    public void del(int no) {
        if (left != null && left.getNo() == no) {
            left = null;
            return;
        }
        if (right != null && right.getNo() == no) {
            right = null;
            return;
        }
        if(left!=null){
            this.left.del(no);
        }
        if(right!=null){
            this.right.del(no);
        }

    }

    public BinaryTreeNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }

        BinaryTreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;

    }

    public BinaryTreeNode infixOrderSearch(int no) {


        BinaryTreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (this.no == no) {
            return this;
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;

    }

    public BinaryTreeNode postOrderSearch(int no) {

        BinaryTreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (this.no == no) {
            return this;
        }

        return resNode;

    }

    public void preOrder() {
        System.out.println(this.no);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    public void infixOrder() {


        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this.no);
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void postOrder() {


        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
        System.out.println(this.no);
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
