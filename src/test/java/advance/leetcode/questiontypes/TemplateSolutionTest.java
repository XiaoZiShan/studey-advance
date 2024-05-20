package advance.leetcode.questiontypes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import studey.advance.leetcode.questiontypes.TemplateSolution;

public class TemplateSolutionTest extends TemplateSolution{
    
    @Test
    void templateByMyOneTest(){
        Assertions.assertEquals(0,super.templateByMyOne(-1));
        Assertions.assertEquals(2,super.templateByMyOne(1));
    }

    @Test
    void templateByExpertOneTest(){
        Assertions.assertEquals(0,super.templateByExpertOne(-1));
        Assertions.assertEquals(2,super.templateByExpertOne(1));
    }
}
