package cn.sp.huisu;

/**
 * @Author: Ship
 * @Description: 八皇后问题,回溯算法
 * @Date: Created in 2021/4/5
 */
public class EightQueen {
    // 全局或成员变量,下标表示行,值表示queen存储在哪一列
    int[] result = new int[8];

    /**
     * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），
     * 每个棋子所在的行、列、对角线都不能有另一个棋子
     * @param row
     */
    public void cal8queens(int row) {
        if (row == 8) {
            // 8个棋子都放好了，打印结果
            printQueens(result);
            return;
        }
        // 每一行都有8种放法
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                // 第row行的棋子放到了column列
                result[row] = column;
                // 考察下一行
                cal8queens(row + 1);
            }
        }
    }

    /**
     * 判断row行column列是否合适
     *
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        // 逐行往上考察
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                // 当前位置的上方是否有棋子
                return false;
            }
            if (leftup >= 0) {
                // 考察左对角线
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8) {
                // 考察右对角线
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueen obj = new EightQueen();
        obj.cal8queens(0);
    }
}
