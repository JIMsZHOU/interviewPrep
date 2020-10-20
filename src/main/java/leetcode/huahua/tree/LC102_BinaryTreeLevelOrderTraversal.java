package leetcode.huahua.tree;

import basic.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jim Z on 2020-10-06 20:09
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LC102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder_iterative(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                layer.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            ans.add(layer);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder_recursive(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() == level) { // works fine pre/in/post order traversal
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        helper(node.left, level+1, res);
        helper(node.right, level+1, res);
    }
}
