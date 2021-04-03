package cn.sp.array;

/**
 * @Author: Ship
 * @Description: 买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @Date: Created in 2021/4/3
 */
public class MaxProfit {

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * <p>
     * 解法一：暴力遍历
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    /**
     * 解法二：动态规划,特点求最大值最小值
     * 时间复杂度：O(n) 只遍历了一次
     * 空间复杂度：O(1)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // 计算收益
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit obj = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = obj.maxProfit2(prices);
        System.out.println(i);
    }
}
