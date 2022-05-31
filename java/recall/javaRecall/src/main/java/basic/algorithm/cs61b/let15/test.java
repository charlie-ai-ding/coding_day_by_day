package basic.algorithm.cs61b.let15;

public class test {

    public static void main(String[] args) {
         int []  aa = new int[]{1,2,3,4,5,6,7};

         print(aa,0,aa.length);
    }

    public static void print(int[] arr, int start, int end){
        if(start >arr.length-1){
            return;
        }
        if(start<0){
            return;
        }
        if(start >end){
            return;
        }
        if(start == end){
            System.out.println(arr[start]);
        }else{
            int middle = (start +end) /2;
            System.out.println(arr[middle]);
            print(arr,start,middle-1);
            print(arr,middle+1,end);
        }
    }
}
