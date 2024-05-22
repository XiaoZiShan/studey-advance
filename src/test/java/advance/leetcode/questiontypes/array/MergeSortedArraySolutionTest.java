package advance.leetcode.questiontypes.array;

import org.junit.jupiter.api.Test;
import studey.advance.leetcode.questiontypes.array.MergeSortedArraySolution;;

public class MergeSortedArraySolutionTest extends MergeSortedArraySolution{
    
    // @Test
    // void mergeSortedArrayByMyOneTest(){
    //     int[] nums1 = {1,2,3,0,0,0};
    //     int[] nums2 = {2,5,6};
    //     int[] target = {1,2,2,3,5,6};
    //     super.mergeSortedArrayByMyOne(nums1, 3, nums2, nums2.length, target);
    //     int[] nums1Null = {1};
    //     int[] nums2Null = {};
    //     int[] targetNull = {1};
    //     super.mergeSortedArrayByMyOne(nums1Null, 1, nums2Null, 0, targetNull);
    // }

    @Test
    void mergeSortedArrayByMyTwoTest(){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] target = {1,2,2,3,5,6};
        super.mergeSortedArrayByMyTwo(nums1, 3, nums2, nums2.length, target);
        int[] nums1Null = {1};
        int[] nums2Null = {};
        int[] targetNull = {1};
        super.mergeSortedArrayByMyTwo(nums1Null, 1, nums2Null, 0, targetNull);
    }

    @Test
    void mergeSortedArrayByExpertOneTest(){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] target = {1,2,2,3,5,6};
        super.mergeSortedArrayByExpertOne(nums1, 3, nums2, nums2.length, target);
        int[] nums1Null = {1};
        int[] nums2Null = {};
        int[] targetNull = {1};
        super.mergeSortedArrayByExpertOne(nums1Null, 1, nums2Null, 0, targetNull);
    }

}
