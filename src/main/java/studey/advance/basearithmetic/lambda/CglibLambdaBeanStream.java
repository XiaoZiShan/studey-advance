package studey.advance.basearithmetic.lambda;
import javax.naming.OperationNotSupportedException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

/**
 * Created by cglib lambda 操作 Bean 工具类!
 */
public class CglibLambdaBeanStream <T> {
    
    private T t;
    
    public CglibLambdaBeanStream() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
    
    /**
     * 构造函数
     * @param t 转换参数
     * @param b 是否开启懒加载
     */
    public CglibLambdaBeanStream(T t,Boolean b) {
        this.t = t;
    }
    
    public <T, U extends Comparable<? super U>> Comparator<T>  ignoreing(Function<? super T, ? extends U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        
        return comparing(keyExtractor::apply);
    }
    
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }
    
    public <T, U extends Comparable<? super U>> Comparator<T>  bluring(Function<? super T, ? extends U> keyExtractor) {
        return null;
    }
    
    // 处理 Collection
    public static void toCollection() {
    
    }
    
    // 处理 map
    public static void toMap() {
    
    }
    
    // 处理 Page
    public static void toPageInfo() {
    
    }
}