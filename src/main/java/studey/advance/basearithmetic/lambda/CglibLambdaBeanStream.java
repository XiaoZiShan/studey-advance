package studey.advance.basearithmetic.lambda;
import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Created by cglib lambda 操作 Bean 工具类!
 */
public class CglibLambdaBeanStream <T> {
    
    private T t;
    
    public CglibLambdaBeanStream() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
    
    
    public CglibLambdaBeanStream(List t) {
        CglibLambdaArgsBuilder.build();
    }
    
    
    public CglibLambdaBeanStream<T> map(T t) {
        return null;
    }
        
    // 处理为VO
    public T toVO() {
       return t;
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