package advance.leetcode.questiontypes.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import studey.advance.leetcode.questiontypes.array.MajorityElementSolution;

public class MajorityElementSolutionTest extends MajorityElementSolution{
    @Test
    void majorityElementByMyOneTest(){
        int[] arrayOneCase = {2,2,1,1,1,2,2};
        int arrayOneCaseResulte = majorityElementByMyOne(arrayOneCase);
        Assertions.assertEquals(2,arrayOneCaseResulte);
        int[] arrayTwoCase = {3,2,3};
        int arrayTwoCaseResulte = majorityElementByMyOne(arrayTwoCase);
        Assertions.assertEquals(3,arrayTwoCaseResulte);
    }
}
