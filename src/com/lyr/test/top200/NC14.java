package com.lyr.test.top200;

import com.lyr.test.DataStructure.TreeNode;

import java.util.*;

/**
 * @Author lyr
 * @Date 3/24/21 11:07 PM
 * @Version 1.0
 * @Description NC14. 二叉树的之字形层序遍历
 */
public class NC14 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;

        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (isLeft) { levelList.offerLast(curNode.val); }
                else { levelList.offerFirst(curNode.val); }
                if (curNode.left != null) { queue.offer(curNode.left); }
                if (curNode.right != null) { queue.offer(curNode.right); }
            }
            res.add(new ArrayList<>(levelList));
            isLeft = !isLeft;
        }
        return res;
    }
}
