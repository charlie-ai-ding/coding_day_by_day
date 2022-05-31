package basic.algorithm.cs61b.lec8;

public class DoubleMulitply {
    public static int twice_apply (HighOrderFunction f,int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        System.out.println(DoubleMulitply.twice_apply(new MulityTwo(),100));
    }
}
