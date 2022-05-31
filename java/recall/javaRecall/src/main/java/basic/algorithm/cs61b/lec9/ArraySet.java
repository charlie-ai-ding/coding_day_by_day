package basic.algorithm.cs61b.lec9;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Set<T>, Iterable<T>{

    private T[] items ;
    private int count;


    public ArraySet(){
        items =  (T[]) new Object[1000];
        count =0;

    }
    @Override
    public void add(T t) {
        if(! contains(t)){
            items[count] =t;
            count +=1;
        }else{
            try {
                throw new Exception("existed!! try new one");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean contains(T t) {
        boolean result = false;
        for(int i=0;i<count;i++){
            if(items[i] !=null){
                if(items[i].equals(t)){
                    result = true;
                    break;
                }
            }else{
                if (items[i] == t){
                    result = true;
                    break;
                }
            }

        }
        return result;
    }

    @Override
    public int size() {
        return count;
    }

    public void print(){
        for(int i=0;i<count;i++){
            System.out.print(items[i]+" , ");
        }
    }



    @Override
    public String toString(){

//        StringBuilder sb = new StringBuilder();
//        sb.append("{ ");
//        for (T t: items
//             ) {
//            sb.append(t.toString());
//            sb.append(", ");
//        }
//        sb.append("}");
//        return sb.toString();

        List<String> containers = new ArrayList<>();
       // System.out.println(items.length);
        for(T t: this){
            System.out.println("how many times");
//            System.out.println(t);
            if(t!=null){
                containers.add(t.toString());
            }

        }


        return String.join(",", containers);

    }

    /**
     * How to use generic in static method , must add another extra declaration to tell compiler the generic type,
     * since the static method  can not be infered by instance type .
     */
    public static <T> ArraySet<T> of(T... stuff){

        ArraySet<T> returnSet = new ArraySet<>();

        for(T t : stuff){
            returnSet.add(t);
        }

        return returnSet;
    }


//    @Override
    public boolean equals_old(Object obj) {
        boolean result = true;

        try{
            ArraySet<T> compare = (ArraySet<T>) obj;
            if(this.size() != compare.size()){
                result = false;
            }else{
                for (T t:this
                     ) {
                    if( ! compare.contains(t)){
                        result =false;
                        break;
                    }
                }
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }


        return result;

    }

    @Override
    public boolean equals(Object obj){

        if(this == obj){
            return true;
        }

        if(obj ==null) {
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>)obj;

        if(this.size()!= o.size() ){
            return false;
        }
        for (T t:this
             ) {
            if(! o.contains(t)){
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        Set<Integer> set = new ArraySet<>();

       // System.out.println(set.size());


           // set.add(null);
            set.add(1);
            set.add(2);

            set.add(100);

            set.add(1002);
//            set.add(1);

        Set<Integer> set2 = new ArraySet<>();

        set2.add(2);


//        System.out.println(set == set2);

        System.out.println(set.equals(new ArrayList<>()));

//        System.out.println(set.size());
//
//        ((ArraySet)set).print();

//        for (Object i : (ArraySet)set) {
//            System.out.println(i);
//        }

        ArraySet<String> asetOfString = ArraySet.of("hi","am","chinese");

        System.out.println(asetOfString);

    }

    /**
     *
     * Since this interface is used by the foreach function,while when foreach use it, the first thing is checking hasnext, and then next()
     * so here, in next () we do not need to check hasNext
     *
     */
    @Override
    public Iterator<T> iterator() {

        class ArraySetIterator<T>  implements  Iterator<T> {

            private int begin;

            public ArraySetIterator() {
                begin = 0;
            }

            @Override
            public boolean hasNext() {
                int count = size();
                if (begin < count) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public T next() {
                T t = (T) items[begin];
                begin += 1;
                return t;
            }
        }

       return new ArraySetIterator<>();

//        return null;

    }
}
