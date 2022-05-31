package basic.algorithm.cs61b.week1;

public class Sort {

    /**
     * 637281
     * 1: in a range to select the min one
     * 2: swiper the min one and left side from begin
     *
     * 3: repeat the process until timers = arr.length -1
     */
    private static int help_min_index_in_range(int[] arr, int times){
        int index = 0;
        int minNum = Integer.MAX_VALUE;

        for(int i= arr.length-1; i >=times-1; i--){
            if(arr[i]<minNum){
                minNum = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static void swap(int[] arr, int index, int times){
        int temp = arr[times-1];
        arr[times-1] = arr[index];
        arr[index] =temp;
    }


    public static void sort(int[]arr){

       for(int i =1; i<=arr.length-1;i++){
           int index = help_min_index_in_range(arr,i);
           swap(arr,index,i);
       }

    }

    private static void help_sort(int[] arr, int times){
        if(times<=arr.length-1){
            int index = help_min_index_in_range(arr,times);
            swap(arr,index,times);
            help_sort(arr,times+1);
        }
    }

    public static void sort_r(int[] arr){
        help_sort(arr,1);
    }

}
