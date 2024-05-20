package studey.advance.leetcode.questiontypes.array;

import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150">删除有序数组中的重复项</a>
 * @apiNote 26. 删除有序数组中的重复项
 *
    给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

    考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

    更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
    返回 k 。
    判题标准:

    系统会用下面的代码来测试你的题解:

    int[] nums = [...]; // 输入数组
    int[] expectedNums = [...]; // 长度正确的期望答案

    int k = removeDuplicates(nums); // 调用

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
    }
    如果所有断言都通过，那么您的题解将被 通过。



    示例 1：

    输入：nums = [1,1,2]
    输出：2, nums = [1,2,_]
    解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
    示例 2：

    输入：nums = [0,0,1,1,1,2,2,3,3,4]
    输出：5, nums = [0,1,2,3,4]
    解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。


    提示：

    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    nums 已按 非严格递增 排列
 */
public class RemoveDuplicatesSolution {

    /**
     * @apiNote 解法1.遍历全部元素放入 LinkedHashSet,将Set个数输出并且将去重的结果覆盖.
     * @category 空间复杂度 44.01MB 15.66%
     * @category 时间复杂度 3ms 7.67%
     */
    public int removeDuplicatesByMyOne(int[] nums, int[] targetNums) {
        // 1.1 Set去重
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 1.2 覆盖原数组
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            nums[i] = iterator.next();
        }

        this.checkAfterArray(nums,targetNums); // todo LeetCode 运行时剔除该行
        // 1.3 返回Set去重后个数
        return set.size();
    }

    /**
     * @apiNote 解法2. 使用快慢指针的方式对非严格递增排序的数组进行去重, 
     * fast index 与 slow index如果索引值相等, fast 则向前匹配到不相等则停下, 
     * 反之下一轮 slow 则与 fast, slow ++后下标值等于 fast 的下标值. 
     * 结束条件, fast 指针等于数组长度之后返回 slow 指针+1.
     * @category 空间复杂度 43.77MB 82.62%
     * @category 时间复杂度 0ms 100.00%
     */
    public int removeDuplicatesByMyTwo(int[] nums, int[] targetNums) {
        int fast = 1, slow = 0; 
        // 2.1 结束条件, fast 指针等于数组长度之后返回 slow 指针+1.
        for (;fast < nums.length;) {
            if (nums[slow] == nums[fast]) {
                // 2.2 fast index 与 slow index如果索引值相等, fast 则向前匹配到不相等则停下
                fast ++;
            } else {
                // 2.3 反之下一轮 slow 则与 fast, slow ++后下标值等于 fast 的下标值.
                slow ++;
                nums[slow] = nums[fast];
            }
        }

        this.checkAfterArray(nums,targetNums); // todo LeetCode 运行时剔除该行
        return slow+1;
    }

    /**
     * @apiNote 解法3. 使用pre 来替代慢指针, 增加来赋值操作的次数, 不太容易维护.
     * @category 空间复杂度 43.78MB 80.51%
     * @category 时间复杂度 0ms 100.00%
     */
    public int removeDuplicatesByExpertOne(int[] nums, int[] targetNums) {
        // 3.1 声明计数器以及 pre 变量 (用来接受上一轮的值), i 就是快指针
        int count = 0;
        int pre = Integer.MIN_VALUE;
        // 3.2 结束条件, 入参数组被遍历完成
        for (int i = 0; i < nums.length; i++) {
            // 3.3 如果上一轮的值不等于遍历索引, 计数器自增并且下一轮的索引赋值.
            if(nums[i] != pre) {
                nums[count++] = nums[i];
                pre = nums[i];
            }
        }

        this.checkAfterArray(nums,targetNums); // todo LeetCode 运行时剔除该行
        return count;
    }

    private void checkAfterArray(int[] after, int[] target){
        for (int i = 0; i < target.length; i++) {
            Assertions.assertEquals(after[i] , target[i]);
        }
    }
}
