package hashTable;
//散列表（Hash table，也叫哈希表），是根据关键码值(Key value)而直接进行访问的数据结构。
// 也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
// 这个映射函数叫做散列函数，存放记录的数组叫做散列表。
public class HashTableDemo {
}

class Emp {
    private int id;
    private String name;
    private Emp next;

    public Emp() {
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (isEmpty()) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (curEmp.getNext() != null) {
            curEmp = curEmp.getNext();
        }
        curEmp.setNext(emp);
    }

    public void del(int id) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Emp curEmp = head;
        while (curEmp != null) {

            if (curEmp.getNext().getId() == id) {
                curEmp.setNext(curEmp.getNext().getNext());
                break;
            }
            curEmp = curEmp.getNext();
        }
    }

    public Emp find(int id) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        Emp curEmp = head;
        while (curEmp.getNext() != null) {

            if (curEmp.getId() == id) {
                return curEmp;
            }
            curEmp = curEmp.getNext();
        }
        return null;
    }

    public void list() {
        if (isEmpty()) {
            return;
        }
        Emp curEmp = head;
        while (curEmp.getNext() != null) {
            System.out.println(curEmp.toString());
            curEmp = curEmp.getNext();
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class HashTab {
    private int size;
    private EmpLinkedList[] arr;

    public HashTab(int size) {
        this.size = size;
        arr=new EmpLinkedList[size];
        for (int i = 0; i <size ; i++) {
            arr[i]=new EmpLinkedList();
        }
    }

    public int hashFun(int id) {
        return id % size;
    }

    public Emp find(int id) {
        int index = hashFun(id);
        return arr[index].find(id);
    }

    public void add(Emp emp) {
        int index = hashFun(emp.getId());
        arr[index].add(emp);
    }
    public void del(int id) {
        int index = hashFun(id);
        arr[index].del(id);
    }
    public void list(){
        for (int i = 0; i <size ; i++) {
            arr[i].list();
        }
    }
}