package basic.algorithm.cs61b.week1;

public class hwo {

    public static void main(String[] args){

    }

    /**
     * a = {1, 2, -3, 4, 5, 4}
     * n = 3
     *
     * 1: current index do replace or not
     * 2: if do ,how to get new value
     */

    /**
     *  a[i] through a[i+n]
     */
    private static int help_getItemsAndSum(int[] arr,int currentIndex,int n){
        int result =0 ;
        int range = arr.length-1;

        if((currentIndex +n) <range){
            range = currentIndex +n;
        }

        for(int i = currentIndex; i<= range; i++){
                result = result + arr[i];
        }
        return result;
    }

    public static int[] windowPosSum(int[]a, int n){
        int range = a.length;
        int[] newarr = new int[a.length];

        for(int i=0 ; i< range-1;i++){
            int temp = a[i];
            if(temp>0){
                newarr[i] = help_getItemsAndSum(a,i,n);
            }else{
                newarr[i]= a[i];
            }
        }

        return newarr;
    }

}
