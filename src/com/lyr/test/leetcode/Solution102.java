package com.lyr.test.leetcode;

import com.lyr.test.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 3/16/21 8:09 PM
 * @Version 1.0
 * @Description 102. 二叉树的层序遍历
 */
public class Solution102 {
    /**
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) { return ret; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
            ret.add(level);
        }
        return ret;
    }
}
