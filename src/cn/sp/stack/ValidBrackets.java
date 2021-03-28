package cn.sp.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Ship
 * @Description: 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 * @Date: Created in 2021/3/28
 */
public class ValidBrackets {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 1.左括号必须用相同类型的右括号闭合
     * 2.左括号必须以正确的顺序闭合
     * 输入：s = "()[]{}"
     * 输出：true
     * <p>
     * 解法：左边的括号最后匹配，先进后出可以用栈
     *
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            // 必定为偶数才有效
            return false;
        }

        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.empty() || !stack.peek().equals(map.get(c))){
                    return false;
                }
                stack.pop();
            }else {
                // 左括号放入栈中
                stack.push(c);
            }
        }
        // 最后栈是空的
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidBrackets obj = new ValidBrackets();
        boolean valid = obj.isValid("[{(}])");
        System.out.println(valid);
    }
}
