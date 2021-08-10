package cn.sp.str;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/10
 */
public class IsPalindrome {

    /**
     * 判断是否为回文串
     *
     * 解法：字符串反转对比
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if (!Character.isLetterOrDigit(ch)){
                continue;
            }
            sb.append(Character.toLowerCase(ch));
        }
        // 反转
        String str = sb.toString();
        String rev_str = sb.reverse().toString();
        return str.equals(rev_str);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
