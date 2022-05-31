package basic.algorithm.cs61b.week1.better;



public class SLList {

    /**
     * We can declare IntNode static, since it never uses any of SLList's instance variables or methods
     */
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int f, IntNode n){
            item =f;
            next =n;
        }
    }

    private IntNode first;
    private int count ;

    public SLList(int x){
        first = new IntNode(x,null);
        count  =1 ;
    }

    public SLList(){
        count =0;

        first =null;
    }
    public void addFirst(int x){
       IntNode node = new IntNode(x,null);
       IntNode temp = first;

        node.next = temp;
        first = node;
        this.count +=1;
    }

    public IntNode getFirst(){
        return first;
    }

    /**
     * As a human programmer, you only have so much working memory.
     * You want to restrict the amount of complexity in your life!
     * Simple code is (usually) good code.
     *      Special cases are not 'simple'
     * @param x
     * ----
     * Requires a special case.
     * More complex data structures will have many more special cases(gross!!)
     */
    public void addLast(int x){
        IntNode node = new IntNode(x,null);

        IntNode p = first;

        if(p!=null){
            while(p.next != null){
                p = p.next;
            }
            p.next = node;
        }else{
            first = node;
        }


        this.count +=1;

    }

    public  int size(){
       int count =1;
       IntNode p = first;
       while(p.next !=null){
           count+=1;
           p= p.next;
       }
       return count;
    }

    private int size_help(IntNode node,int count){
        if(node.next ==null){
            return count+1;
        }else{
            return size_help(node.next,count+1);
        }
    }

    public int size2(){
        return size_help(first.next,1);
    }

    public int size3(){
        return count;
    }

    @Override
    public String toString() {
        String s = "";

        IntNode p = first;
        while(p !=null){
            s= s+","+ Integer.toString(p.item);
            p= p.next;
        }

        return s;
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

        System.out.println(sl.size3());
        sl.addFirst(9);
        sl.addFirst(8);

        System.out.println(sl);
    }
}
