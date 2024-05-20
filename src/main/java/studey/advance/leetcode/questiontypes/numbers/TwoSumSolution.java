package studey.advance.leetcode.questiontypes.numbers;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Track;

/**
 * @see <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 * @apiNote 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class TwoSumSolution {

    /**
     * @apiNote 解法1. 根据题目描述, target 等于当前数组的两个元素之和, 
     * 那么target减去任意元素, 然后就是等于数组中另一个元素, 那么就是包含, 使用Map容器将每个元素的值与下标存入Map.
     * 每次判断target 减去当前值在Map 中是否包含, 如果包含则返回下标, 不包含则存入元素.
     * @category 空间复杂度 43.96MB 31.14% o(n)
     * @category 时间复杂度 2ms 99.58%2 o(1)
     */
    public int[] twoSumByMyOne(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums.length < 2){
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * @apiNote 解法2: 使用双层循环, 遍历每个元素, 如果相加等于target则为命中.
     * @category 空间复杂度 43.66MB 88.90% o(n)
     * @category 时间复杂度 56ms 7.59% o(log n)
     */
    public int[] twoSumByMyTwo(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums.length < 2){
            // 如果nums只有一个或为空 则返回 -1 坐标
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // int j = i+1 : 每次循环到内循环时,j的值= i+1, j索引 永远指向 i后一位元素 !
            // 第一周j的值为1,第二周为2,第三周为3,在单次内循环中i值不变为0,j值每圈会自增++
            for (int j = i + 1; j < nums.length; j++) {
                // 比较获取最小的值 ,每次内循环中i变量值不变,j值在i值上+1.为了防止自己与自己比较,性能最优!
                int x = nums[i] + nums[j];
                if(x == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
