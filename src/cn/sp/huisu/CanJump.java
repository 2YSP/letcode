package cn.sp.huisu;

/**
 * @Author: Ship
 * @Description: 跳跃游戏 https://leetcode-cn.com/problems/jump-game/
 * @Date: Created in 2021/7/12
 */
public class CanJump {

    boolean canJump;

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标
     *
     * 解法一：回溯暴力解法（超时）
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        isLast(nums, 0);
        return canJump;
    }

    private void isLast(int[] nums, int currIndex) {
        if (canJump) {
            return;
        }
        if (currIndex == nums.length - 1) {
            // 最后一个位置
            canJump = true;
            return;
        }
        int num = nums[currIndex];
        // 下一次有num种跳法
        for (int i = 1; i <= num; i++) {
            int nextIndex = currIndex + i;
            if (nextIndex > nums.length - 1) {
                // 越界
                break;
            }
            isLast(nums, nextIndex);
        }
    }

    /**
     * 解法二：贪心算法，判断能到达的最远位置是否大于最后一个位置，如果能则返回true
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n -1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump obj = new CanJump();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(obj.canJump2(nums));
    }
}
