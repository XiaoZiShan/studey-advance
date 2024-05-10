package advance.leetcode.questiontypes.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import studey.advance.leetcode.questiontypes.array.MajorityElementSolution;

public class MajorityElementSolutionTest extends MajorityElementSolution{
    @Test
    void majorityElementByMyOneTest(){
        int[] arrayOneCase = {2,2,1,1,1,2,2,5};
        int arrayOneCaseResulte = super.majorityElementByMyOne(arrayOneCase);
        Assertions.assertEquals(2,arrayOneCaseResulte);
        int[] arrayTwoCase = {3,2,3};
        int arrayTwoCaseResulte = super.majorityElementByMyOne(arrayTwoCase);
        Assertions.assertEquals(3,arrayTwoCaseResulte);
    }

    @Test
    void majorityElementByMyTwoTest(){
        int[] arrayOneCase = {2,2,1,1,1,2,2,5};
        int arrayOneCaseResulte = super.majorityElementByMyTwo(arrayOneCase);
        Assertions.assertEquals(2,arrayOneCaseResulte);
        int[] arrayTwoCase = {3,2,3};
        int arrayTwoCaseResulte = super.majorityElementByMyTwo(arrayTwoCase);
        Assertions.assertEquals(3,arrayTwoCaseResulte);
    }
    
    
    @Test
    void majorityElementByExpertOneTest(){
        int[] arrayOneCase = {2,2,1,1,1,2,2,5};
        int arrayOneCaseResulte = super.majorityElementByExpertOne(arrayOneCase);
        Assertions.assertEquals(2,arrayOneCaseResulte);
        int[] arrayTwoCase = {3,2,3};
        int arrayTwoCaseResulte = super.majorityElementByExpertOne(arrayTwoCase);
        Assertions.assertEquals(3,arrayTwoCaseResulte);
    }
}
