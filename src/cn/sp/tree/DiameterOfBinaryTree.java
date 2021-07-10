package cn.sp.tree;

/**
 * @Author: Ship
 * @Description: 二叉树的直径 https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @Date: Created in 2021/7/8
 */
public class DiameterOfBinaryTree {

    int max = 1;

    /**
     *
     * 给定一个颗二叉树，你需要计算它的直径长度。一颗二叉树的直径长度是任意两个节点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根节点。
     * 解法：深度优先遍历
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        depth(root);
        return max;
    }

    /**
     * 求以该节点为根的子树深度
     *
     * @param node
     * @return
     */
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        if (left + right > max) {
            // 每次递归时都计算一次，如果找到更大的就替换max
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }

}
