package com.lyr.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lyr
 * @Date 1/23/21 12:21 PM
 * @Version 1.0
 * @Description 1319. 连通网络的操作次数
 */
public class Solution1319 {
    /**
     * 并查集
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind1319 uf = new UnionFind1319(n);
        for (int[] conn : connections) {
            uf.unite(conn[0], conn[1]);
        }
        return uf.setCount - 1;
    }

    List<Integer>[] edges;
    boolean[] used;
    /**
     * dfs
     * @param n
     * @param connections
     * @return
     */
    public int makeConnection2(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            edges[conn[0]].add(conn[1]);
            edges[conn[1]].add(conn[0]);
        }

        used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(i);
                ++ans;
            }
        }
        return ans - 1;
    }
    private void dfs(int u) {
        used[u] = true;
        for (int v : edges[u]) {
            if (!used[v]) {
                dfs(v);
            }
        }
    }
}

class UnionFind1319 {
    int[] parent;
    int[] size;
    int n;
    /**
     * 当前连通分量数
     */
    int setCount;

    public UnionFind1319(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findSet(int x) {
        return parent[x] == x ? x : (parent[x] = findSet(parent[x]));
    }

    public boolean unite(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        /**
         * 按秩合并
         * 由于我们在找出一个元素所在集合的代表时需要递归地找出它所在的树的根结点，
         * 所以为了减短查找路径，在合并两棵树时要尽量使合并后的树的高度降低，所以要将高度低的树指向高度更高的那棵。
         * 这里我们引入一个秩的概念：为每一个结点维护一个秩，它表示以该节点为根的树的高度的上界。
         * 在做合并操作时，将秩小的根指向秩大的结点。
         */
        if (x == y) { return false; }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        return x == y;
    }
}