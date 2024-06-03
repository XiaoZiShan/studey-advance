package advance.leetcode.questiontypes.numbers;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studey.advance.leetcode.questiontypes.numbers.AddBitBinarySolution;

public class AddBitBinarySolutionTest extends AddBitBinarySolution{
    
    @Test
    void addBitBinaryByMyOneTest(){
//        Assertions.assertEquals("100",super.addBitBinaryByMyOne("11","1"));
//        Assertions.assertEquals("10101",super.addBitBinaryByMyOne("1010","1011"));
        Assertions.assertEquals("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",super.addBitBinaryByMyOne("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101","0"));

    }

    @Test
    void templateByExpertOneTest(){
    }
}
