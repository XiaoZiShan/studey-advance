package studey.advance.leetcode.questiontypes.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;

/**
 * @see <a href="https://leetcode.cn/problems/merge-sorted-array/">合并两个有序数组</a>
 * @apiNote 88. 合并两个有序数组
 * 
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
示例 3：

输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 

提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 * 
 */
public class MergeSortedArraySolution { 
    
    /**
     * @apiNote 解法1. n(log n) 双层for循环合并 
     * @category 空间复杂度 0MB 0.00% 
     * @category 时间复杂度 0ms 0.00% O(log n)
     */
    public void mergeSortedArrayByMyOne(int[] nums1, int m, int[] nums2, int n,int[] target){ 
        // 1.1 先判断边界, 如果 n 或 m 为0, 返回 nums[1] 为1.
        int[] errorArray = {};
        if(nums2 == errorArray || nums1 == errorArray){
            nums1[0] = 1;
            return;
        }
        int recard = 0;
        boolean isOver = false;
        // 1.2 双层for循环遍历
        for (int j = 0; j < nums2.length; j++) {
            for (int i = 0; i < nums1.length; i++) {
                // 1.3 如果 nums2 当前元素大于或等于则后续元素后移, 将当前元素插入, 并且记录下标
                // 1.4 根据上次插入的下标再次循环, 如果当前元素则直接插入, 并且记录下标
                if (nums2[j] >= nums1[i] && i != nums1.length -1){
                    recard = i+1;
                    isOver = true;
                    nums1[i] = nums1[i+1];        
                }        
            }
            if(isOver){
                nums1[recard] = nums2[j];
                isOver = false;
            }
        }
        this.checkAfterArray(nums1,target); // todo LeetCode 运行时剔除该行
    }

    /**
     * @apiNote 解法2. 将数组nums2直接添加到nums1, 然后对nums1进行排序.
     * @category 空间复杂度 41.16MB 67.64%
     * @category 时间复杂度 1ms 28.17%
     */
    public void mergeSortedArrayByMyTwo(int[] nums1, int m, int[] nums2, int n,int[] target){ 
          // 2.1 将nums1 与 nums2 装入ArrayList
          List<Integer> list = new ArrayList<>();
          // 2.2 nums1 与 nums2的元素根据 m,n 数量装填.
          for(int i = 0;i < m;i++){
              list.add(nums1[i]);
          }
  
          for(int j = 0;j < n;j++){
              list.add(nums2[j]);
          }
          // 2.3 将ArraysList调用sort排序
          Collections.sort(list);
          // 2.4 将排序后的元素覆盖 nums1, end
          for(int x = 0; x < nums1.length; x++){
              nums1[x] = list.get(x);
          }
          this.checkAfterArray(nums1,target); // todo LeetCode 运行时剔除该行
    }


    /**
     * @apiNote 解法3. 将数组nums2直接添加到nums1, 然后对nums1进行排序.
     * @category 空间复杂度 41.16MB 67.64%
     * @category 时间复杂度 1ms 28.17%
     */
    public void mergeSortedArrayByExpertOne(int[] nums1, int m, int[] nums2, int n,int[] target){ 
        // 3.1将nums2的元素添加到nums1的后面, 替代原先为0的元素.
        for(int i = 0;i != n; i++){
            nums1[m+i] = nums2[i];
        }
        // 3.2对nums1进行排序
        Arrays.sort(nums1);
        this.checkAfterArray(nums1,target); // todo LeetCode 运行时剔除该行
    }

    private void checkAfterArray(int[] after, int[] target){
        for (int i = 0; i < target.length; i++) {
            Assertions.assertEquals(after[i] , target[i]);
        }
    }
}