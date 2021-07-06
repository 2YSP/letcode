package cn.sp.array;


/**
 * @Author: Ship
 * @Description: 下一个排列 https://leetcode-cn.com/problems/next-permutation/
 * @Date: Created in 2021/7/6
 */
public class NextPermutation {


    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排序成字典顺序中下一个更大的排列
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
     * 必须原地修改，只允许使用额外常数空间
     * <p>
     * 示例：
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2] 132是123的下一个排列
     * <p>
     * 解法：两边扫描
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前遍历，找第一个非降序的值a[i] 较小数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {// 如果i<0则说明已是最大序列
            int j = nums.length - 1;
            // 从后往前遍历，找第一个大于a[i]的值a[j]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换较小数a[i]和较大数a[j]
            swap(nums, i, j);
        }
        // 重排「较小数」右边的序列
        reverse(nums, i + 1);
    }

    /**
     * 双指针反转
     *
     * @param nums
     * @param start
     */
    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
