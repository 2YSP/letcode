package cn.sp.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ship
 * @Description: 组合总和 https://leetcode-cn.com/problems/combination-sum/
 * @Date: Created in 2021/6/19
 */
public class CombinationSum {

    /**
     * 给定一个无重复元素的数组candidates和目标数target，
     * 找出candidates中所有可以使数字和为target的组合
     * candidates中的数字可以无限制的重复使用
     * 输入：candidates = [2, 3, 6, 7] target = 7
     * 输出：[[7], [2, 2, 3]]
     *
     * 解法：回溯算法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(result, candidates, target, combine, 0);
        return result;
    }

    /**
     *
     * @param result
     * @param candidates
     * @param target 距离目标数的差距
     * @param combine 每次选择的组合
     * @param idx candidates的下标
     */
    private void dfs(List<List<Integer>> result, int[] candidates, int target, List<Integer> combine, int idx) {
        // 终止条件，candidates的元素遍历完或者target<=0
        if (idx >= candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(result, candidates, target, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(result, candidates, target - candidates[idx], combine, idx);
            combine.remove(combine.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> lists = obj.combinationSum(candidates, 7);
        System.out.println(lists);
    }
}
