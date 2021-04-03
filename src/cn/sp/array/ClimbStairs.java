package cn.sp.array;

/**
 * @Author: Ship
 * @Description: 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs
 * @Date: Created in 2021/4/3
 */
public class ClimbStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？给定 n 是一个正整数。
     * 解法一：递归 f(n) = f(n-1) + f(n-2)
     * 时间复杂度：
     * 空间复杂度：
     * 缺点：有的台阶重复计算了
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 解法二：记忆性递归（算过得值保存下来）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] mo = new int[n + 1];
        return climbStairsMemory(n, mo);
    }

    private int climbStairsMemory(int n, int[] mo) {
        if (mo[n] > 0) {
            return mo[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        mo[n] = climbStairsMemory(n - 1, mo) + climbStairsMemory(n - 2, mo);
        return mo[n];
    }

    /**
     * 解法三： 动态规划
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] pk = new int[n + 1];
        pk[1] = 1;
        pk[2] = 2;
        for (int i = 3; i <= n; i++) {
            pk[i] = pk[i - 1] + pk[i - 2];
        }
        return pk[n];
    }


    public static void main(String[] args) {
        ClimbStairs obj = new ClimbStairs();
        int i = obj.climbStairs3(3);
        System.out.println(i);
    }
}
