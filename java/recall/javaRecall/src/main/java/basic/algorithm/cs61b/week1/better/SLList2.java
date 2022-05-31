package basic.algorithm.cs61b.week1.better;

public class SLList2 {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int f, IntNode n){
            item =f;
            next =n;
        }
    }

    private int size;

    private IntNode sentinel;


    public SLList2(){
        sentinel = new IntNode(63,null);
        size =0;
    }

    public SLList2(int x){
        sentinel=new IntNode(63,null);
        sentinel.next = new IntNode(x,null);
        size =1;
    }

    public void addFirst(int x){
        IntNode node = new IntNode(x,null);

        IntNode temp = sentinel;

        node.next = temp.next;
        sentinel = node;

        size +=1;
    }

    public IntNode getFirst(){
        return sentinel.next;
    }

    public void addLast(int x){
        IntNode node = new IntNode(x,null);

        IntNode p = sentinel;
        while(p.next != null){
            p= p.next;
        }
        p.next = node;

        size +=1;
    }

    public int size(){
        return size;
    }

    public static void main(String[]args){
//        SLList sl = new SLList(10);
//
//        sl.addFirst(9);
//
//        sl.addFirst(8);
//
//        sl.addFirst(7);
//
//        System.out.println(sl);
//
//        System.out.println(sl.getFirst());
//
//        sl.addLast(11);
//        sl.addLast(12);
//
//        sl.addFirst(6);
//        System.out.println(sl);
//
//        System.out.println(sl.size());
//
//        System.out.println(sl.size2());
//
//
//        System.out.println(sl.size3());

        SLList sl = new SLList();
        sl.addLast(10);

//        System.out.println(sl.size3());
        sl.addFirst(9);
        sl.addFirst(8);

        System.out.println(sl);
    }



}
