package cn.sp.array;

/**
 * @Author: Ship
 * @Description: 转置矩阵
 * @Date: Created in 2021/3/17
 */
public class TransposeMatrix {


    /**
     * 给定一个二维数组，沿对角线翻转
     * eg:
     * 输入：matrix = [[1,2,3],[4,5,6]]
     * 输出：[[1,4],[2,5],[3,6]]
     * 转置矩阵
     *
     * @param matrix
     * @return
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    result[i][j] = matrix[i][j];
                    continue;
                }
                result[j][i] = matrix[i][j];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = {{-51,36,-31,23},{3,12,-31,65},{-20,2,-42,-62},{0,-49,75,77},{-52,46,45,37},{-98,17,14,78},{50,88,-15,-31},{84,-59,-96,23},{42,1,48,81},{-92,95,-71,37}};
        int[][] result = transpose(matrix);
        System.out.println(result);

    }
}
