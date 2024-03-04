package advance.leetcode.basearithmetic.lambda;

import org.junit.jupiter.api.*;
import studey.advance.leetcode.basearithmetic.lambda.LambdaEasySolution;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by  构建 Lambda 入门例子单元测试!
 */
@DisplayName("使用 lambda 演示原始语法与api")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LambdaEasySolutionTest extends LambdaEasySolution {

    @Test
    @Order(1)
    @DisplayName("lambdaApi lambda接口 add")
    void Demo1add(){
        Demo1 demo1 = parameter -> parameter + " from lambda";
        System.out.println(super.add1("Message ", demo1));
    }

    @Test
    @Order(2)
    @DisplayName("lambdaApi Function 接口 add ")
    void Demo2add(){
        Function<String, String> fn =
                parameter -> parameter + " from lambda";
        System.out.println(super.add2("Message ", fn));
    }

    @Test
    @Order(3)
    @DisplayName("不使用 lambda 调用 stream api")
    void NoLambdaUseStreamApi(){
        System.out.println(super.noLambdaUseStreamApi());
    }

    @Test
    @Order(4)
    @DisplayName("静态方法引用")
    void NoLambdaUseS(){
        List<Integer> integers = Arrays.asList(3, 3, 1, 3);
        System.out.println(integers.stream().map(integers::get).collect(Collectors.toList()));
    }

    @Test
    @Order(5)
    @DisplayName("自定义 Lambda 包装器处理异常")
    void HandlingConsumerWrapper(){
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(
                handlingConsumerWrapper(
                        i -> System.out.println(50 / i),
                        ArithmeticException.class));
    }
}
