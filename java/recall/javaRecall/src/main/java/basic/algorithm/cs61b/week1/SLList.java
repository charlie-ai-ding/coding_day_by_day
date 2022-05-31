package basic.algorithm.cs61b.week1;

public class SLList {
    public IntNode first;

    public SLList(int x){
        first = new IntNode(x,null);
    }

    public void addFirst(int x){
        IntNode node = new IntNode(x,null);
        IntNode temp = first;

        node.next = temp;
        first = node;
    }

    public IntNode getFirst(){
        return first;
    }

    @Override
    public String toString() {
        String s = "";

        IntNode p = first;
        while(p !=null){
            s= s+","+ Integer.toString(p.first);
            p= p.next;
        }

        return s;
    }

    public static void main(String[]args){
        SLList sl = new SLList(10);

        sl.addFirst(9);

        sl.addFirst(8);

        sl.addFirst(7);

        System.out.println(sl);

        System.out.println(sl.getFirst());
    }
}
