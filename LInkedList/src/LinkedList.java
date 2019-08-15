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


    public Boolean isEmpty() {
        return size==0;
    }
    public int getSize() {
        return size;
    }
}
