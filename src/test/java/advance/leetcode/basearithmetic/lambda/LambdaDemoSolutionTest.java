package advance.leetcode.basearithmetic.lambda;

import org.junit.jupiter.api.*;
import studey.advance.leetcode.basearithmetic.lambda.LambdaDemoSolution;
import studey.advance.leetcode.datastructure.pojo.MbRelatedWeightResource;

import java.util.ArrayList;
import java.util.List;


@DisplayName("使用 lambda 演示原始语法与api")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LambdaDemoSolutionTest extends LambdaDemoSolution {

    @Test
    @Order(1)
    @DisplayName("lambdaApi 原生函数风格")
    void lambdaApi() throws InterruptedException {
        System.out.println(super.lambdaApi(1024));
    }

    @Test
    @Order(2)
    @DisplayName("lambdaApi 流api")
    void lambdaStreamApi() throws InterruptedException {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        comparatorList.add(new MbRelatedWeightResource(100, 51, 21));
        System.out.println(super.lambdaStreamApi(comparatorList));
    }

    @Test
    @Order(3)
    @DisplayName("lambdaApi 并行流api")
    void lambdaParallelStreamApi() throws InterruptedException {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        comparatorList.add(new MbRelatedWeightResource(100, 51, 21));
        System.out.println(super.lambdaParallelStreamApi(comparatorList));
    }

    @Test
    @Order(4)
    @DisplayName("lambdaApi 缩减api")
    void lambdaCurtailApi() throws InterruptedException {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(301, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        comparatorList.add(new MbRelatedWeightResource(100, 51, 21));
        System.out.println(super.lambdaCurtailApi(comparatorList));
    }


    @Test
    @Order(5)
    @DisplayName("lambdaApi 映射api")
    void lambdaMaplApi() throws InterruptedException {
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        comparatorList.add(new MbRelatedWeightResource(100, 51, 21));
        System.out.println(super.lambdaMaplApi(comparatorList));
    }

    @Test
    @Order(6)
    @DisplayName("lambdaApi Spliterator api")
    void lambdaSpliteratorApi(){
        List<MbRelatedWeightResource> comparatorList = new ArrayList<>();
        comparatorList.add(new MbRelatedWeightResource(100, 51, 20));
        comparatorList.add(new MbRelatedWeightResource(101, 1, 1));
        comparatorList.add(new MbRelatedWeightResource(100, 50, 20));
        comparatorList.add(new MbRelatedWeightResource(100, 51, 21));
        super.lambdaSpliteratorApi(comparatorList);
    }


    @Test
    @Order(7)
    @DisplayName("lambdaApi getThread api")
    void lGetThread() throws InterruptedException {
        getThread().run();
    }

    @Test
    @Order(8)
    @DisplayName("lambdaApi getPathMatcher api")
    void lGetGetPathMatcher() throws InterruptedException {
        System.out.println(getPathMatcher().matches(null));
    }

    @Test
    @Order(9)
    @DisplayName("lambdaApi getThread api")
    void lGetAfterTestExecutionCallback() throws Exception {
       getAfterTestExecutionCallback().afterTestExecution(null);
    }

}
