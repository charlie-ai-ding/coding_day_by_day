package basic.algorithm.cs61b.lec14.disjointset;

import basic.algorithm.cs61b.lec14.DisjointSets;
import basic.algorithm.cs61b.lec9.ArraySet;

import java.util.Set;

class SetAndIndex{
    private AbstractSet set;
    private int index;

    public SetAndIndex(){

    }
    public void setSet(AbstractSet s){
        set =s;
    }
    public void setIndex(int i){
        index = i;
    }
}

public class DisjointSet<T> implements IDisJointSet<T>{

    private AbstractSet[] initSet;

    private AbstractSet[] connected;

    public DisjointSet(int n){
        initSet = new AbstractSet[n];
        connected = new AbstractSet[n];
    }

    public void of(T... args){
        int count =0;

        for(T t: args){
            AbstractSet temp = new AbstractSet(10);
            temp.append(t);
            initSet[count] = temp;
            connected[count] = temp;
            count +=1;
        }
    }

    private SetAndIndex findSetByValue(T t){
        SetAndIndex rs = new SetAndIndex();
        for(int i=0; i<connected.length;i++){
            if(connected[i].contains(t)){
                rs.setSet(connected[i]);
                rs.setIndex(i);
                return rs;
            }
        }
        return null;
    }
    @Override
    public void connect(T t1, T t2) {

    }

    @Override
    public boolean isConnect(T t1, T t2) {
        return false;
    }
}
