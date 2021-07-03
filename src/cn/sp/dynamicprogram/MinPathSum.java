package cn.sp.dynamicprogram;

/**
 * @Author: Ship
 * @Description: 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum/
 * @Date: Created in 2021/7/3
 */
public class MinPathSum {


    /**
     * 给定一个包含非负整数的mxn网格grid，请找出一条从左上角到右下角的路径，
     * 使得路径上的数字总和为最小
     * 说明：每次只能向下或向右移动一步
     * 公式 f(m,n) = min(f(m,n-1),f(m-1,n))
     * 解法：动态规划
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // index为当前位置，值为路径总和
        int[][] state = new int[m][n];
        // 填充第一行和第一列
        state[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            state[0][i] = state[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < m; j++) {
            state[j][0] = state[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                state[i][j] = grid[i][j] + Math.min(state[i - 1][j], state[i][j - 1]);
            }
        }
        return state[m - 1][n - 1];
    }


    public static void main(String[] args) {
        MinPathSum obj = new MinPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int path = obj.minPathSum(grid);
        System.out.println(path);
    }
}
