package basic.algorithm.cs61b.lec8.maxFunction;

public class PrintLarger<T> {

    public  T print_larger(T x, T y, TwoCompareFunction f){

        if (f.compare(x,y)>0){
            System.out.println(x);
            return x;
        }
        System.out.println(y);
        return y;

    }


}
