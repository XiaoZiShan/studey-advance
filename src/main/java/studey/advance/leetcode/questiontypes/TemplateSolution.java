package studey.advance.leetcode.questiontypes; // 注意不同题型放到对应的包, 如果没有请创建.

import java.math.BigInteger;

// /**
//  * @see <a href="https://leetcode.cn/problems/todo">当前Leetcode题目名连接</a>
//  * @apiNote -1 Leetcode todo 题目名称
//  * 
//  */
// public class TemplateSolution {     
//     /**
//      * @apiNote 解法1. 
//      * @category 空间复杂度 0MB 0.00%
//      * @category 时间复杂度 0ms 0.00%
//      */
//     public int templateByMyOne(int param){ 
//         return 1;
//     }

//     /**
//      * @apiNote 解法2..
//      * @category 空间复杂度 0MB 0.00%
//      * @category 时间复杂度 0ms 0.00%
//      */
//     public int templateByExpertOne(int param){ 
//         return 2;
//     }
// }


/**
 * @see <a href="https://leetcode.cn/problems/todo">当前Leetcode题目名连接</a>
 * @apiNote -1 Leetcode todo 题目名称
 * 原题详情1 
 * 原题详情2
 * 原题详情3
 */
public class TemplateSolution { // 命名为当前Leetcode 英文题目名加上Solution
    
    /**
     * @apiNote 解法1. 具体解法介绍以及当前算法在Leetcode上运行的复杂度结果.
     * @category 空间复杂度 0MB 0.00%
     * @category 时间复杂度 0ms 0.00%
     */
    public int templateByMyOne(int param){ // 注意命名: 自己写的则为题目名称加ByMy编号
        return param + 1;
    }

        /**
     * @apiNote 解法2. 具体解法介绍以及当前算法在Leetcode上运行的复杂度结果.
     * @category 空间复杂度 0MB 0.00%
     * @category 时间复杂度 0ms 0.00%
     */
    public int templateByExpertOne(int param){ // 注意命名: 其他人写的则为题目名称加ByExpert编号
        return BigInteger.ONE.add(BigInteger.valueOf(param)).intValue();
    }
}