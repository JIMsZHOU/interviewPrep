package leetcode.huahua.tree;

import basic.structure.TreeNode;

/**
 * Created by Jim Z on 10/15/20 01:36
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class LC112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, 0, sum);
    }

    private boolean helper(TreeNode node, int presum, int target) {
        if (node.left == null && node.right == null) {
            return presum + node.val == target;
        }
        presum = presum + node.val;
        boolean left = node.left != null ? helper(node.left, presum, target) : false;
        boolean right = node.right != null ? helper(node.right, presum, target) : false;

        return left || right;
    }
}
