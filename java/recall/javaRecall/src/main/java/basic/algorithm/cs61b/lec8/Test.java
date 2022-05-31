package basic.algorithm.cs61b.lec8;

public class Test {

    public static void main(String[] args) {
        Animal a  = new Dog();
        Dog d = new Dog();

        a.greet(d);
        a.sniff(d);
        d.praise(d);
        a.praise(d);

    }
}
