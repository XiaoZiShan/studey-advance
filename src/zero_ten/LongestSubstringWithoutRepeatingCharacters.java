package zero_ten;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 * Created by CHENT
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     */
    int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // 思路 先从最短的字符开始, 将每一个字符进行比对, 在比对的过程种返回最长的子串长度
        String[] returnArray = s.split("/*");


        return 0;
    }
}