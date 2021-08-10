package cn.sp.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Ship
 * @Description: 单词拆分 https://leetcode-cn.com/problems/word-break/
 * @Date: Created in 2021/8/7
 */
public class WordBreak {

    /**
     * 给定一个非空字符串s和一个包含非空单词的列表wordDict，判断s是否可以被空格拆分为一个
     * 或多个在字典中出现的单词
     * 说明：
     * 拆分时可以重复使用字典中的单词
     * 你可以假设字典中没有重复的单词
     *
     * 解法一：动态规划
     * <p>
     * dp[i]表示字符串s前i个字符组成的s[0..i-1]是否能被空格拆分为若干个字典中的单词
     * 转移方程：dp[i] = dp[j] && check(s[j..i-1])
     * 其中 check(s[j..i−1]) 表示子串 s[j..i-1] 是否出现在字典中
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
    }
}
