package cn.sp.array;

/**
 * @Author: Ship
 * @Description: 移动零
 * @Date: Created in 2021/4/4
 */
public class MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 输入：[0,1,0,3,12]
     * 输出：[1,3,12,0,0]
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        // 交换
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 解法二： 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        // 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 不为0就左移
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
    }

}
