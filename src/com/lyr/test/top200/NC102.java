package com.lyr.test.top200;

import com.lyr.test.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 8/29/21 12:26 PM
 * @Version 1.0
 * @Description NC102 在二叉树中找到两个节点的最近公共祖先
 */
public class NC102 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        getPath(root, o1, path1);
        getPath(root, o2, path2);

        int res = 0;
        for (int i = 0; i < path1.size() && i < path2.size(); ++i) {
            if (path1.get(i).equals(path2.get(i))) {
                res = path1.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    private boolean getPath(TreeNode root, int value, List<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.val);
        boolean isFound = false;
        if (root.val == value) {
            isFound = true;
        }
        if (!isFound && root.left != null) {
            isFound = getPath(root.left, value, list);
            if (!isFound) {
                list.remove(list.size() - 1);
            }
        }
        if (!isFound && root.right != null) {
            isFound = getPath(root.right, value, list);
            if (!isFound) {
                list.remove(list.size() - 1);
            }
        }
        return isFound;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        System.out.println(new NC102().lowestCommonAncestor(root, 5, 1));
    }
}
