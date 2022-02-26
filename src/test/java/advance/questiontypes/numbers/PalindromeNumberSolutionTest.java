package advance.questiontypes.numbers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studey.advance.questiontypes.numbers.PalindromeNumberSolution;

public class PalindromeNumberSolutionTest  extends PalindromeNumberSolution {
    @Test
    void isPalindrome(){
        Assertions.assertEquals(true, super.isPalindrome(121));
        Assertions.assertEquals(false,super.isPalindrome(-121));
        Assertions.assertEquals(false, super.isPalindrome(10));
        Assertions.assertEquals(true, super.isPalindrome(0));
    }
}