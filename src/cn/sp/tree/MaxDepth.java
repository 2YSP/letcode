package cn.sp.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Ship
 * @Description: 二叉树的最大深度
 * @Date: Created in 2021/6/8
 */
public class MaxDepth {


    private int maxDepth;

    /**
     * 给定一个二叉树，找出其最大深度
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        search(root, 1);
        return maxDepth;
    }

    private void search(TreeNode treeNode, int depth) {
        if (treeNode.left == null && treeNode.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            return;
        }
        depth++;
        if (treeNode.left != null) {
            search(treeNode.left, depth);
        }
        if (treeNode.right != null) {
            search(treeNode.right, depth);
        }
    }

    /**
     * 方法一：深度优先搜索
     * 时间复杂度：O(n)每个节点都要遍历
     * 空间复杂度：O(height)
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    /**
     * 方法二：广度优先遍历
     * 时间复杂度：O(n)
     * 空间复杂度：最坏O(n)
     *
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每次都取出下一层的节点放入队列中
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, null, null);
        TreeNode treeNode = new TreeNode(3, left, right);
        MaxDepth obj = new MaxDepth();
        System.out.println(obj.maxDepth3(treeNode));
    }

}
