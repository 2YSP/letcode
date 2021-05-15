package cn.sp.array;

import java.util.*;

/**
 * @Author: Ship
 * @Description: 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Date: Created in 2021/5/13
 */
public class LetterCombinations {

    public static Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };


    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
     *
     * 解法：回溯
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations,map,digits,0,new StringBuilder());
        return combinations;
    }


    /**
     *
     * @param combinations 组合结果
     * @param phoneMap
     * @param digits 电话号码
     * @param index 数字的下标
     * @param combination
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                          String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 这里很难理解，如ad得到结果后把d去掉继续
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
       LetterCombinations obj = new LetterCombinations();
        List<String> strings = obj.letterCombinations("23");
        System.out.println(strings.toString());
    }
}
