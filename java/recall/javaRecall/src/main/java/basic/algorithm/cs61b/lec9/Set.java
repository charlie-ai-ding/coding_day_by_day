package basic.algorithm.cs61b.lec9;

public interface Set<T> {
    void add(T t);
    boolean contains(T t);
    int size();
}
