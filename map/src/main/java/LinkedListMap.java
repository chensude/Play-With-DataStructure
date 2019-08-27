/**
 *
 */
public class LinkedListMap<K,V> implements Map<K,V>{

    class Node {
        private K key;
        private V value;

        private Node next;

        public Node(K key,V value,Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }

        public Node(K key,V value) {
            this(key,value,null);
        }

        public Node() {
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }

    }

    private int size;

    private Node dummyHead;

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void set(K key, V v) {
        Node node = getNode(key);

        if(v==null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value =v;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return  node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node==null) {
            Node cur = dummyHead.next;

            dummyHead = new Node(key, value, cur);
            size++;
        }else {
            node.value=value;
        }
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next!=null) {
            if(pre.next.key.equals(key)) {
                break;
            }
            pre= pre.next;
        }

        if(pre.next!=null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next =null;
            size--;
            return delNode.value;
        }
        return null;

    }

    @Override
    public boolean contains(K key) {
        V v = get(key);
        return v!=null;
    }


    public Node getNode(K key) {
        Node cur = dummyHead.next;

        while (cur!=null) {

            if(cur.key.equals(key)) {
                return cur;
            }
            cur =cur.next;
        }
        return null;
    }

}
