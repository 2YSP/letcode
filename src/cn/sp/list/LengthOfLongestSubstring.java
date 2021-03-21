package cn.sp.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ship
 * @Description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Date: Created in 2021/3/21
 */
public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入：s = "pwwkew"
     * 输出：3
     * 出现次数(是否重复) -> 用散列表
     * 涉及子串 -> 考虑滑动窗口算法
     * 时间复杂度O（n）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        // key: 字符 value: 字符位置+1
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                // 如果已经存在，则把start移动到重复字符第一次出现位置的下个位置
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            // 没有重复字符则放进map
            map.put(alpha, end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
