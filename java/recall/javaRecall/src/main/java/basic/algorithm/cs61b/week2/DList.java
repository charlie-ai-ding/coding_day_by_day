package basic.algorithm.cs61b.week2;

public class DList<T> {
    static private class ListNode<T>{
        private T item;
        private ListNode<T> next;
        private ListNode<T> pre;

        public ListNode(T v, ListNode<T> n, ListNode<T> p){
            item =v;
            next= n;
            pre =p;
        }

//        @Override
//        public String toString() {
//            String result ="";
//            if(item != null){
//                result = item.toString();
//            }
//            return result;
//        }
//
//        @Override
//        public int hashCode() {
//            return super.hashCode();
//        }
    }
    private int size;
    private ListNode<T> sentiel;

    public DList(){
        ListNode<T> sentielNode = new ListNode<>(null,null,null);
        sentiel = sentielNode;
        size =0;
    }

    public DList(T t){
        ListNode<T> sentielNode = new ListNode<>(null,null,null);
        sentiel = sentielNode;
        ListNode<T> itemNode = new ListNode<>(t,null,null);
        size +=1;

        sentiel.next =itemNode;
        sentiel.pre = itemNode;

        itemNode.pre =sentiel;
        itemNode.next = sentiel;
    }

    public void addLast(T t){
        ListNode<T> itemNode = new ListNode<>(t,null,null);
        ListNode<T> p = sentiel;

        while(p.next != null && p.next != sentiel){
            p = p.next;
        }

        p.next = itemNode;
        itemNode.pre = p;

        sentiel.pre = itemNode;
        itemNode.next = sentiel;
        size +=1;

    }

    public ListNode<T> getLast(){
        return sentiel.pre;
    }

    public void removeLast(){
        ListNode<T> last = sentiel.pre;
        last.pre.next = sentiel;
        sentiel.pre = last.pre;

    }

    public ListNode<T>get(int i){
        int count =0;

        ListNode<T> p = sentiel;
        ListNode<T> result =null;
        while(p.next !=null && p.next != sentiel){
            count +=1;
            if(count == i){
                result =p.next;
                break;
            }
            p = p.next;
        }

        return result;

    }


//    @Override
//    public String toString() {
//        String result ="";
//        ListNode<T> p = sentiel;
//        while(p.next!=null && p.next != sentiel){
//            if(p.item !=null){
//                result = result +" , "+ p.item.toString();
//            }
//
//            p = p.next;
//        }
//        return result;
//    }

    public static void main(String[] args){
//        DList<Integer> dList = new DList<>();
//
//        dList.addLast(5);
//
//        dList.addLast(10);
//
//        dList.addLast(15);

        DList<String> dList = new DList<>();

        dList.addLast("hello");

        dList.addLast("java");

        dList.addLast("alogrithom");


//      System.out.println(dList);
//
//      ListNode<Integer> last = dList.getLast();
//
//        System.out.println(last);

//        dList.removeLast();


        ListNode<String> curr = dList.get(2);

        System.out.println(dList);


    }


}
