package cn.sp.array;

import java.math.BigDecimal;

/**
 * @Author: Ship
 * @Description: 寻找两个正序数组的中位数 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @Date: Created in 2021/4/26
 */
public class FindMedianSortedArrays {


    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
     * 输入：nums = [1,3],nums2=[2]
     * 输出：2.00
     * 解法一：二分查找法，真的复杂
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 将短的数组放到nums1
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        // 分割线左边的所有元素需要满足的个数m + (n -m+1)/2
        int totalLeft = (n + m + 1) / 2;

        // 在nums1的[0,m]区间查找恰当的分割线
        // 使得 nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i],即分割线左边的都比右边的小
        int left = 0;
        int right = m;
        while (left < right) {
            // i 等于nums1 分割后左边个数
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 不符合要求，因为左上的大了，i就要往左移
                // 下一轮搜索的区间[left,i-1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间[i,right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 1) {
            // 奇数，取左边最大值即可
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            // 偶数,（左边最大 + 右边最小）/2计算中位数
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }

    /**
     * 更容易理解的解法
     * 解法二：使用归并排序将两个数组合并为一个有序数组，然后判断奇数还是偶数
     * 时间复杂度:m+n
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
            } else {
                return nums1[n / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }

    }

    public static void main(String[] args) {
        FindMedianSortedArrays obj = new FindMedianSortedArrays();
        int[] a = {1, 2};
        int[] b = {3, 4};
        double medianNum = obj.findMedianSortedArrays2(a, b);
        System.out.println(medianNum);
    }
}
