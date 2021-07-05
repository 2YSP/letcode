package cn.sp.huisu;

/**
 * @Author: Ship
 * @Description: 正则式匹配 https://leetcode-cn.com/problems/regular-expression-matching/
 * @Date: Created in 2021/7/5
 */
public class IsMatch {


    /**
     * 给你一个字符串s和一个字符规律p，请你来实现一个支持'.'和'*'的正则表达式匹配
     * '.'匹配任意单个字符
     * '*'匹配零个或多个前面的那一个元素
     * <p>
     * 解法：动态规划，真的难
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //f[0][0]代表s和p均为空字符串，f[1][1]代表s和p的第一个字符（即在s和p中下标为0的字符)
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (matches(s, p, i, j - 1)) {
                        // 匹配s的第i个字符和p的第j-1个字符
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        // p中*前面的在s中字符出现0次
                        dp[i][j] = dp[i][j - 2];
                    }

                } else {
                    // p的第j个字符不为*
                    if (matches(s, p, i, j)) {
                        // 匹配s的第i个字符和p的第j个字符
                        // 匹配成功状态转移，匹配不成功默认false
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }


    private boolean matches(String s, String p, int i, int j) {
        // 注意字符串中的下标变换
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    public static void main(String[] args) {
        IsMatch obj = new IsMatch();
        System.out.println(obj.isMatch("aa","a"));
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("ab",".*"));
        System.out.println(obj.isMatch("aab","c*a*b"));
    }
}
