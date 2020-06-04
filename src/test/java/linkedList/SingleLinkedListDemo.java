package linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode heroNode1 = new HeroNode(1, "a", "b");
        HeroNode heroNode4 = new HeroNode(4, "a", "b");
        HeroNode heroNode2 = new HeroNode(2, "a", "b");
        HeroNode heroNode3 = new HeroNode(3, "a", "b");
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode4);
        list.addByOrder(heroNode2);
        list.addByOrder(heroNode3);
        HeroNode nHeroNode2 = new HeroNode(2, "aaa", "bbb");

        list.del(4);

//        System.out.println(list.list());
        System.out.println(list.list());
    }


}

class SingleLinkedList {
    //    init a head node, no data !
    private HeroNode head = new HeroNode(0, "", "");

    //    add node
//    不考虑顺序时 1. 找到最后node's next points to new node
    public void add(HeroNode node) {
// we need a tmp node
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);

                break;
            }
            temp = temp.getNext();
        }

    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;

        while (true) {
//            看下一个元素能不能insert
            if (temp.getNext() == null || temp.getNext().getNo() > heroNode.getNo()) {
                heroNode.setNext(temp.getNext());
                temp.setNext(heroNode);
                break;
            }
            if (temp.getNo() == heroNode.getNo()) {
                System.out.println("No has existed");
                break;
            }
            temp = temp.getNext();
        }
//        防止空list所以有flag

    }

    public String list() {
//        if null?
        String str = "";
        if (head.getNext() == null) {
            System.out.println("list is empty");

        }
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }

            str += temp.toString() + "\n";
            temp = temp.getNext();
        }
        return str;
    }

    //
    public void update(HeroNode newNode) {
        if (head.getNext() == null) {
            System.out.println("List is null");
            return;
        }
//        辅助node很重要
        HeroNode temp = head.getNext();
        while (true) {
//            遍历完了
            if (temp == null) {
                System.out.println("no this node");
                break;
            }
//            根据No来改
            if (temp.getNo() == newNode.getNo()) {
                System.out.println("has updated");
                temp.setName(newNode.getName());
                temp.setNickName(newNode.getNickName());
                break;
            }
            temp = temp.getNext();
        }

    }

    /*
    *
    * 从单链表中删除一个节点的思路
        1.  我们先找到 需要删除的这个节点的前一个节点 temp
        2.  temp.next = temp.next.next
        3   . 被删除的节点，将不会有其它引用指向，会被垃圾回收机制回收

    *
    *
    *
    * */
    public void del(int no) {
        HeroNode temp = head;
        while (true) {
            if (temp == null) {
                System.out.println("Delete failed");
                break;
            }
            if (temp.getNext().getNo() == no) {
                temp.setNext(temp.getNext().getNext());
                System.out.println("Delete successfully");
                break;
            }
            temp = temp.getNext();
        }
    }

    public static int length(HeroNode head) {
        HeroNode temp = head;
        int len = 0;
        if (head.getNext() == null) {
            return 0;
        }
        while (temp != null) {
            len++;
            temp = temp.getNext();
        }
        return len;

    }
// insert into head!
    public SingleLinkedList reverse() {
        if (head.getNext() == null) {
            System.out.println("list is empty");
            return new SingleLinkedList();
        }
        HeroNode temp = head;
        HeroNode next = null;
        temp = temp.getNext();
        HeroNode newHead = new HeroNode(0, "", "");
        while (temp != null) {
            next = temp.getNext();
            temp.setNext(newHead.getNext());
            newHead.setNext(temp);
            temp = next;
        }
        SingleLinkedList list = new SingleLinkedList();
        list.setHead(newHead);
        return list;
    }


    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }
}

class HeroNode {
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode copy() {
        return new HeroNode(getNo(), getName(), getNickName());
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}