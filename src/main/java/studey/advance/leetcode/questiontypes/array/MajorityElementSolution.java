package studey.advance.leetcode.questiontypes.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * @see <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150">多数元素</a>
 * @apiNote 169.多数元素
    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例 1：

    输入：nums = [3,2,3]
    输出：3
    示例 2：

    输入：nums = [2,2,1,1,1,2,2]
    输出：2


    提示：
    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


    进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

    大神题解.
    哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，即可找出 众数 。此方法时间和空间复杂度均为 O(N)O(N)O(N) 。
    数组排序法： 将数组 nums 排序，数组中点的元素 一定为众数。
    摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N)O(N)O(N) 和 O(1)O(1)O(1) ，为本题的最佳解法。

    链接：https://leetcode.cn/problems/majority-element/solutions/2362000/169-duo-shu-yuan-su-mo-er-tou-piao-qing-ledrh/
 */
public class MajorityElementSolution {
    /**
     * @apiNote 解法1.哈希表统计法: 使用lambda流api, 按值分组排序后排序选出出现最多的元素
     * @category 空间复杂度 47.80MB 96.14%
     * @category 时间复杂度 22ms 5%
     */
    public int majorityElementByMyOne(int[] nums) {
        // 使用 Collectors.groupingByValue() 对数组按值分组裝入
        Map<Integer, Long> groupedByValue = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // System.out.println(groupedByValue);

        // 使用 Comparator.comparingLong() 对分组后的结果按值排序，降序排列
        return groupedByValue.entrySet()
        .stream() // 排序在第一位的就是出现最多的元素的值
        .sorted(Comparator.comparingLong(value -> ((Entry<Integer, Long>) value).getValue()).reversed()).findFirst().get().getKey();
    }

    /**
     * @apiNote 解法2.数组排序法  根据题目要求, 只要出现的超过二分之一就属于多数, 那么就只寻找超过一半, 如果超过就是多数
     * 因此先排序数组, 然后取中间值, 在排序后中间值能代表大多数.
     * @category 空间复杂度 51.79MB  55.46%
     * @category 时间复杂度 2ms 62.42%
     *       n == nums.length
     *       1 <= n <= 5 * 104
     *      -109 <= nums[i] <= 109
     */
    public int majorityElementByMyTwo(int[] nums) {
        Arrays.sort(nums);
        // tips: 数组长度/2 只返回能除净的数,同时下标也没有-1,
        // 因此在长度为11的数组中中位数是第6位元素.为10的元素中也是第6位, 都能代表多数元素.
        System.out.println(nums.length);
        return nums[nums.length/2];
    }


    /**
     * @apiNote 推论一： 若记 众数 的票数为 +1+1+1 ，非众数 的票数为 −1-1−1 ，则一定有所有数字的 票数和 >0> 0>0 。

        推论二： 若数组的前 aaa 个数字的 票数和 =0= 0=0 ，则 数组剩余 (n−a)(n-a)(n−a) 个数字的 票数和一定仍 >0>0>0 ，即后 (n−a)(n-a)(n−a) 个数字的 众数仍为 xxx 。


        算法流程:
        初始化： 票数统计 votes = 0 ， 众数 x。
        循环： 遍历数组 nums 中的每个数字 num 。
        当 票数 votes 等于 0 ，则假设当前数字 num 是众数。
        当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 。
        返回值： 返回 x 即可。
     * @see <a href="https://leetcode.cn/problems/majority-element/solutions/2362000/169-duo-shu-yuan-su-mo-er-tou-piao-qing-ledrh/">摩尔投票</a>
     * @category 1ms 99%    时间复杂度 O(N) ： NNN 为数组 nums 长度。
     * @category 52MB 9.2%  空间复杂度 O(1) ： votes 变量使用常数大小的额外空间。
     */
    public int majorityElementByExpertOne(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
