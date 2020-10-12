package leetcode.huahua.tree;

import basic.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jim Z on 2020-10-06 17:44
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.

 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
public class LC94_BinaryTreeInorderTraversal {


    /*
     Iterative solution
     */
    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while ( cur != null || !stack.isEmpty() ) {
            // find the left most node
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }

        return ans;
    }

    /*
     Recursive solution
     */
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }
}
