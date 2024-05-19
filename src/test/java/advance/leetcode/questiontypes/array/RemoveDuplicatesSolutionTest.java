package advance.leetcode.questiontypes.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import studey.advance.leetcode.questiontypes.array.RemoveDuplicatesSolution;

public class RemoveDuplicatesSolutionTest extends RemoveDuplicatesSolution{
    @Test
    void removeDuplicatesByMyOneTest(){
        int[] paramCaseOne = new int[]{1,1, 2,2,2, 3,3,3};
        int[] targetCaseOne = new int[]{1,2,3};
        Assertions.assertEquals(targetCaseOne.length, super.removeDuplicatesByMyOne(paramCaseOne,targetCaseOne));

        int[] paramCaseTwo = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] targetCaseTwo = new int[]{0,1,2,3};
        Assertions.assertEquals(targetCaseTwo.length, super.removeDuplicatesByMyOne(paramCaseTwo,targetCaseTwo));

        int[] paramCaseThree = new int[]{1,1,2};
        int[] targetCaseThree = new int[]{1,2};
        Assertions.assertEquals(targetCaseThree.length, super.removeDuplicatesByMyOne(paramCaseThree,targetCaseThree));
    }
}
