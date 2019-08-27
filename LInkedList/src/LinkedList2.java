/**
 * 虚拟头节点链表的实现
 */
public class LinkedList2<E> {

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
    private Node dummyhead;

    public LinkedList2() {
        dummyhead = new Node(null,null);
        size=0;
    }



    /**
     * 往链表index处添加元素
     * @return
     */
    public void add(int index,E e) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("非法参数");
        }

        Node pre =dummyhead;
        //找到索引前一个位置
        for(int i=0;i<index;i++) {
            pre = pre.next;
        }

        pre.next = new Node(e,pre.next);
        size++;
    }

    public void addLast(E e) {
        add(size,e);
    }

    /**
     * 像链表的头添加元素
     * @param e
     */
    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * get一个元素
     * @return
     */
    public E get(int index) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("非法参数");
        }
        Node cur = dummyhead.next;
        for (int i =0;i<index;i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
       return get(0);
    }


    public E getLast() {
        return get(size);
    }

    public void set(int index,E e) {
        if(index<0||index>size) {
            throw new IllegalArgumentException("非法参数");
        }
        Node cur = dummyhead.next;
        for (int i =0;i<index;i++) {
            cur = cur.next;
        }
        cur.e =e;
    }

    public Boolean contains(E e) {
        Node cur = dummyhead;
        while (cur.next!=null) {
            if(e.equals(cur.e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }
    public Boolean isEmpty() {
        return size==0;
    }
    public int getSize() {
        return size;
    }

    //@Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyhead.next ; cur != null ; cur = cur.next)
            res.append(cur.e + "->");
        res.append("NULL");

        return res.toString();
    }
}

