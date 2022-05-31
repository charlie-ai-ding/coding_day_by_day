package basic.algorithm.cs61b.lec14.disjointset;

import basic.algorithm.cs61b.lec9.ArraySet;

public  class AbstractSet<T> {
    private T[] items;
    private int size;

    public AbstractSet(int n){
        items = (T[]) new Object[n];
        size =0;
    }

    public void append(T t){
        items[size] = t;
        size +=1;
    }

    public int size(){
        return size;
    }

    public T get(int i){
        return items[i];
    }

    public AbstractSet<T> mergerSet(AbstractSet<T> set1, AbstractSet<T>  set2){
            int count = set1.size() + set2.size();
            AbstractSet<T> rs = new AbstractSet<T>(count);

            for(int i=0;i< set1.size();i++){
                rs.append(set1.get(i));
            }

            for(int j=0; j<set2.size();j++){
                rs.append(set2.get(j));
            }

            return rs;

    }

    public boolean contains(T t){
        for(int i=0;i<size;i++){
            if(items[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    public AbstractSet<T> getSetByValue(T t){
        if(contains(t)){

            return this;
        }else{
            return null;
        }
    }



}
