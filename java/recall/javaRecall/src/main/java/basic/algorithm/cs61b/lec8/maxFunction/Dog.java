package basic.algorithm.cs61b.lec8.maxFunction;

import java.util.Comparator;

public class Dog implements Compareable{

    private int weight;
    private String name;

    public Dog(int w,String n)
    {
        weight =w;
        name =n;
    }

    public void bark(){
        if(weight<5){
            System.out.println("wanger wanger");
        }else if(weight<50){
            System.out.println("wang wang");
        }else {
            System.out.println("Woo Woo");
        }
    }
    @Override
    public boolean greatThen(Compareable other) {
        Dog d = (Dog) other;
        return this.weight > d.weight;
    }

//    public static class NameComparator implements Comparator<Dog>{
//        public int compare(Dog a, Dog b){
//            return a.name.compareTo(b.name);
//        }
//    }


    private static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }

        public static void main(String[] args) {
        Dog[] dogs = {new Dog(1,"d1"), new Dog(15,"d15"),new Dog(57,"d57"), new Dog(100,"d100")};

        Dog maxDog = (Dog) MaxFunction.max(dogs);

        maxDog.bark();

//        Dog.NameComparator nc = new Dog.NameComparator();
//
        Comparator<Dog> nc = Dog.getNameComparator();

        if(nc.compare(dogs[0],dogs[1]) >0){
            dogs[0].bark();
        }
    }

}
