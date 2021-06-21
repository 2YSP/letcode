package cn.sp.tree;

import java.util.*;

/**
 * @Author: Ship
 * @Description: 二叉树的层序遍历  https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @Date: Created in 2021/6/14
 */
public class LevelOrder {

    /**
     * 给你一个二叉树，请你返回其按 层序遍历得到的节点值。（即逐层的，从左到右访问所有节点）
     * 算法：广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> valueList = new ArrayList<>();
            // 每次取出下一层
            while (size > 0) {
                TreeNode node = queue.poll();
                valueList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            resultList.add(valueList);
        }

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, null, null);
        TreeNode treeNode = new TreeNode(3, left, right);
        LevelOrder obj = new LevelOrder();
        List<List<Integer>> list = obj.levelOrder(treeNode);
        System.out.println(list);
    }
}
