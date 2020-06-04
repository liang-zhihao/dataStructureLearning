package stack;

public class ArrayStackDemo {


    public static void main(String[] args) throws CloneNotSupportedException {

    }
}

//实现 栈的 思路分析
//1. 使用数组来模拟栈
//2. 定义一个 top  来表示栈顶，初始化 为  -1
//3. 入栈的操作，当有数据加入到栈时， top++;  stack[top] = data;
//4. 出栈的操作， int value = stack[top]; top--, return value
//NOTE: 先定义full or empty 再搞其他
class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");

        }
        int val = stack[top];
        top--;
        return val;
    }

    //    from top
    public String list() throws CloneNotSupportedException {
        String str = "";

        for (int i = top; i >=0 ; i--) {
            str+=stack[i];

        }
        return str;
    }

}
