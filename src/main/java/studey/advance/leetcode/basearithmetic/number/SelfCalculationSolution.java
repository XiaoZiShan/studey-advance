package studey.advance.leetcode.basearithmetic.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 所有和自增自减相关的算法问题
 */
public class SelfCalculationSolution {     
    
    /**
     * @apiNote （i++）* 3 自增的结果是多少？ 原因是什么？ 
     * @summary 
     *  1.结果是3, 首先不管有没有小括号都优先计算乘法，i++ 会在被求值之后增加.
     *  2.自增运算符 ++ 属于后缀运算符，这意味着它会在操作数被求值之后应用于操作数。
     *  这与前缀自增运算符 ++i 不同，后者会在操作数被求值之前应用自增操作。
     *  3.在 C++ 和 Java 中，运算符优先级规则规定乘法运算优先于递增运算，小括号只是便于理解，不起作用。
     */
    public void questionAnswerByMyOne(){ 
        int i = 1; 
        int x = (i++) * 3;
        System.out.println("（i++）* 3 后 x 的值为：" + x);
        System.out.println("i 的值为：" + i);
        System.out.println("i ++ 的值为：" + i++);
        System.out.println("打印 i 的值：" + i);
        x = 0; i = 0;
        i = 1; 
        x = (++i) * 3;
        System.out.println("清空上述值，再次（++i）* 3 后 x 的值为：" + x);
    }

    /**
     * @apiNote i++ i-- --i ++i i-1 i+1 都会发生什么， 且有什么不同？
     * @summary  结果是 i++/-- 后缀运算符都在被求值之后，++/--i则反之。 
     *  i-1 i+1 没有变量接收，不会继承以前的值.
     * 
     * ++i	在求值表达式之前递增
     * i++	先求值 i 然后再递增
     * --i	在求值表达式之前递减
     * i--	先求值 i 然后再递减
     * i-1	计算 i 的值减去 1
     * i+1	计算 i 的值加上 1 
     */
    public void questionAnswerByMyTwo(){ 
         int i = 1;
         assertEquals(1,i++);
         assertEquals(2,i--);
         assertEquals(1,i);
         int x = 1;
         assertEquals(2,++x);
         assertEquals(1,--x);
         int y = 1;
         assertEquals(2,y+1);
         assertEquals(0,y-1);
         System.out.println("i++ i-- --i ++i i-1 i+1 都会发生什么， 且有什么不同？  结果是 i++/-- 后缀运算符都在被求值之后，++/--i则反之。  i-1 i+1 没有变量接收，不会继承以前的值.");
    }
}