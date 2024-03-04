package advance.leetcode.questiontypes.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studey.advance.leetcode.questiontypes.numbers.AddBinarySolution;



/**
 * Created by 刷题使我快乐,自律使我自由 !
 *
 * 67. 二进制求和
 给你两个二进制字符串，返回它们的和（用二进制表示）。

 输入为 非空 字符串且只包含数字 1 和 0。

 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"


 提示：

 每个字符串仅由字符 '0' 或 '1' 组成。
 1 <= a.length, b.length <= 10^4
 字符串如果不是 "0" ，就都不含前导零。
 *
 */


public class AddBinarySolutionTest extends AddBinarySolution {

    @Test
    void addBinary(){
        Assertions.assertEquals("1010",super.addBinary("100","110"));
        Assertions.assertEquals("11010011",super.addBinary("1100","11000111"));
        Assertions.assertEquals("10101001101", super.addBinary("10011010010", "1111011"));
        Assertions.assertEquals("100110110",super.addBinary("11011110","1011000"));
    }

}
