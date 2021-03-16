package com.lyr.test.leetcode;

import com.lyr.test.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lyr
 * @Date 3/16/21 7:41 PM
 * @Version 1.0
 * @Description 94. 二叉树的中序遍历
 */
public class Solution94 {
    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) { return; }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * Morris 中序遍历
     * Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
