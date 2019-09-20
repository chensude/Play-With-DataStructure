package com.yt.union;

public class UnionFind2 implements UF {

    //我们第二版Union-Find,使用一个数组构建一颗指向父节点的数
    //parent[i]表示第一个元素所指向的父节点

    private int[] parent;

    public UnionFind2(int size) {
        parent= new int[size];

        //初始化，每一个parent[i]指向自己，表示每一个元素自己自成一个集合
        for(int i=0;i<size;i++) {
            parent[i]=i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找元素p对应的集合编号
    //o(h)复杂度。h为树的高度
    public int find(int p) {
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p!=parent[p]) {
            p=parent[p];
        }

        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);

        int qRoot =find(q);

        if(pRoot==qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
    }



}
