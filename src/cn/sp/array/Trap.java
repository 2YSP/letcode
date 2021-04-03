package cn.sp.array;

/**
 * @Author: Ship
 * @Description: 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 * @Date: Created in 2021/4/1
 */
public class Trap {

    /**
     * 解法一：暴力解法
     * 对于数组中的每个元素，找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * 时间复杂度： O(n2)
     * 空间复杂度： O(1)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j > 0; j--) {
                // 搜索左边最大高度
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                // 搜索右边最大高度
                maxRight = Math.max(maxRight, height[j]);
            }
            ans = ans + Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 解法三： 动态规划
     * 使用两个数组提前存储当前位置左右方向的最大值
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        // 从左往右看
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    /**
     * 解法二：使用双指针
     * 时间复杂度： O(n)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += (leftMax - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += (rightMax - height[right]);
                }
                --right;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap obj = new Trap();
        int result = obj.trap3(height);
        System.out.println(result);
    }
}
