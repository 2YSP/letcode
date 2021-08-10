package cn.sp.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ship
 * @Description: 和为k的子数组,https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @Date: Created in 2021/8/10
 */
public class SubArraySum {

    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
     *
     * 输入：nums = [1,1,1] k = 2
     * 输出：2,子数组为[1,1]和[1,1]
     *
     * <p>
     * 解法：暴力枚举
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subArraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int end = 0; end < len; end++) {
            // 是否和为k
            int sum = 0;
            for (int start = end; start >= 0; start--) {
                // 计算每个以start开头子数组的和
                sum += nums[start];
                if (sum == k) {
                    // 缩放窗口
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 解法二：前缀和 + 哈希表优化
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subArraySum2(int[] nums, int k) {
        int count = 0;
        // key: 前缀和 value:出现次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subArraySum2(nums, 2));
    }
}
