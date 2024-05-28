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
 * 3.1左移运算符 (<<)：将二进制数的位向左移动指定数量的位。
 *  << 左移时当前正数比当前数要大，负数则更小，符号位保持不变,并且会出现正数变负数的情况，10 << 32 = 0 之后
 * 等同于从 << 0 开始起步一场类推。而当你 10 << 30 = -2147483648则结果会等于负数， 因为你的返回值将被模32取余，
 * 符号位被抛弃了，恰巧被 1 代替。
 *      10 << 1 = 20，-10 << 1 = -20。
 * 3.2右移运算符 (>>)：将二进制数的位向右移动指定数量的位。
 *   >> 右移时当前正数比当前数要小，负数则更大，符号位保持不变,但是不会出现正数变负数的情况，10 >> 10 为0，0 >> 32 = 0 之后
 * 等同于从 >> 0 开始起步一场类推。
 *      10 >> 1 = 5，-10 >> 1 = -5。
 * 3.3无符号右移运算符 (>>>)：将无符号二进制数的位向右移动指定数量的位。
 *   >>> 无符号位右移，与右移类似，正数比当前数要小，负数则更大，不过因为无符号右移操作不考虑符号位，所以负数会变成正数，
 * 总是用0填充左边空出的位，无论数值是正是负。
 *      -10 >>> 1 = 2147483643
 * 
 * 4.对高进制使用 0x7fffffff >>> 1,为什么不等于 0x7ffffff？ 
 *  不等于， 因为所有非二进制的操作最终都会被转换为二进制后再进行运算操作。
 *  在二进制下0x7ffffff并不等于正确答案0x3fffffff。
 * 5. | 与 & 在二进制中运算中的作用
 * 
 */
public class BitOperationsSolution {

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
     * @apiNote  带符号位位移>> <<与 >>> 无符号位右移的区别是什么？ 
     * @summary 根据下面的例子可以得出这些结论
     * 1. << 左移时当前正数比当前数要大，负数则更小，符号位保持不变,并且会出现正数变负数的情况，10 << 32 = 0 之后
     * 等同于从 << 0 开始起步一场类推。而当你 10 << 30 = -2147483648则结果会等于负数， 因为你的返回值将被模32取余，
     * 符号位被抛弃了，恰巧被 1 代替。
     *      10 << 1 = 20，-10 << 1 = -20。
     * 2. >> 右移时当前正数比当前数要小，负数则更大，符号位保持不变,但是不会出现正数变负数的情况，10 >> 10 为0，0 >> 32 = 0 之后
     * 等同于从 >> 0 开始起步一场类推。
     *      10 >> 1 = 5，-10 >> 1 = -5。
     * 3. >>> 无符号位右移，与右移类似，正数比当前数要小，负数则更大，不过因为无符号右移操作不考虑符号位，所以负数会变成正数，
     * 总是用0填充左边空出的位，无论数值是正是负。
     *      -10 >>> 1 = 2147483643
     */
    public static void questionAnswerByMyTwo(){
        int ten = 10;
        // 带符号位的正负数位移 
        System.out.println(ten << 1); // 01010 << 1 = 010100 (20)
        System.out.println(ten >> 1); // 01010 >> 1 = 0101 (5)
        System.out.println(-ten << 1);// 11010 << 1 = 110100 (-20)
        System.out.println(-ten >> 1);// 11010 >> 1 = 1101 (-5)
        System.out.println(ten << 32);// 01010 << 32 = 01010 (10) 当前为32位整数移动32位，当前数字位不动
        System.out.println(ten << 33);// 01010 << 33 = 010100 (20) 当前为32位整数移动33位，等于<<1;
        // 当前数值超过32位最大返回将被模32取余，抛弃超高32的位数，通过补码形式得到负数1为负号位。
        System.out.println(ten << 30);// 01010 << 30 = -2147483648 (10100000000000000000000001...) 
        // 当前数值虽然也超过32位但被摸32取余，抛弃超高32的位数，最大正数加1后符号位仍然为正数。
        System.out.println(1 << 30);// 001 << 30 = 1073741824 (10000000000001) 

        System.out.println(ten >> 10);// 01010 >> 10 = 000 (0) 带符号位右移10，会变成0但是不会变成负数。

        // 正数无符号位位移
        System.out.println(ten >>> 1); // 01010 >>> 1 = 0101 (5)
        // 负数无符号位位移，会将符号位移动，由0补上，变为正数
        // 11111111111111111111111111110110 >>> 1 = 01111111111111111111111111111011 (2147483643)
        System.out.println(-ten >>> 1); 

    }

