package cn.sp.dynamicprogram;

/**
 * @Author: Ship
 * @Description: 最短路径之动态规划解法
 * @Date: Created in 2021/4/6
 */
public class MinDistDP {


    /**
     * @param matrix
     * @param n
     * @return
     */
    public int minDistDP(int[][] matrix, int n) {
        // index为位置，值为当前位置的路径和
        int[][] states = new int[n][n];
        // 初始化第一行
        int val = 0;
        for (int i = 0; i < n; i++) {
            val += matrix[0][i];
            states[0][i] = val;
        }
        // 初始化第一列
        int valRight = 0;
        for (int i = 0; i < n; i++) {
            valRight += matrix[i][0];
            states[i][0] = valRight;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
            }
        }
        return states[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        int n = 4;
        MinDistDP obj = new MinDistDP();
        System.out.println("最短路径为：" + obj.minDistDP(matrix, n));

        System.out.println("ss");
    }
}
