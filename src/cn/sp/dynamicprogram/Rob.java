package cn.sp.dynamicprogram;

/**
 * @Author: Ship
 * @Description: https://leetcode-cn.com/problems/house-robber/
 * @Date: Created in 2021/5/25
 */
public class Rob {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     * 输入：[1, 2, 3, 1]
     * 输出：4
     * <p>
     * 解法一：动态规划,把每一步拆为偷和不偷两种情况
     * 公式：S(n) = max(S(n-2)+nums[n],S(n-1))
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] state = new int[len];
        state[0] = nums[0];
        state[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < len; i++) {
            state[i] = Math.max(state[i - 2] + nums[i], state[i - 1]);
        }

        return state[len - 1];
    }

    /**
     * 解法二：动态规划+滚动数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob.rob2(nums));
    }


}
