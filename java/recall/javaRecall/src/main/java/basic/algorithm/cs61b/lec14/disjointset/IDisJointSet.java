package basic.algorithm.cs61b.lec14.disjointset;

public interface IDisJointSet<T> {

    void connect(T t1, T t2);
    boolean isConnect(T t1, T t2);

}
