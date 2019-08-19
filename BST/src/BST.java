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
     * 前序遍历
     *
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(root==null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    /**
     * 中序遍历
     * @param
     */
    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if(root==null) {
            return;
        }

        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(root==null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }
    /**
     * 是否包含元素e
     */
    public boolean contain(E e) {

      return   contain(root,e);
    }

    //以node为根的节点，返回是否包含e的结果
    private boolean contain(Node node, E e) {

        if(node==null) {
            return false;
        }
        if(e.equals(node.e)) {
            return true;
        }else if(e.compareTo(node.e)<0) {
          return  contain(node.left,e) ;
        }else{
           return contain(node.right, e);
        }
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
