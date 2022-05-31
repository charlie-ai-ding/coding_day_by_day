package basic.algorithm.cs61b.lec8;

/**
 * Dynamic method selection:
 * 2 steps process:
 * At complie time: static type
 * At runtime,  the dynamic type of the invoking object uses its methods with the exact signature
 *
 */
public class Dog implements  Animal{
   // default void greet(Animal a)
    @Override
    public void sniff(Animal a){
        System.out.println("dog sniff animal");
    }

    // default void praise(Animal a)  // inherit from parent interface
    // this is overload
    void praise(Dog a){
        System.out.println("u r cool dog");
    }

}
