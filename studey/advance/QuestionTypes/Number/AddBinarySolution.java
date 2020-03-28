package advance.QuestionTypes.Number;

import java.util.Arrays;
import java.util.Objects;

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
     * 将两位字符串转为 两个数组.
     * 短数组遍历向右对齐遍历长数组
     * 按照上述计算方式进行相加
     *
     * @param a
     * @param b
     * @return 二进制求和结果
     */
    public String addBinary(String a, String b) {

        if (Objects.isNull(a) && Objects.isNull(b)) {
            return null;
        } else if (Objects.isNull(a)) {
            return b;
        } else if (Objects.isNull(b)) {
            return a;
        }


        char[] shortArray = a.length() <= b.length() ? a.toCharArray() : b.toCharArray();

        char[] longArray = b.length() >= a.length() ? b.toCharArray() : a.toCharArray();

        // 短数组遍历向右对齐遍历长数组
        for (int x = -3, shorti = shortArray.length -1, align = longArray.length - 1; shorti > x;
             x++, shorti--, align--) {


            // skip 零零等零

            if (shortArray[shorti] == '0' && longArray[align] == '1' || shortArray[shorti] == '1' && longArray[align] == '0') {
                // 一零等一
                longArray[align] = '1';

            } else if (shortArray[shorti] == '1' && longArray[align] == '1') {


                // 进位考虑三种情况

                // 0. 如果为扩位则直接返回
                if (shorti - 1 == -1) {
                    longArray[align] = '0';
                    return "1" + new String(longArray);
                } else if (shortArray[shorti - 1] == '1' && longArray[align - 1] == '1') {
                    // 1. 进位为 双一 则为零 后进位为 一

                    // 一一进一 原位等零
                    longArray[align] = '0';
                    longArray[align - 1] = 1;
                } else {
                    // 2. 进位为 一零 或 双零 则都为 一
                    longArray[align] = '1';
                }

            }


        }

        System.out.println(Arrays.toString(longArray));

        return new String(longArray);
    }

}