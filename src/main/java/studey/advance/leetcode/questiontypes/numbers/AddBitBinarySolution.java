package studey.advance.leetcode.questiontypes.numbers;

import java.math.BigInteger;

/**
 * @see <a href="https://leetcode.cn/problems/add-binary/description/?envType=study-plan-v2&envId=top-interview-150"/>二进制求和</a>
 * @apiNote 67. 二进制求和
 * 
 *  给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 

    示例 1：
    输入:a = "11", b = "1"
    输出："100"
    
    示例 2：
    输入：a = "1010", b = "1011"
    输出："10101" 

    提示：

    1 <= a.length, b.length <= 104
    a 和 b 仅由字符 '0' 或 '1' 组成字符串如果不是 "0" ，就不含前导零
 */

public class AddBitBinarySolution {
    /**
     * @apiNote 解法1. 两个二进制转为10进制相加,再转为二进制输出结果.
     * @category 空间复杂度 41.65MB 25.45%
     * @category 时间复杂度 5ms 10.84%
     */
    public String addBitBinaryByMyOne(String a, String b) {
        BigInteger aNumber = new BigInteger(a,2);
        BigInteger bNumber = new BigInteger(b,2);
        return aNumber.add(bNumber).toString(2);
    }

    /**
     * @apiNote 解法2. 双for循环+最右匹配, 10的1,11得0进1.一次类推, 通过二进制进位机制,重新组建一个字符串. 
     * @category 空间复杂度 0MB 0.00%
     * @category 时间复杂度 0ms 0.00%
     */
    public String addBitBinaryByMyTwo(String a, String b) {
        StringBuilder result = new StringBuilder();
        return result.toString();
    }

}