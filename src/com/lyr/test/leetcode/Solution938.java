package com.lyr.test.leetcode;

import com.lyr.test.DataStructure.TreeNode;

import java.util.Stack;

/**
 * @Author lyr
 * @Date 3/18/21 8:01 PM
 * @Version 1.0
 * @Description 938. 二叉树的搜索范围之和
 */
public class Solution938 {
    int ans = 0;

    /**
     * dfs 递归
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }
    private void dfs(TreeNode root, int low, int high) {
        if (root != null) {
            if (low <= root.val && root.val <= high) { ans += root.val; }
            if(low < root.val) { dfs(root.left, low, high); }
            if (root.val < high) { dfs(root.right, low, high); }
        }
    }

    /**
     * 递归
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) { return 0; }
        if (root.val > high) { return rangeSumBST2(root.left, low, high); }
        if (root.val < low) { return rangeSumBST2(root.right, low, high); }
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
    }

    /**
     * dfs 迭代
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST3(TreeNode root, int low ,int high) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high) { ans += node.val; }
                if (low < node.val) { stack.push(node.left); }
                if (node.val < high) { stack.push(node.right); }
            }
        }
        return ans;
    }
}
