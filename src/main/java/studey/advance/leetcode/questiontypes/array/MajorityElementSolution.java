package studey.advance.leetcode.questiontypes.array;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
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
 */
public class MajorityElementSolution {
    /**
     * 解法1.使用lambda流api, 按值分组排序后排序选出出现最多的元素
     */
    public int majorityElementByMyOne(int[] nums) {
        Map<Integer, Long> map = IntStream.of(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Entry<Integer, Long> maxElement = map.entrySet().stream().sorted().findFirst().get();
        return maxElement.getKey();
    }

    public int majorityElementByMyTwo(int[] nums) {
        return 0;
    }
}