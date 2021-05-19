package cn.sp.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ship
 * @Description: 三数之和 https://leetcode-cn.com/problems/3sum/
 * @Date: Created in 2021/5/16
 */
public class ThreeSum {


    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
     * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * <p>
     * 思路： 不重复应该想到排序
     * 解法：排序+双指针
     * 时间复杂度：O(n2)
     * 这里先固定取nums[i]，再把问题化成两数之和的形式有点难想到。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return list;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 如果当前数字大于0，则三数之和一定大于0，结束循环
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }

            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];

                if (sum == 0) {
                    // 加入集合
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        // 去重
                        L++;
                    }

                    while (L < R && nums[R] == nums[R - 1]) {
                        // 去重
                        R--;
                    }

                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }

            }
        }

        return list;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = obj.threeSum(nums);
        System.out.println(list.toString());
    }
}
