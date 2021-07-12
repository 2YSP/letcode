package cn.sp.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ship
 * @Description: 最长连续序列
 * @Date: Created in 2021/7/12
 */
public class LongestConsecutive {

    /**
     * 给定一个未排序的整数数组nums,找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 解法：哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(currStreak, longestStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutive obj = new LongestConsecutive();
        int[] nums = {100, 1, 3, 200, 2, 4};
        int longestConsecutive = obj.longestConsecutive(nums);
        System.out.println(longestConsecutive);
    }
}
