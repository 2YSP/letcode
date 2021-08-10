package cn.sp.dynamicprogram;

/**
 * @Author: Ship
 * @Description: 最小编辑距离 https://leetcode-cn.com/problems/edit-distance/
 * @Date: Created in 2021/8/10
 */
public class MinEditDistance {


    /**
     *
     * 解法：动态规划
     * <p>
     * 1.如果word1[i] == word2[j],那么比较word1[0..i-1]和word2[0..j-1]
     * 2.否则，分为三种情况
     * 执行插入操作，那么比较word1[0..i]和word2[0..j-1]
     * 执行删除操作，那么比较word1[0..i-1]和word2[0..j]
     * 执行替换操作，那么比较word1[0..i-1]和word2[0..j-1]
     * <p>
     * op[i][j] 表示字符串word1(0..i)到word2(o..j)的编辑距离
     * 如果word1[i] == word2[j],那么op[i][j] = op[i-1][j-1]
     * 否则为三种操作的最短距离+1
     * op[i][j] = 1 + min(op[i][j-1],op[i-1][j],op[i-1][j-1])
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minEditDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 空字符的情况
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        //
        int[][] op = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            op[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            op[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    op[i][j] = op[i - 1][j - 1];
                } else {
                    op[i][j] = Math.min(Math.min(op[i][j - 1], op[i - 1][j]), op[i - 1][j - 1]) + 1;
                }
            }
        }
        return op[n][m];
    }


    public static void main(String[] args) {
        System.out.println(minEditDistance("horse", "ros"));
    }
}
