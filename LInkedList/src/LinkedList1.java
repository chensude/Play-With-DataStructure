/**
 * 实现LinkedList
 */
public class LinkedList<E extends Comparable<E>> {

    class Node {
        private E e;
        private Node next;

        public Node(E e) {
            this.e = e;
            next =null;
        }


        public Node(E e,Node next) {
            this.e=e;
            this.next = next;
        }
    }

    private int size;
    private Node head;

    public LinkedList() {
        head =null;
        size=0;
    }

    /**
     * 像链表的头添加元素
     * @param e
     */
    public void addFirst(E e) {
//        Node node= new Node(e);
//        node.next=head;
//        head=node;
        head = new Node(e,head);
        size++;
    }

    /**
     * 往链表index处添加元素
     * @return
     */
    public void add(E e,int index) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("非法参数");
        }
        if(index==0) {
            addFirst(e);
        }
        Node pre =head;
        //找到索引前一个位置
        for(int i=0;i<index-1;i++) {
            pre = pre.next;
        }

       pre.next = new Node(e,pre.next);
        size++;
    }

    public void addLast(E e) {
        add(e,size);
    }

    public Boolean isEmpty() {
        return size==0;
    }
    public int getSize() {
        return size;
    }
}
