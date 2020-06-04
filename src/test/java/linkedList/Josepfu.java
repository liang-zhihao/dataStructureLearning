package linkedList;

import java.util.ArrayList;
import java.util.List;

//Josephu  问题为：设编号为1，2，… n的n个人围坐一圈
// 约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列
// 它的下一位又从1开始报数，数到m的那个人又出列
// 依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
//
//提示
//用一个不带头结点的循环链表来处理Josephu 问题：先构成
// 一个有n个结点的单循环链表，然后由k结点起从1开始计数
// ，计到m时，对应结点从链表中删除，然后再从被删除结点的下一个结点又从1开始计数，直到最后一个结点从链表中删除算法结束。
public class Josepfu {
    public static void main(String[] args) {

        JosepfuProblem(5,1,3);
    }

    public static List<Integer> JosepfuProblem(int num, int key, int m) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.add(5);
        int count = 0;
        Boy curBoy = list.getFirst();
        Boy first = list.getFirst();
        List<Integer> ans = new ArrayList<Integer>();
        while (true) {
            if(curBoy==curBoy.getNext()){
                System.out.println(curBoy.getNo());
                break;
            }
            count++;
            if (count + 1 == m) {
                int number = curBoy.getNext().getNo();
                curBoy.setNext(curBoy.getNext().getNext());
                ans.add(number);
                System.out.println(number);
                count=0;
            }
            curBoy=curBoy.getNext();
        }

        return ans;
    }
}

class CircleSingleLinkedList {
    //    create a first node,no node
    private Boy first = new Boy(-1);

    public Boy getFirst() {
        return first;
    }

    public void setFirst(Boy first) {
        this.first = first;
    }

    public void add(int nums) {
        if (nums < 1) {
            System.out.println("No is wrong");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
//                first自己成环
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                curBoy = curBoy.getNext();
                curBoy.setNext(first);
            }


        }

    }

    public String list() {
        String str = "";
        if (first == null) {
            System.out.println("list is null");
            return "";
        }
        Boy curBoy = first;
        while (true) {
            str += curBoy.toString() + " ";

            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
        return str;
    }
}

class Boy {
    private int no;
    private Boy next;

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

    public Boy(int no) {
        this.no = no;

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
