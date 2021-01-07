package studey.advance.BaseArithmetic.recursion;

import sun.jvm.hotspot.tools.SysPropsDumper;

public class NumberSimplenesRecursion {
    
    // 递归阶乘
    public int factorial(int n){
        if(n <= 1){
            return n ;
        }else{
            return n*factorial(n-1);
        }
    }
    // 递归求和
    public int sum(int f){
        if(f <= 1){
            return f ;
        }else{
            return f + sum(f-1);
        }
    }
}