package studey.advance.QuestionTypes.Number;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */

//给定两个二进制字符串，返回他们的和（用二进制表示）。
//
// 输入为非空字符串且只包含数字 1 和 0。
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
// Related Topics 数学 字符串

public class AddBinarySolution {

    /**
     * 二进制计算方式:
     * <p>
     * 零零等零
     * 一零等一
     * 一一进一
     * 原位等零
     * 进位同理
     * <p>
     * 解题思路:
     * <p>
     * 见代码
     *
     * @param a
     * @param b
     * @return 二进制求和结果
     */
    public String addBinary(String a, String b) {
        // 获取最大数组的长度
        int len = Math.max(a.length(), b.length());
        int c = 0;
        // 获取最大位数空数组, (考虑同位数进位 +1)
        char[] ans = new char[len + 1];
        for (int i = 1; i <= len; ++i) {

            int t = get(a, i) + get(b, i) + c;
            ans[len - i + 1] = (char) ((t % 2) + '0');
            c = t / 2;
        }
        if (c == 0) {
            return new String(ans, 1, ans.length - 1);
        }
        ans[0] = (char) ('0' + c);
        return new String(ans);
    }

    private int get(String s, int i) {
        if (i > s.length()) {
            return 0;
        } else {
            return s.charAt(s.length() - i) - '0';
        }
    }

}