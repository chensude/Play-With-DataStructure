public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    class Node {
        private K key;
        private V value;
        private Node left,right;
        public Node(K key,V value) {
            this.key = key ;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size ;

    public BSTMap() {
        root=null;
        size=0;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key, root);

        if(node==null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value=value;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key, root);
        return node==null?null:node.value;
    }

    @Override
    public void add(K key, V value) {
        root = add(key,value,root);
    }

    /**
     *像节点中添加元素，返回添加后的根节点
     */
    private Node add(K key, V value, Node node) {

        if(node==null) {
            size++;
           return new Node(key,value);
        }
        if(key.compareTo(node.key)<0) {
             node.left=add(key,value,node.left);
        }else if(key.compareTo(node.key)>0) {
            node.right = add(key,value,node.right);
        }else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key, root);
        if(node!=null) {
            root = remove(key,root);
            return node.value;
        }
        return null;
    }

    //删除以node为根二分搜索树中键为key的节点，
    //返回删除节点后二分搜索树的根
    private Node remove(K key, Node node) {

        if(node==null) {
            return null;
        }
        if(key.compareTo(node.key)<0) {
            node.left= remove(key,node.left);
            return node;
        }else if(key.compareTo(node.key)>0) {
            node.right = remove(key,node.right);
            return node;
        }else {
            if(node.left==null) {
               Node rightNode =  node.right;
               node.right =null;
               size--;
               return rightNode;
            }
            if(node.right==null) {
                Node leftNode = node.left;
                node.left =null;
                size--;
                return leftNode;
            }

            Node successor = minimum(key,node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left=node.right=null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(key,root)!=null;
    }

    //返回以node为根节点的二分搜索树中，key所在的节点
    public Node getNode(K key,Node  node) {

        if(node==null) {
            return null;
        }
        if(key.equals(node.key)) {
            return node;
        }else if(key.compareTo(node.key) <0) {
            return getNode(key,node.left);
        }else {
            return getNode(key,node.right);
        }
    }

    //以root为根节点二分搜索树中，最小值节点
    public Node minimum(K key,Node node) {
        if(node.left==null) {
            return node;
        }

        return minimum(key,node.left);
    }

    //删除node二分搜索树中最小节点
    //返回删除后的新的根节点
    private Node removeMin(Node node) {

        if(node.left==null) {
            Node nodeRight = node.right;
            node.right =null;
            size--;
            return nodeRight;
        }

        node.left= removeMin(node.left);
        return node;
    }
}
