package studey.advance.leetcode.basearithmetic.lambda;
import lombok.AllArgsConstructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

import javax.naming.OperationNotSupportedException;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by cglib lambda 操作 Lazy Bean 工具类!
 */

public class CglibLambdaLazyBeanStream <T> {

    // cglib 要求data 入参必须有空参构造 @NoArgsConstructor
    private T data;

    private Boolean areLazy;

    public CglibLambdaLazyBeanStream() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * 构造函数
     * @param data 需转换数据
     * @param b 是否开启懒加载
     */
    public CglibLambdaLazyBeanStream(T data,Boolean b) {
        this.data = data;
        this.areLazy = b;
    }

    // 处理 VO
    public Optional toVO() {
        if (Boolean.TRUE.equals(areLazy)){
            LazyLoader lazy = new ConcreteClassLazyLoader(this.data.getClass(),data);
            return Optional.ofNullable(Enhancer.create(this.data.getClass(),lazy));
        }else {
            return Optional.ofNullable(data);
        }
    }

    // 处理 Collection
    public Stream<T> toCollection() throws OperationNotSupportedException {
        if (Boolean.FALSE.equals(data instanceof Collection)){
            throw new OperationNotSupportedException();
        }

        if (Boolean.TRUE.equals(areLazy)){
            LazyLoader lazy = new ConcreteClassLazyLoader(this.data.getClass(),data);
            return Stream.of((T) Enhancer.create(this.data.getClass(),lazy));
        }else {
            return  Stream.of(data);
        }
    }

    // 更多功能自行扩展
}


@AllArgsConstructor
class ConcreteClassLazyLoader<E,T> implements LazyLoader {

    private Class<E> exceptionClass;

    private T data;

    @Override
    public E loadObject() throws Exception {
        System.out.println("LazyLoader loadObject() ...");
        E exCast = exceptionClass.cast(data);
        return exCast;
    }
}
