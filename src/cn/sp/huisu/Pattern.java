package cn.sp.huisu;

/**
 * @Author: Ship
 * @Description: 正则表达式
 * @Date: Created in 2021/6/21
 */
public class Pattern {

    private boolean matched = false;
    /**
     * 正则表达式
     */
    private char[] pattern;

    /**
     * 正则表达式长度
     */
    private int plen;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }


    /**
     * @param text 文本
     * @param tlen 文本长度
     * @return
     */
    private boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }


    public boolean match(String text) {
        return this.match(text.toCharArray(), text.length());
    }


    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) {
            // 如果已经匹配成功，就不再继续递归了
            return;
        }

        if (pj == plen) {
            // 正则表达式到结尾
            if (ti == tlen) {
                // 文件串也到结尾
                matched = true;
            }
            return;
        }

        if (pattern[pj] == '*') {
            // *匹配任意个字符
            for (int k = 0; k < tlen - ti; k++) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') {
            // ？匹配0个或1个字符
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            // 纯字符匹配，通过进行下一个
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }

    public static void main(String[] args) {
        String p = "*aa?b";
        Pattern pattern = new Pattern(p.toCharArray(),p.length());
        System.out.println( pattern.match("1232aab"));
    }
}
