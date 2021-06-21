package cn.sp.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ship
 * @Description: 只出现一次的数字 https://leetcode-cn.com/problems/single-number/
 * @Date: Created in 2021/6/14
 */
public class SingleNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 输入：[2,2,1]
     * 输出：1
     * 要求：算法具有线性时间复杂度，不使用额外空间
     * 解法一：散列表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], 2);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue().intValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 解法二：使用异或运算，真的妙
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 相同元素异或运算=0
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, -1, 3};
        SingleNumber obj = new SingleNumber();
        int res = obj.singleNumber2(nums);
        System.out.println(res);
    }
}
