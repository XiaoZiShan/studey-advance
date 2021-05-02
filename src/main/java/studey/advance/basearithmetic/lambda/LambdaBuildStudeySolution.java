package studey.advance.basearithmetic.lambda;

/**
 * Created by 构建 Lambda 入门例子
 */
public class LambdaBuildStudeySolution {

    /** 匿名函数式接口定义
        1. 接口类只能定义一个接口
        2. 接口默认使用 public abstract
        3.
     */
    @FunctionalInterface
    public interface Foo {
        String method(String string);
    }

    public String add(String string, Foo foo) {
        return foo.method(string);
    }

}