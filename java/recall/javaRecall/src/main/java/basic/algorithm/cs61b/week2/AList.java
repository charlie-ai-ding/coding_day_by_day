package basic.algorithm.cs61b.week2;

import java.lang.reflect.Array;

public class AList<T> {

    private T[] container ;
    private int count;



    public AList(){
       container = (T[]) new Object[1000];
       count=0;
    }

    public void addLast(T t){
        if(count>= container.length * 0.9){
            T[] extend = (T[])new Object[container.length *2];
            System.arraycopy(container,0,extend,0,count);
            container = extend;
        }

        container[count] = t;
        count+=1;
    }

    public T removeLast(){

        T result = container[count-1];
        container[count-1] = null;
        count = count-1;

        return result;
    }

    public T get(int i){

        return container[i];
    }

    public int size(){
        return count;
    }

    public static void main(String[] args){
        AList<Integer> aList = new AList<>();

        aList.addLast(1);

        aList.addLast(2);
        aList.addLast(3);

        System.out.println(aList);
    }

}
