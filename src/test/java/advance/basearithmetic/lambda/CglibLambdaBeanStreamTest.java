package advance.basearithmetic.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @see studey.advance.basearithmetic.lambda.CglibLambdaBeanStream 测试用例
 */
@DisplayName("使用 lambda 改造 cglib bean 赋值")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CglibLambdaBeanStreamTest  {
    
    @Test
    @Order(1)
    @DisplayName("bean Map to VO")
    void toVO() {
     
        System.out.println();
    }
    
    @Test
    @Order(2)
    @DisplayName("bean Map to Collection")
    void toCollection() {
    
    }
    
    
    @Test
    @Order(3)
    @DisplayName("bean Map to Collection")
    void toMap() {
    
    }
    
    @Test
    @Order(4)
    @DisplayName("bean Map to Collection")
    void toPageInfo() {
    
    }
}