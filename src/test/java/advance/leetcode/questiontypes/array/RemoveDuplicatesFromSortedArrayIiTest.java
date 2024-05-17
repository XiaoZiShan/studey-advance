

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;

// /**
// * Created by 刷题使我快乐,自律使我自由 !
// * <p>
// * <p>
// * 80. 删除排序数组中的重复项 II
// * <p>
// * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
// <<<<<<< HEAD:test/advance/QuestionTypes/Array/RemoveDuplicatesFromSortedArrayIiTest.java
// * <p>
// * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
// * <p>
// * 示例 1:
// * <p>
// * 给定 nums = [1,1,1,2,2,3],
// * <p>
// * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
// * <p>
// * 你不需要考虑数组中超出新长度后面的元素。
// * 示例 2:
// * <p>
// * 给定 nums = [0,0,1,1,1,1,2,3,3],
// * <p>
// * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
// * <p>
// * 你不需要考虑数组中超出新长度后面的元素。
// * 说明:
// * <p>
// * 为什么返回数值是整数，但输出的答案是数组呢?
// * <p>
// * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
// * <p>
// * 你可以想象内部操作如下:
// * <p>
// * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
// * int len = removeDuplicates(nums);
// * <p>
// * // 在函数里修改输入数组对于调用者是可见的。
// * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
// * for (int i = 0; i < len; i++) {
// *     print(nums[i]);
// * }
// */
// public class RemoveDuplicatesFromSortedArrayIiTest extends RemoveDuplicatesFromSortedArrayIiSolution {

//    @Test
//    void removeDuplicates_QuickSlowPointer() {
//        Assertions.assertEquals(6, removeDuplicates_QuickSlowPointer(new int[]{1,1,1, 2,2,2, 3,3,3}));
//        Assertions.assertEquals(7, removeDuplicates_QuickSlowPointer(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
//        Assertions.assertEquals(2, removeDuplicates_QuickSlowPointer(new int[]{1,1,1,1,1}));
//        Assertions.assertEquals(5, removeDuplicates_QuickSlowPointer(new int[]{1, 1, 1, 2, 2, 3}));
//    }

//    @Test
//    void removeDuplicates_QuickSlowPointer_LeetCode() {
//        Assertions.assertEquals(6, removeDuplicates_DoublePointer_LeetCode(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
//        Assertions.assertEquals(7, removeDuplicates_DoublePointer_LeetCode(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
//        Assertions.assertEquals(2, removeDuplicates_DoublePointer_LeetCode(new int[]{1, 1, 1, 1, 1}));
//        Assertions.assertEquals(5, removeDuplicates_DoublePointer_LeetCode(new int[]{1, 1, 1, 2, 2, 3}));

// //
// // 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
// //
// // 示例1:
// //
// // 给定 nums = [1,1,1,2,2,3],
// //
// // 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
// //
// // 你不需要考虑数组中超出新长度后面的元素。
// // 示例2:
// //
// // 给定 nums = [0,0,1,1,1,1,2,3,3],
// //
// // 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
// //
// // 你不需要考虑数组中超出新长度后面的元素。
// // 说明:
// //
// // 为什么返回数值是整数，但输出的答案是数组呢?
// //
// // 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
// //
// // 你可以想象内部操作如下:

//        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
// // int len = removeDuplicates(nums);
// //
// // // 在函数里修改输入数组对于调用者是可见的。
// // // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
// // for (int i = 0; i < len; i++) {
// //     print(nums[i]);
// // }
//    }
// }