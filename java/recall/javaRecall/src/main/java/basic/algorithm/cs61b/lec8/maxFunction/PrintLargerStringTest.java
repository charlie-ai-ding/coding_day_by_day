package basic.algorithm.cs61b.lec8.maxFunction;

import java.lang.String;

 class StringComparator implements TwoCompareFunction<String>{

    @Override
    public int compare(String o1, String o2) {

        int first = (int)o1.charAt(0);
        int second = (int)o2.charAt(0);
        return first -second;
    }
}

public class PrintLargerStringTest {


    public static void main(String[] args) {
        PrintLarger<String> pl = new PrintLarger<>();
        pl.print_larger("hello","world",new StringComparator());
    }
}
