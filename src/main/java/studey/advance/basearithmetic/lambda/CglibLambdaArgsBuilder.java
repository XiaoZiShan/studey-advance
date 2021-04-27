package studey.advance.basearithmetic.lambda;

import java.util.Objects;

/**
 * Created by 入参!
 */
@FunctionalInterface
public interface CglibLambdaArgsBuilder<T> {
    CglibLambdaBeanStream<T> build(Object s);
    
    static CglibLambdaArgsBuilder build() {
        return (Object context) -> {
            if (Objects.nonNull(context)) {
                throw new NullPointerException();
            }
            return null;
        };
    }
}