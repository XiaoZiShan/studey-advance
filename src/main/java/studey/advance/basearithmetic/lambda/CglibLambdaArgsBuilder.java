package studey.advance.basearithmetic.lambda;

import java.util.Optional;
import java.util.function.Function;

/**
 * Created by 入参!
 */
@FunctionalInterface
public interface CglibLambdaArgsBuilder<T,L,R> {
    
    R build(T t,L a);
    
    default <V> CglibLambdaArgsBuilder<T, L,V> andThen( Function<? super R, ? extends V> after) {
        return (T t, L a) -> Optional.of(after).get().apply(build(t, a));
    }
}