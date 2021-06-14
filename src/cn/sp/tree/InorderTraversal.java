package cn.sp.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Ship
 * @Description: 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Date: Created in 2021/6/14
 */
public class InorderTraversal {

    /**
     * 解法一：递归，先遍历左节点在父节点
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        digui(root, list);
        return list;
    }

    private void digui(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        digui(root.left, list);
        list.add(root.val);
        digui(root.right, list);
    }

    /**
     * 解法二：迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9, null, null);

        TreeNode leftChild = new TreeNode(5);
        TreeNode right = new TreeNode(20, leftChild, null);
        TreeNode treeNode = new TreeNode(3, left, right);
        InorderTraversal obj = new InorderTraversal();
        List<Integer> list = obj.inorderTraversal2(treeNode);
        System.out.println(list);
    }
}
