package cn.sp.dynamicprogram;

/**
 * @Author: Ship
 * @Description: 动态规划之背包问题
 * @Date: Created in 2021/4/3
 */
public class Knapsack {

    /**
     * 现有n个不可分割的物品每个物品的重量为weight[i]，背包最大承重重量为w，
     * 求在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
     * 时间复杂度：O(n * w)
     * @param weight
     * @param n      物品个数
     * @param w      最大重量限制
     * @return
     */
    public static int knapsack(int[] weight, int n, int w) {
        // 默认false,index分别为第几阶段和当前背包的重量
        boolean[][] states = new boolean[n][w + 1];
        // 第一行数据要特殊处理,可利用哨兵优化
        states[0][0] = true;
        if (weight[0] < w) {
            states[0][weight[0]] = true;
        }
        // 动态规划状态转移
        for (int i = 1; i < n; i++) {
            // 不把第i个物品放入背包
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] == true) {
                    states[i][j] = true;
                }
            }
            // 把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] == true) {
                    states[i][j + weight[i]] = true;
                }
            }
        }

        //输出结果
        for (int i = w; i >= 0; i--) {
            // 从最后一个阶段找最接近w的那个
            if (states[n - 1][i] == true) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] weight = {5,2,5,8,3};
        System.out.println(knapsack(weight,5,9));
    }
}
