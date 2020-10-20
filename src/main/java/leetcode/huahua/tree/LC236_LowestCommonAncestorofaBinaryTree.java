package leetcode.huahua.tree;

import basic.structure.TreeNode;

/**
 * Created by Jim Z on 10/15/20 14:31
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
public class LC236_LowestCommonAncestorofaBinaryTree {

    /*
        Interesting problem.

        The LCA should have this features
        * one is in left subtree, and one is in right subtree
        * All other nodes will have at most one side contains target node.
        * if find the node itself
     */

    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        if (node == p || node == q) {
            //  Conner Case:
            //  Because when we traverse the tree, we will go through parent node first, the node itself may be the LCA,
            //  therefore we need to update the ans here too.
            ans = node;
            return true;
        }
        boolean left = helper(node.left, p, q);
        boolean right = helper(node.right, p, q);
        if (left && right) ans = node;
        return left || right;
    }
}
