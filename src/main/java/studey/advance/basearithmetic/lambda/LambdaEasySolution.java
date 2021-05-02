package studey.advance.basearithmetic.lambda;

import org.junit.jupiter.api.function.ThrowingConsumer;
import studey.advance.datastructure.pojo.MbRelatedWeightResource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by 构建 Lambda 入门例子
 */
public class LambdaEasySolution {
    
    /*
        匿名函数式接口风格
        1. 接口类只能定义一个接口
        2. jdk 1.8 后接口默认使用 public abstract 修饰
        3. 可以写多个 default 方法, 以及 Override Object 类的抽象接口
        4. 如果 FunctionalInterface 的抽象方法具有相同的签名，则它们可以由其他功能接口扩展。
        5. 用lambda表达式代替了内部类，但这两个概念在一个重要方面有所不同：作用域。
     */
    @FunctionalInterface
    public interface Demo1 {
        
        String method(String string);
        
        default String def1() {
            return "?:";
        }
        
        default String def2() {
            return "?:";
        }
        
        @Override
        boolean equals(Object obj);
    }
    
    public String add1(String string, Demo1 demo1) {
        return demo1.method(string);
    }
    
    public String add2(String string, Function<String, String> fn) {
        return fn.apply(string);
    }
    
    /*
     * 不使用 lambda 调用 stream api
     */
    public List<MbRelatedWeightResource> noLambdaUseStreamApi() {
        List<MbRelatedWeightResource> compareToList = new ArrayList<>();
        compareToList.add(new MbRelatedWeightResource(100, 51, 21));
        compareToList.add(new MbRelatedWeightResource(100, 51, 20));
        compareToList.add(new MbRelatedWeightResource(101, 1, 1));
        compareToList.add(new MbRelatedWeightResource(100, 50, 20));
        // 调用比较器进行排序
    
        return compareToList.stream().sorted(new Comparator<MbRelatedWeightResource>() {
            @Override
            public int compare(MbRelatedWeightResource o1, MbRelatedWeightResource o2) {
                return o1.getHeat() - o2.getHeat();
            }
        }).filter(new Predicate<MbRelatedWeightResource>() {
            @Override
            public boolean test(MbRelatedWeightResource mbRelatedWeightResource) {
                return mbRelatedWeightResource.getHeat() != 1;
            }
        }).collect(Collectors.toList());
    }
    
    /*
     * 自定义 Lambda 包装器处理异常
     */
    protected static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(ThrowingConsumer<T> throwingConsumer,
            Class<E> exceptionClass) {
        
        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println(
                            "捕获指定异常 : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        };
    }
    
}