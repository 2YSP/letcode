package cn.sp.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ship
 * @Description: 主要元素
 * @Date: Created in 2021/3/17
 */
public class MajorityElement {


    /**
     * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
     * eg:
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     * 要求：时间复杂度为 O(N)，空间复杂度为 O(1)
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        /**
         * 摩尔投票法
         * 时间复杂度为 O(N)，空间复杂度为 O(1)
         *
         */
        int major = 0;
        int count = 0;
        for(int num : nums){
            if (count == 0){
                major = num;
                count = 1;
            }else {
                if (major == num){
                    count++;
                }else {
                    count--;
                }
            }
        }

        if (count > 0){
            int n = 0;
            for(int num : nums){
                if (major == num){
                    n++;
                }
            }
            if (n > nums.length/2){
                return major;
            }
        }
        return -1;
    }

    /**
     * hash表计数法，
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int halfNum = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > halfNum) {
                return entry.getKey();
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
