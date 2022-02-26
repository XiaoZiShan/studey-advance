package studey.advance.questiontypes.numbers;

import java.util.Stack;

/**
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * Created by 回文数字 !
 *
 */
public class PalindromeNumberSolution {
    // 使用栈判断回文数
    public boolean isPalindrome(int x) {
        // 边界判断
        if(x < 0 || x == 10){
            return false;
        }
        // 获取数字长度
        char[] xChars = String.valueOf(x).toCharArray();
        int xLength = xChars.length;
        
        // 获取中间点
        int mid = xLength / 2 -1;
        
        // 将mid前的字符串依次入栈
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i <= mid; i++){
            stack.add(xChars[i]);
        }
        
        // 奇偶数校准
        Integer next = xLength % 2 == 0 ? mid + 1 : mid +2;
        
        // 从数组的第一位与栈的最后一位依次比较
        for (int i = next; i <= xLength-1; i++) {
            if (xChars[i] != stack.pop()){
                return false;
            }
        }
        return true;
    }
}