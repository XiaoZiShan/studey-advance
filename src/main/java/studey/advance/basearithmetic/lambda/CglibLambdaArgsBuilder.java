package studey.advance.basearithmetic.lambda;


import javax.naming.OperationNotSupportedException;

/**
 * Created by 入参!
 */
@FunctionalInterface
public interface CglibLambdaArgsBuilder<T> {
    CglibLambdaBeanStream<T> build(T s) throws OperationNotSupportedException;
}