    /**
     * @apiNote  0x7fffffff >>>1 ，0x7fffffff无符号位移一位是否等于0x7ffffff？
     * @summary  不等于， 因为所有的位操作符最终都会被转换为二进制后再进行位运算操作。
     *    0x7fffffff 是32位有符号整数（int 类型）能表示的最大正整数 = 01111111 11111111 11111111 11111111  2147483647
     *    01111111 11111111 11111111 11111111  >>> 1 = 00111111 11111111 11111111 11111111 (0x3fffffff) 1073741823
     */
    public static void questionAnswerByMyThree(){
        System.out.println(0x7fffffff >>> 1 == 0x7ffffff);// 等于 false
        System.out.println(0x7fffffff >>> 1 == 0x3fffffff);// 等于 true
        System.out.println(Integer.MAX_VALUE);       // 2147483647
        System.out.println(Integer.MAX_VALUE >>> 1); // 1073741823
        System.out.println(0x71d4b89f >>> 1 == 0x31d4b89f);// 等于 false
    }


    /**
     * @apiNote  | , & , ~, ^ 在二进制运算中有什么用？
     * @summary 按位或 (|):
     * 1.按位或 (|):
     * 操作: 对应的两个位，如果有一个或多个位为1，则结果位为1。
     * 二进制: 例如，1011 | 1100 的结果为 1111。
     * 用途: 常用于设置特定的位（将其置为1），因为它不会清除其他位。
     * 
     * 2.按位与 (&):
     * 操作: 对应的两个位都为1时，结果位才为1。
     * 二进制: 例如，1011 & 1100 的结果为 1000。
     * 用途: 常用于清除特定的位（将其置为0），因为只有两个位都是1时，结果位才为1。
     * 
     * 3.按位取反 (~):
     * 操作: 反转操作数的每一位，将所有的1变成0，所有的0变成1。
     * 二进制: 例如，~1011 的结果为 0100（假设操作数是8位的）。
     * 用途: 用于反转位模式，这在计算补码或执行某些类型的位掩码操作时很有用。
     * 
     * 4.按位异或 (^):
     * 操作: 对应的两个位不相同时，结果位为1（即一个位为0而另一个位为1）。
     * 二进制: 例如，1011 ^ 1100 的结果为 0111。
     * 用途: 用于改变特定的位，如果两个位相同则结果为0，不同则结果为1，这在加密算法和错误检测/校正中很有用。
     */
    public static void questionAnswerByMyFour(){
        System.out.println((10 | 4) == 14); // 
        System.out.println((1535 | 4)); // 
        System.out.println((42 | 41) ); // 
        System.out.println((10 | 1312312)); // 

        System.out.println(10 & 4);
        System.out.println(~10);
        System.out.println(10 ^ 4);
    }

    /**
     * @apiNote  不使用+，使用位运算将两个数字相减加
     * @summary
     */
    public static int questionAnswerByMyFive(int one, int two){
        while (two != 0) {
            // 计算进位
            int carry = (one & two) << 1;

            // 执行加法操作，忽略进位
            one = one ^ two;

            // 将进位赋值给b，以便在下一次迭代中处理
            two = carry;
        }
        return one;
    }

    /**
     * @apiNote  不使用-，使用位运算将两个数字相减
     * @summary
     */
    public static int questionAnswerByMySix(int one, int two){
        while (two != 0) {
            // 计算进位
            int borrow = (~one) & two;
            one = one ^ two; // 执行减法操作
            two = borrow << 1; // 将进位左移一位
        }
        return one;
    }

    /**
     * @apiNote  HashMap 中用到了那些位运算的技术？
     * @summary
     */
    public static int questionAnswerByMySeven(int one, int two){
        while (two != 0) {
            // 计算进位
            int borrow = (~one) & two;
            one = one ^ two; // 执行减法操作
            two = borrow << 1; // 将进位左移一位
        }
        return one;
    }


    public static void main(String[] args) {
        questionAnswerByMyFour();
    }
}
