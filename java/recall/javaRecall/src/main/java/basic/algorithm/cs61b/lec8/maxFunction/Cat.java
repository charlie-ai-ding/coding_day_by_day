package basic.algorithm.cs61b.lec8.maxFunction;

import java.util.Collection;
import java.util.Collections;

public class Cat implements Comparable<Cat>{

    private int weight;
    private String name;

    public Cat(String n, int w){
       name =n;
       weight =w;
    }

    @Override
    public int compareTo(Cat o) {
        return this.weight- o.weight;
    }


    public static void main(String[] args) {
        Cat[] cats = {new Cat("miao1",23), new Cat("miao2",12)};

       // Cat maxCat = Collections.max(cats);


    }
}
