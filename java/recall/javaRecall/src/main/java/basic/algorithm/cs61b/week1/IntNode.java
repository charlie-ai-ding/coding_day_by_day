package basic.algorithm.cs61b.week1;

public class IntNode {
    public int first;
    public IntNode next;

    public IntNode(int f,IntNode n){
        first =f;
        next =n;
    }

    @Override
    public String toString() {
        return Integer.toString(first);
    }
}
