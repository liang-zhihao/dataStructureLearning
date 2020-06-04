package queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue=new CircleArrayQueue(5);
queue.push(5);

        System.out.println(queue.isFull());
        System.out.println(queue.size());
    }
}
class CircleArrayQueue {
    private int maxSize;
    //    the head of the queue
    private int front;
    //    the end of the queue
    private int rear;
    private int[] queue;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue=new int[maxSize];
//        point to the head of the queue,  指向队列的第一个元素 0也行
        front=0;
//        point to the end of the queue, point to the front of the data 指向队列最后一个元素的后一个位置，空出一个来判断
        rear=0;
    }
    public boolean isFull(){
        return (rear+1)%maxSize==front;
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
//        指向队列最后一个元素的后一个位置
//        2. rear++

        queue[rear]=n;
        rear++;
        rear%=maxSize;
    }
    public int pop(){
//        isEmpty?
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
//        front指向第一个元素
//        考虑取余
        int tmp=queue[front];
        front++;
        front%=maxSize;
        return tmp ;
    }

    @Override
    public String toString() {
//        1.isEmpty?
        if(isEmpty()){
            return "Queue is empty";
        }
//        有效数据个数为 rear-front +maxsize )%maxsize
        String str="";
        for (int i = front; i < front+size() ; i++) {
            str+=queue[i%maxSize]+"\t";
        }
        return str;
    }
    public int getHead(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else {
            return queue[front];
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}