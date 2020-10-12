package exp.oa.amazon;

import basic.structure.TreeNode;

/**
 * Created by Jim Z on 2020-09-24 18:05
 * <p>
 * TAGS: Amazon, OA, NG, 2019
 * <p>
 * Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
 * A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.
 */
public class SubtreeWithMaximumAverage {

    private class Prop {
        private int numOfNodes;
        private int sumOfNodes;
        public Prop(int numOfNodes, int sumOfNodes) {
            this.numOfNodes = numOfNodes;
            this.sumOfNodes = sumOfNodes;
        }
    }

    double max = 0;
    TreeNode ans = null;
    public TreeNode maxAvg(TreeNode root) {
        helper(root);
        return ans;
    }

    private Prop helper(TreeNode node) {
        if (node == null) return new Prop(0, 0);
        Prop left = helper(node.left);
        Prop right = helper(node.right);

        int nn = 1 + left.numOfNodes + right.numOfNodes;
        int sn = node.val + left.sumOfNodes + right.sumOfNodes;

        if (node.left != null && node.right != null) {
            double temp = sn * 1.0 / nn;
            if (temp > max) {
                max = temp;
                ans = node;
            }
        }

        return new Prop(nn, sn);
    }
}
