package basic.algorithm.cs61b.lec8.maxFunction;

public class MaxFunction {
    public static Compareable max(Compareable[] items){
        int maxDex =0;

        for(int i=0;i<items.length;i++){
            if(items[i].greatThen(items[maxDex])){
                maxDex =i;
            }
        }
        return items[maxDex];
    }



}
