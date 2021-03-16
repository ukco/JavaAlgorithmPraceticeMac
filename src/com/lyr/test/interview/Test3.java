package com.lyr.test.interview;

import com.lyr.test.DataStructure.TreeNode;

import java.util.*;

/**
 * @Author lyr
 * @Date 3/16/21 11:32 PM
 * @Version 1.0
 * @Description Z字型遍历二叉树--二叉树的锯齿形层序遍历
 */
public class Test3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) { return ans; }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderleft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderleft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) { nodeQueue.offer(curNode.left); }
                if (curNode.right != null) { nodeQueue.offer(curNode.right); }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderleft = !isOrderleft;
        }
        return ans;
    }
}
