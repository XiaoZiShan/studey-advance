package advance.basearithmetic.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import studey.advance.basearithmetic.lambda.CglibLambdaArgsBuilder;
import studey.advance.basearithmetic.lambda.CglibLambdaBeanStream;
import studey.advance.datastructure.pojo.MbRelatedWeightResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @see studey.advance.basearithmetic.lambda.CglibLambdaBeanStream 测试用例
 */
@DisplayName("使用 lambda 改造 cglib bean 赋值")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CglibLambdaBeanStreamTest  {
    
    @Test
    @Order(1)
    @DisplayName("bean Maping to VO")
    void toVO() {
        CglibLambdaArgsBuilder<MbRelatedWeightResource, Boolean, CglibLambdaBeanStream> builder = CglibLambdaBeanStream::new;
        CglibLambdaBeanStream clStream = builder.build(new MbRelatedWeightResource(100, 51, 20),Boolean.FALSE);
    
    }
    
    @Test
    @Order(2)
    @DisplayName("bean Maping to Collection")
    void toCollection() {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
//        CglibLambdaBeanStream<List<MbRelatedWeightResource>> cglibLambdaBeanStream = new CglibLambdaBeanStream<List<MbRelatedWeightResource>>(comparatorList);
//        cglibLambdaBeanStream.ignoreing(MbRelatedWeightResource::getHeat);
    }
    
    
    @Test
    @Order(3)
    @DisplayName("bean Maping to Collection")
    void toMaping() {
    
    }
    
    @Test
    @Order(4)
    @DisplayName("bean Maping to Collection")
    void toPageInfo() {
    
    }
}