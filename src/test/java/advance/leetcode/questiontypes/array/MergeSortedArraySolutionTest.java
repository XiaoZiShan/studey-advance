package advance.leetcode.questiontypes.array;

import org.junit.jupiter.api.Test;
import studey.advance.leetcode.questiontypes.array.MergeSortedArraySolution;;

public class MergeSortedArraySolutionTest extends MergeSortedArraySolution{
    
    @Test
    void mergeSortedArrayByMyOneTest(){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] target = {1,2,2,3,5,6};
        super.mergeSortedArrayByMyOne(nums1, 6, nums2, nums2.length, target);
        int[] nums1Null = {1};
        int[] nums2Null = {};
        int[] targetNull = {1};
        super.mergeSortedArrayByMyOne(nums1Null, 1, nums2Null, 0, targetNull);
    }

    // @Test
    // void templateByExpertOneTest(){
    //     Assertions.assertEquals(0,super.templateByExpertOne(-1));
    //     Assertions.assertEquals(2,super.templateByExpertOne(1));
    // }
}
