package studey.advance.leetcode.questiontypes.stack;

import java.util.Objects;



/**
 *给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 *
 * Created by 最长有效括号 !
 */
public class LongestValidParenthesesSolution {

    public int longestValidParentheses(String s) {
        // 边界判断
        if (Objects.equals(s, "")){
            return 0;
        }

        return 0;
    }
}
