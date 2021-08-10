package cn.sp.huisu;

import java.util.*;

/**
 * @Author: Ship
 * @Description: 全排列 https://leetcode-cn.com/problems/permutations/
 * @Date: Created in 2021/8/8
 */
public class Permute {

    /**
     * 给定一个不含重复数字的数组nums，返回其所有可能的全排列。你可以按任意顺序返回。
     *
     * 输入：nums = [1,2,3]
     * 输出：
     * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 解法：回溯，即树的深度遍历+状态重置
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        // 保存每次选择的数字
        Deque<Integer> path = new ArrayDeque<>();
        // 保存数字使用状态
        boolean[] used = new boolean[len];
        dfs(nums, len, res, 0, path, used);
        return res;
    }

    private void dfs(int[] nums, int len, List<List<Integer>> res, int depth, Deque<Integer> path, boolean[] used) {
        // 如果层数等于长度，则得到值
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, res, depth + 1, path, used);
            // 状态重置
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute obj = new Permute();
        int[] nums = {1,2,3};
        List<List<Integer>> list = obj.permute(nums);
        System.out.println(list);
    }
}
