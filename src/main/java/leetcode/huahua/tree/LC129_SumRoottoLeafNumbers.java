package leetcode.huahua.tree;

import basic.structure.TreeNode;

/**
 * Created by Jim Z on 10/15/20 01:49
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class LC129_SumRoottoLeafNumbers {
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return ans;
        helper(root, 0);
//        helper(root, "");
        return ans;
    }


    private void helper(TreeNode node, int preSum) {
        if (node.left == null && node.right == null) {
            ans += preSum * 10 + node.val;
        }

        int curSum = preSum * 10 + node.val;

        if (node.left != null) helper(node.left, curSum);
        if (node.right != null) helper(node.right, curSum);
    }
//    Use parse String to Integer is to costly
//    private void helper(TreeNode node, String preNumber) {
//        if (node.left == null && node.right == null) {
//            ans += Integer.parseInt(preNumber + node.val);
//        }
//
//        String curNumber =  preNumber + node.val;
//
//        if (node.left != null) helper(node.left, curNumber);
//        if (node.right != null) helper(node.right, curNumber);
//    }
}
