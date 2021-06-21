package cn.sp.tree;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/6/8
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;


    public TreeNode(){

    }

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
