package cn.sp.huisu;

/**
 * @Author: Ship
 * @Description: 最短路径
 * @Date: Created in 2021/4/6
 */
public class MinDistBT {


    private Integer minDist = Integer.MAX_VALUE;


    /**
     * 给定一个n x n的矩阵，矩阵存储的都是正整数。棋子起始位置在左上角，终止位置在右下角。
     * 我们将棋子从左上角移动到右下角。每次只能向右或者向下移动一位。从左上角到右下角，求最短路径
     * 推导公式：
     * min_dist(i,j) = w[i][j] + min(min_dist(i-1,j),min_dist(i,j-1))
     *
     * @param i
     * @param j
     * @param dist 当前位置的路径
     * @param w    矩阵二维数组
     * @param n
     */
    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        if (i == n && j == n) {
            // 如果到达了(n-1,n-1)位置
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }
        if (i < n) {
            // 往下走，更新i = i+1,j=j
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }
        if (j < n) {
            // 往右走，更新i=i,j=j+1
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }
}
