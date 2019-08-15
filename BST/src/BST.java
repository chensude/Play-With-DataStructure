/**
 * 二分搜索树
 * @param <E>
 */
public class BST<E extends Comparable> {

   private class Node {
        private E e;
        private Node left ;
        private Node right;

        public Node(E e) {
            this.e = e;
            this.left=null;
            this.right =null;
        }

    }

    Node root ;
    private int size;
    public BST(Node node) {
        root = null;
        size= 0;
    }

    /**
     * 像BST中添加元素
     */
    public void add(E e) {
         root = add(root,e);
    }

    //像以node为根的二分搜索树中插入元素E
    //返回插入新节点后二分搜索树的根
    private Node add(Node node,E e) {
        //递归终止条件
        if(node==null) {
            size++;
             return new Node(e);
        }

        if(e.compareTo(node.e)<0) {
            node.left = add(node.left,e);
        }else {
            node.right = add(node.right,e);
        }
        return node;
    }
    /**
     * BST是否为空
     * @return
     */
    public Boolean isEmpty() {
        return size==0;
    }

    /**
     * BST节点个数
     * @return
     */
    public int getSize() {
        return size;
    }



}
