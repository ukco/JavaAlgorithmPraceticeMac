package com.lyr.test.top200;

import com.lyr.test.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 8/29/21 11:15 PM
 * @Version 1.0
 * @Description NC45 实现二叉树先序，中序和后序遍历
 */
public class NC45 {
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();

        preorder(root, preList);
        inorder(root, inList);
        postorder(root, postList);
        resList.add(preList);
        resList.add(inList);
        resList.add(postList);

        int[][] res = new int[3][];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < preList.size(); ++j) {
                res[i][j] = resList.get(i).get(j);
            }
        }
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[][] res = new NC45().threeOrders(root);
    }
}
