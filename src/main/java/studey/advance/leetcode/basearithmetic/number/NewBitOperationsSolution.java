package studey.advance.leetcode.basearithmetic.number;

import java.math.BigInteger;

/**
 * 1.二进制整数相加相减诀窍
 * 正数相加， 1 1 进位得零，1 0 得1, 0 0得零， 正负数相见，除去符号位，其余取反 + 1  
 *   00100011  35 
 * + 11011101 -35
 *   00000000   0
 * 
 *   00100011   35
 * + 11011011  -37
 *   11111110   相加的结果
 *   10000001   取反
 *   10000010   +1，后最终结果
 *  
 * 2. 符号整数与无符号整数的最大值。
 * 32位int符号整数最大值 =  2<sup>31</sup>-1, Integer 默认是32符号整数。
 * 64位long符号整数最大值 =  2<sup>63</sup>-1， Long 默认是32符号整数。
 * 32位int无符号整数最大值 = 2<sup>32</sup>-1 
 * 64位long无符号整数最大值 = 2<sup>64</sup>-1
 * 
 * 有符号整数通常用于表示可以为正值和负值的数值，例如温度、坐标或财务数据。
 * 无符号整数通常用于表示本质上为正的值，例如计数器、索引或数据大小。
 * 
 * 3.位移动运算符使用
 * 左移运算符 (<<)：将二进制数的位向左移动指定数量的位。 
 * 右移运算符 (>>)：将二进制数的位向右移动指定数量的位。 
 * 无符号右移运算符 (>>>)：将无符号二进制数的位向右移动指定数量的位。
 * 
 * 4. | 与 & 在二进制中运算中的作用
 */
public class NewBitOperationsSolution {     

    /**
     * @apiNote 无符号整数与符号整数区别，他们的最大值是多少？
     * @summary 所有的正负整数都是基于二进制存储， 符号位是用来区0分正数与1负数，因此
     * 8位字节的符号整数最大值为 2<sup>7</sup>-1 = 127, 16/32/64依次类推，因为最左位用来区分正负数，因此实际存储为7个字节。
     * 8位字节的无符号整数最大值为 2<sup>8</sup>-1 = 255, 16/32/64依次类推，因为最左位用来填充二进制，因此只能用来表达正数。
     * 
     * 有符号整数通常用于表示可以为正值和负值的数值，例如温度、坐标或财务数据。
     * 无符号整数通常用于表示本质上为正的值，例如计数器、索引或数据大小。
     */
    public static void questionAnswerByMyOne(){
        // 8位/16位/32位/64位符号整数最大值
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Byte.MAX_VALUE);


        byte signedByte = 127; // 有符号8位字节整数，最大值为 127
        byte unsignedByte = (byte) 255; // 无符号字节，最大值为 255

        short signedShort = 32767; // 有符号16位短整型，最大值为 32767
        short unsignedShort = (short) 65535; // 无符号短整型，最大值为 65535

        int signedInt = 2147483647; // 有符号32位整数，最大值为 2147483647
        // unsigned int unsignedInt = 4294967295; // jdk11无法通过编译 无符号整数，最大值为 4294967295
        long unsignedInt = 4294967295l;

        long unsignedLong = 9223372036854775807l; // 有符号64位整数，最大值为 2147483647
        // unsigned long unsignedLong = 18446744073709551615l; // jdk11无法通过编译
        BigInteger unsignedBigLong = new BigInteger("18446744073709551615");
    }


    /**
     * @apiNote  不使用+，使用位运算将两个数字相减加
     * @summary  
     */
    public static int questionAnswerByMyTwo(int one, int two){ 
        one = one << 1; // 假设 one 为 10， 01010，左移位移1位后为20,  010100 
        two = two << 2; // 假设 two 为 4，  00100，左移位移1位后为8，  001000
        int sum = one | two;// 使用或与运算相加为36, sum 等于         011100
        return sum >>> 1; // 将结果复原 0100100 >>> 1 = 为 18        01110 
    }

    /**
     * @apiNote  不使用-，使用位运算将两个数字相减
     * @summary  
     */
    public static int questionAnswerByMyThree(int one, int two){ 
        one = one >> 1; // 假设 one 为 10， 01010，右移位移1位后为5   0101   
        two = two >> 2; // 假设 two 为 4，  00100，右移位移1位后为2，  0010
        int sum = one | two;// 使用或与运算相加为8, sum 等于          0111 
        return sum >>> 1; // 将结果复原 0100100 >>> 1 = 为 3        011  
    }

    /**
     * @apiNote  | 和 & 在二进制中有什么用？ 
     * @summary  
     */
    public void questionAnswerByMyFour(){ 
        
    }

    /**
     * @apiNote  xf0001>>>1 ， 16 进制位移一位
     * @summary  
     */
    public void questionAnswerByMyFive(){
        
    }

    
    public static void main(String[] args) {
        System.out.println(questionAnswerByMyTwo(10,4));
        System.out.println(questionAnswerByMyThree(10,4));    
    }
}