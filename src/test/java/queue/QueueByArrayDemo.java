package queue;

import org.junit.Test;

//思路如下:
//        1.  front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
//        front 的初始值 = 0
//        2.  rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
//        rear 的初始值 = 0
//        3. 当队列满时，条件是  (rear  + 1) % maxSize == front 【满】
//        4. 对队列为空的条件， rear == front 空
//        5. 当我们这样分析， 队列中有效的数据的个数   (rear + maxSize - front) % maxSize   // rear = 1 front = 0
//        6. 我们就可以在原来的队列上修改得到，一个环形队列
//对前面的数组模拟队列的优化，充分利用数组. 因此将数组看做是一个环形的。(通过取模的方式来实现即可)
public class QueueByArrayDemo {
    @Test
    public void test(){
        CircleArrayQueue arrayQueue=new CircleArrayQueue(10);
//        arrayQueue.push(1);
//        System.out.println(arrayQueue.toString());
//        arrayQueue.push(2);
        arrayQueue.pop();
        System.out.println(arrayQueue.toString());
    }
}
class ArrayQueue{
    private int maxSize;
//    the head of the queue
    private int front;
//    the end of the queue
    private int rear;
    private int[] queue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue=new int[maxSize];
//        point to the head of the queue, point to the front of the data 指向队列头的前一个位置 0也行
        front=-1;
//        point to the end of the queue, point to the front of the data 指向队列尾的位置，最后一个数据
        rear=-1;
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }
    public boolean isEmpty(){
//        when the data was pushed, rear will +1.
//        when the data pop, front will +1.
        return rear==front;
    }
    public void push(int n){
//        1. isFull?
        if(isFull()){
            System.out.println("queue is full!");
            return;
        }
//        rear points to the last data
//        2. rear++
        rear++;
        queue[rear]=n;
    }
    public int pop(){
//        isEmpty?
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        front++;
        return queue[front] ;
    }

    @Override
    public String toString() {
//        1.isEmpty?
        if(isEmpty()){
            return "Queue is empty";
        }
        String str="";
        for (int i = front+1; i <= rear ; i++) {
            str+=queue[i]+"\t";
        }
        return str;
    }
    public int getHead(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else {
            return queue[front+1];
        }
    }
}
