package basic.algorithm.cs61b.let15;

public class bigO {

    public static int f3(int n){
        if (n<= 1){
            return 1;
        }
        return f3(n-1)+ f3(n-1);
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(t1);

        f3(10);

        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
