package basic.algorithm.cs61b.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Dog {

    public int weight;

    public Dog(int w){
        weight =w;
    }


    public String toString(){
        return String.valueOf(weight);
    }

    /**
     *  from left to right;
     *  according the ruler left 2 and right 2  + if at the end, right side can be 0 or 1
     *
     *  1: the range to iterate
     *  2: left side start
     *  3: right side to close
     *
     * //
     * 1 :left 2 and right 2 less  the target
     * 2: if at the end of right ,2 can be 0 or 1 but, must less the target
     */
    private static Boolean help_left2_right2(Dog[] arr, int current){
        Boolean result =true;

        int leftPoint = current -2;
        int rightPoint = current+2;
        if(rightPoint>arr.length-1){
            rightPoint = arr.length-1;
        }

        int currentWeight = arr[current].weight;

        for(int i= leftPoint; i<= rightPoint;i++){
            if(arr[i].weight >currentWeight){
                result = false;
                break;
            }
        }


        return result;


    }

    public static ArrayList<Dog>  largerThanFourNeighbors(Dog[] dogs){
        ArrayList<Dog> result = new ArrayList<>();
        int rightSide = dogs.length -1;

        // 10,15,20,15,10,5,10,15,22,20}
        // 10,15,20,15,10,5,10,15,22,23

        for(int i=2;i<= rightSide; i++) {
            if (help_left2_right2(dogs, i)) {
                result.add(dogs[i]);
            }
        }

        return  result;
    }


    public static void main(String[] args){
        Dog[] dogs = new Dog[10];
        // will return 20 and 22
        int[] weight2 ={10,15,20,15,10,5,10,15,22,20};

        for(int i=0;i< weight2.length;i++){
            dogs[i] = new Dog(weight2[i]);
        }

        ArrayList<Dog> t1 = largerThanFourNeighbors(dogs);

        t1.forEach(System.out::println);


    }
}
