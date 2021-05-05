package advance.basearithmetic.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import studey.advance.basearithmetic.lambda.CglibLambdaArgsBuilder;
import studey.advance.basearithmetic.lambda.CglibLambdaLazyBeanStream;
import studey.advance.datastructure.pojo.MbRelatedWeightResource;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see studey.advance.basearithmetic.lambda.CglibLambdaLazyBeanStream 测试用例
 */
@DisplayName("使用 lambda 改造 cglib lazy bean 赋值")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CglibLambdaLazyBeanStreamTest  {
    
    @Test
    @Order(1)
    @DisplayName("bean lazy Maping to VO")
    void toVO() throws Throwable {
        CglibLambdaArgsBuilder<MbRelatedWeightResource, Boolean, CglibLambdaLazyBeanStream> builder = CglibLambdaLazyBeanStream::new;
        CglibLambdaLazyBeanStream clStream = builder.build(new MbRelatedWeightResource(100, 51, 20),Boolean.TRUE);
        MbRelatedWeightResource mrwr1 = (MbRelatedWeightResource)clStream.toVO().get();
        // System.out.println(mrwr1);
        MbRelatedWeightResource mrwr = (MbRelatedWeightResource)clStream.toVO().orElseThrow(RuntimeException::new);
        System.out.println(mrwr.getHeat());
        System.out.println(mrwr.getMlRecommended());
        System.out.println(mrwr.getThroughWeight());
    }
    
    @Test
    @Order(2)
    @DisplayName("bean lazy Maping to Collection")
    void toCollection() throws OperationNotSupportedException {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        CglibLambdaArgsBuilder<List<MbRelatedWeightResource>, Boolean, CglibLambdaLazyBeanStream> builder = CglibLambdaLazyBeanStream::new;
        CglibLambdaLazyBeanStream<MbRelatedWeightResource> clStream = builder.build(comparatorList, Boolean.TRUE);
        List<MbRelatedWeightResource> list1 = clStream.toCollection().collect(Collectors.toList());
        // System.out.println(list1);
        Stream<MbRelatedWeightResource> stream = clStream.toCollection();
        System.out.println(stream.collect(Collectors.toList()));
        
    }
}