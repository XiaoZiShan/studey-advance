package studey.advance.leetcode.questiontypes.array;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class RemoveDuplicatesFromSortedArrayIiSolution {

    public int removeDuplicates_QuickSlowPointer(int[] nums) {

        // 速率  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/javakuai-man-zhi-zhen-jie-da-by-gsmplaysnswithnx/
        int fast = 2;
        int slow = 1;
        int max = 2;
        for(; fast<nums.length; fast++) {
            // 判重
            if(nums[fast] != nums[slow-max+1]) {
                slow++;
                // 修正
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }


    public int removeDuplicates_DoublePointer_LeetCode(int[] nums) {
        int j = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
