package leetcode.huahua.tree;

import basic.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> levelOrder_recursive(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();


        return ans;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;

    }
}
