package leetcode;

import basic.structure.TreeNode;

/**
 * Created by Jim Z on 2020-09-24 18:47
 *
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.
 *
 * (A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)
 */
public class LC1120_MaximumAverageSubtree {
    private class Prop {
        private int nn;
        private int sn;

        public Prop(int nn, int sn) {
            this.nn = nn;
            this.sn = sn;
        }
    }

    private double max = 0.0;

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }

    private Prop helper(TreeNode node) {
        if (node == null) return new Prop(0, 0);

        Prop left = helper(node.left);
        Prop right = helper(node.right);

        int nn = 1 + left.nn + right.nn;
        int sn = node.val + left.sn + right.sn;

        max = Math.max(max, sn * 1.0 / nn);

        return new Prop(nn, sn);
    }
}
