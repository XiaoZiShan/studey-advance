package advance.leetcode.questiontypes.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import studey.advance.leetcode.questiontypes.numbers.TwoSumSolution;

public class TwoSumSolutionTest extends TwoSumSolution{
    
    @Test
    void twoSumByMyOneTest(){
        int[] param = {2,7,11,15};
        int[] resultIndexs = {0,1};
        Assertions.assertArrayEquals(resultIndexs,super.twoSumByMyOne(param, 9));
        int[] paramOne =  {3,2,4};
        int[] resultIndexsOne = {1,2};
        Assertions.assertArrayEquals(resultIndexsOne,super.twoSumByMyOne(paramOne, 6));   
        int[] paramTwo =  {3,3};
        int[] resultIndexsTwo = {0,1};
        Assertions.assertArrayEquals(resultIndexsTwo,super.twoSumByMyOne(paramTwo, 6));   
        int[] parameThree =  {1};
        int[] resultIndexsThree = {-1,-1};
        Assertions.assertArrayEquals(resultIndexsThree,super.twoSumByMyOne(parameThree, 1));   
    }

    @Test
    void twoSumByMyTwoTest(){
        int[] param = {2,7,11,15};
        int[] resultIndexs = {0,1};
        Assertions.assertArrayEquals(resultIndexs,super.twoSumByMyTwo(param, 9));
        int[] paramOne =  {3,2,4};
        int[] resultIndexsOne = {1,2};
        Assertions.assertArrayEquals(resultIndexsOne,super.twoSumByMyTwo(paramOne, 6));   
        int[] paramTwo =  {3,3};
        int[] resultIndexsTwo = {0,1};
        Assertions.assertArrayEquals(resultIndexsTwo,super.twoSumByMyTwo(paramTwo, 6));   
        int[] parameThree =  {1};
        int[] resultIndexsThree = {-1,-1};
        Assertions.assertArrayEquals(resultIndexsThree,super.twoSumByMyTwo(parameThree, 1));   
    }
}
