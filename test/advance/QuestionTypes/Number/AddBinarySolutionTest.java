package advance.QuestionTypes.Number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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

public class AddBinarySolutionTest {

    private final AddBinarySolution addBinarySolution = new AddBinarySolution();

    @Test
    void addBinary(){
        Assertions.assertEquals("1010",addBinarySolution.addBinary("100","110"));
        Assertions.assertEquals("11010011",addBinarySolution.addBinary("1100","11000111"));
        Assertions.assertEquals("10101001101", addBinarySolution.addBinary("10011010010", "1111011"));
        Assertions.assertEquals("100110110",addBinarySolution.addBinary("11011110","1011000"));
    }

}