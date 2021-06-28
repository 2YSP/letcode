package cn.sp.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Ship
 * @Description: 对称二叉树 https://leetcode-cn.com/problems/symmetric-tree/
 * @Date: Created in 2021/6/27
 */
public class IsSymmetric {


    /**
     * 给定一个二叉树，判断是否为镜像对称的
     * <p>
     * 问题可以转换为：两个树在什么情况下互为镜像？(这里没想到)
     * 需要满足条件：
     * 1. 它们的根节点值相同
     * 2. 每个树的右子树与另一个树的左子树镜像对称
     * <p>
     * 解法一：深度优先遍历，递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            // 一个为null 一个不为null,则不是镜像对称
            return false;
        }
        return p.val == q.val && isMirror(p.right, q.left) && isMirror(p.left, q.right);
    }



    /**
     * 解法二：广度优先遍历，迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 每次取出两个节点
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null){
                continue;
            }
            if (t1 == null || t2 == null){
                return false;
            }
            if (t1.val != t2.val){
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }


    public static void main(String[] args) {
    }
}
