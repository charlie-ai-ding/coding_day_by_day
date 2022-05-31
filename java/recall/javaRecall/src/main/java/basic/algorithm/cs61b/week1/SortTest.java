package basic.algorithm.cs61b.week1;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args){

        int[] arr1 ={6,3,7,2,8,1};

        int[] sorted ={1,2,3,6,7,8};

       //Sort.sort(arr1);

       Sort.sort_r(arr1);

         Arrays.stream(arr1).forEach(System.out::println);


    }
}
