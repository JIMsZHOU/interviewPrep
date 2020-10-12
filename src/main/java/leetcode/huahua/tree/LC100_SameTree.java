package leetcode.huahua.tree;

import basic.structure.TreeNode;

/**
 * Created by Jim Z on 2020-10-06 18:09
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class LC100_SameTree {

    public boolean isSameTree(TreeNode p,TreeNode q) {
        return traverse(p, q);
    }

    private boolean traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return traverse(node1.left, node2.left) && traverse(node1.right, node2.right);
    }
}
