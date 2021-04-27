package studey.advance.basearithmetic.lambda;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import studey.advance.datastructure.pojo.MbRelatedWeightResource;

import java.math.BigDecimal;
import java.nio.file.PathMatcher;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by lambda 演示
 */
public class LambdaDemoSolution {


    interface MathOperation {
        String sayMessage(Integer b);
    }

    // lambda 原生函数风格
    public String lambdaApi(Integer data){
        String salutation = "Hello lambda";
        MathOperation addition = (Integer b) -> salutation  +  b.toString();
        return addition.sayMessage(data);
    }

    // lambda 流api 1.1
    public List lambdaStreamApi(List<MbRelatedWeightResource> data){
        return data.stream().sorted(comparing(MbRelatedWeightResource::getMlRecommended)
            .thenComparing(MbRelatedWeightResource::getThroughWeight)
            .thenComparing(MbRelatedWeightResource::getHeat).reversed()).collect(Collectors.toList());
    }

    // lambda 并行流api 1.2
    public List lambdaParallelStreamApi(List<MbRelatedWeightResource> data){
        return data.parallelStream().sorted(comparing(MbRelatedWeightResource::getMlRecommended)
            .thenComparing(MbRelatedWeightResource::getThroughWeight)
            .thenComparing(MbRelatedWeightResource::getHeat).reversed()).collect(Collectors.toList());
    }

    // lambda 缩减api 1.3
    public Integer lambdaCurtailApi(List<MbRelatedWeightResource> data){
        return data.stream()
            .map(MbRelatedWeightResource::getThroughWeight)
            .reduce(BigDecimal.ZERO.intValue(), (a,b) -> a+b);
    }

    // lambda 映射api 1.4
    public Map lambdaMaplApi(List<MbRelatedWeightResource> data){
        // 把 MbRelatedWeightResource 转换为Map[ThroughWeight]=Heat:
        return data.stream().map(kv -> {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(kv.getThroughWeight(),kv.getHeat());
            return map;
        }).reduce(new HashMap<>(),(m1,m2)->{
            m1.putAll(m2);
            return m2;
        });
    }

    // lambda Spliterator api 1.5
    public void lambdaSpliteratorApi(List<MbRelatedWeightResource> data){
        System.out.println(data.stream().spliterator().getExactSizeIfKnown());
        data.stream().spliterator().trySplit().forEachRemaining(System.out::println);
    }

   // 非流api 的 lambda Runnable api 2.1
    public static Thread getThread() throws InterruptedException {
        return  new Thread(() -> System.out.println("In Java8, Lambda expression"));
    }

    // 非流api 的 lambda PathMatcher api 2.2
    public static PathMatcher getPathMatcher(){
        return Objects::nonNull;
    }

    // 非流api 的 lambda PathMatcher api 2.2
    public static AfterTestExecutionCallback getAfterTestExecutionCallback() {
        return (ExtensionContext context) ->{
            if(Objects.nonNull(context)){
                throw new NullPointerException();
            }
        };
    }

}