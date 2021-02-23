package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 1/25/21 10:30 AM
 * @Version 1.0
 * @Description 959. 由斜杠划分区域
 */
public class Solution959 {
    /**
     * 并查集
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;

        UnionFind959 unionFind959 = new UnionFind959(size);
        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                // 二维网格转换为一维表格
                int index = 4 * (i * N + j);
                char c = row[j];
                // 单元格内合并
                if (c == '/') {
                    // 合并 0、3，合并 1、2
                    unionFind959.union(index, index + 3);
                    unionFind959.union(index + 1, index + 2);
                } else if (c == '\\') {
                    // 合并 0、1，合并 2、3
                    unionFind959.union(index, index + 1);
                    unionFind959.union(index + 2, index + 3);
                } else {
                    // 合并整个单元格
                    unionFind959.union(index, index + 1);
                    unionFind959.union(index + 1, index + 2);
                    unionFind959.union(index + 2, index + 3);
                }

                // 单元格间合并
                // 向右合并：1（当前）、3（右一列）
                if (j + 1 < N) {
                    unionFind959.union(index + 1, 4 * (i * N + j + 1) + 3);
                }
                // 向下合并：2（当前）、0（下一行）
                if (i + 1 < N) {
                    unionFind959.union(index + 2, 4 * ((i + 1) * N + j));
                }
            }
        }
        return unionFind959.getCount();
    }
}

class UnionFind959 {
    private int[] parent;
    private int count;

    public int getCount() { return count; }

    public UnionFind959(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) { return; }
        parent[rootX] = rootY;
        --count;
    }
}
