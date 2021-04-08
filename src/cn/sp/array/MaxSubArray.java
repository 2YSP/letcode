package cn.sp.array;

/**
 * @Author: Ship
 * @Description: 最大子序和  https://leetcode-cn.com/problems/maximum-subarray/
 * @Date: Created in 2021/4/8
 */
public class MaxSubArray {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6，连续数组[4,-1,2,1]的和最大
     * <p>
     * 解法一：贪心算法
     * 思路：若当前指针所指元素之前的和小于0，则丢弃当前元素之前的数列
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * 解法二：动态规划
     * 若前一个元素大于0，则将其加到当前元素上
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int maxValue = nums[0];
        int currValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currValue > 0) {
                currValue += nums[i];
            } else {
                currValue = nums[i];
            }
            maxValue = Math.max(currValue, maxValue);
        }
        return maxValue;
    }


    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray obj = new MaxSubArray();
        int i = obj.maxSubArray(array);
        System.out.println(i);
    }
}
