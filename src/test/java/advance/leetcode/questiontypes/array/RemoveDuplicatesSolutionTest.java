package advance.leetcode.questiontypes.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import studey.advance.leetcode.questiontypes.array.RemoveDuplicatesSolution;

public class RemoveDuplicatesSolutionTest extends RemoveDuplicatesSolution{
    @Test
    void removeDuplicatesByMyOneTest(){
        int[] paramCaseOne = new int[]{1,1, 2,2,2, 3,3,3};
        int[] targetCaseOne = new int[]{1,2,3};

        Assertions.assertEquals(targetCaseOne.length, removeDuplicatesByMyOne(paramCaseOne));
        this.checkAfterArray(targetCaseOne, paramCaseOne);
        int[] paramCaseTwo = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] targetCaseTwo = new int[]{0,1,2,3};
        Assertions.assertEquals(targetCaseTwo.length, removeDuplicatesByMyOne(targetCaseTwo));
        this.checkAfterArray(targetCaseTwo,paramCaseTwo);
    }

    void checkAfterArray(int[] target,int[] after){
        for (int i = 0; i < after.length; i++) {
            Assertions.assertEquals(after[i] , target[i]);
        }
    }
}
