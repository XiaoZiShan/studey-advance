package advance.BaseArithmetic.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studey.advance.BaseArithmetic.recursion.NumberSimplenesRecursion;

/**
 * Created by 用递归计算简单数字
 */
public class NumberSimplenesRecursionTest extends NumberSimplenesRecursion{
    
    @Test
    void removeDuplicates_QuickSlowPointer(){
       Assertions.assertEquals(120,factorial(5));
       Assertions.assertEquals(5050,sum(100));
    }
}