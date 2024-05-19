package studey.advance.leetcode.questiontypes.numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 * @apiNote 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
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
     * @apiNote 解法1.
     * @category 空间复杂度 3ms 7.67%
     * @category 时间复杂度 44.01MB 15.66%
     */
    public int[] twoSumByMyOne(int[] nums, int target) {
        int[] select = new int[]{-1,-1};
        if (nums.length < 2){
            // 如果nums只有一个或为空 则返回 -1 坐标
            return select;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++ ) {
            // 查找[i] 正确位是否存在(首次匹配值一定不存在,map size 为 0)
            if (map.containsKey(target-nums[i])){
                // 将正确位索引存入
                select[0] = (int) map.get(target-nums[i]);
                // 将匹配位索引存入
                select[1] = i;
                break;
            }
            // 将首次未匹配值与索引存入map
            map.put(nums[i],i);
        }
        return select;
    }

    public int[] twoSumByMyTwo(int[] nums, int target) {
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
