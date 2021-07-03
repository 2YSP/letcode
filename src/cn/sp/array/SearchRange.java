package cn.sp.array;

/**
 * @Author: Ship
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Date: Created in 2021/6/30
 */
public class SearchRange {

    /**
     * 给定一个按照升序排列的整数数组nums和一个目标值target，找出给定
     * 目标值在数组中的开始位置和结束位置
     * 如果数组中不存在目标值target，则返回[-1,-1]
     * <p>
     * 解法一：遍历两次
     * 时间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        boolean exist = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res[0] = i;
                exist = true;
                break;
            }
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                res[1] = j;
                break;
            }
        }
        if (exist) {
            return res;
        }
        return new int[]{-1, -1};
    }

    /**
     * 解法二：二分查找法
     * 时间复杂度:O(logn)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            // 不存在
            return new int[]{-1, -1};
        }
        int lastPosition = findLastPosition(nums, target);

        return new int[]{firstPosition, lastPosition};
    }

    private int findLastPosition(int[] nums, int target) {
        // [5, 7, 7, 8, 8, 10]
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 不加1会死循环
            int mid = (left + right + 1) >>> 1;
            System.out.println(left + "," + right + "," + mid);
            if (nums[mid] > target) {
                // 下一个搜索区间 [left,mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 下一个搜索区间 [mid,right]
                left = mid;
            } else {
                // 下一个搜索区间 [mid+1,right]
                left = mid + 1;
            }
        }
        return left;
    }


    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                // 下一个搜索区间 [left,mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 下一个搜索区间 [left,mid]
                right = mid;
            } else {
                // 下一个搜索区间 [mid+1,right]
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRange obj = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = obj.searchRange2(nums, 8);
    }
}
