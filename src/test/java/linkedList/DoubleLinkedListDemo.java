package linkedList;

public class DoubleLinkedListDemo {
}

class HeroNode2 {
    private int no;
    private String name;
    private String nickName;
    private HeroNode2 next;
    private HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode2 copy() {
        return new HeroNode2(getNo(), getName(), getNickName());
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
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

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }
}

class DoubleLinkedList {
    //    init a head node, no data !
    private HeroNode2 head = new HeroNode2(0, "", "");

    //    add node
//    不考虑顺序时 1. 找到最后node's next points to new node
    public void add(HeroNode2 node) {
// we need a tmp node
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                node.setPre(temp);
                break;
            }
            temp = temp.getNext();
        }

    }

    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;

        while (true) {
//            看下一个元素能不能insert
            if (temp.getNext() == null || temp.getNext().getNo() > heroNode.getNo()) {
                heroNode.setNext(temp.getNext());
                temp.getNext().setPre(heroNode);
                temp.setNext(heroNode);
                heroNode.setPre(temp);
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
        HeroNode2 temp = head.getNext();
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
    public void update(HeroNode2 newNode) {
        if (head.getNext() == null) {
            System.out.println("List is null");
            return;
        }
//        辅助node很重要
        HeroNode2 temp = head.getNext();
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
    * 直接自我删除

    *
    *
    *
    * */
    public void del(int no) {
        HeroNode2 temp = head;
        while (true) {
            if (temp == null) {
                System.out.println("Delete failed");
                break;
            }
            if (temp.getNo() == no) {
                temp.getPre().setNext(temp.getNext());
//                空指针警告
                if (temp.getNext() != null) {
                    temp.getNext().setPre(temp.getPre());
                }

                System.out.println("Delete successfully");
                break;
            }
            temp = temp.getNext();
        }
    }

    public static int length(HeroNode2 head) {
        HeroNode2 temp = head;
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
    public DoubleLinkedList reverse() {
        if (head.getNext() == null) {
            System.out.println("list is empty");
            return new DoubleLinkedList();
        }
        HeroNode2 temp = head;
        HeroNode2 next = null;
        temp = temp.getNext();
        HeroNode2 newHead = new HeroNode2(0, "", "");
        while (temp != null) {
            next = temp.getNext();
            temp.setNext(newHead.getNext());
            newHead.setNext(temp);
            temp = next;
        }
        linkedList.DoubleLinkedList list = new linkedList.DoubleLinkedList();
        list.setHead(newHead);
        return list;
    }


    public HeroNode2 getHead() {
        return head;
    }

    public void setHead(HeroNode2 head) {
        this.head = head;
    }
}

