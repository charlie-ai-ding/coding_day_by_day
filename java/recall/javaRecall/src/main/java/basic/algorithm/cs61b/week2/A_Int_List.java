package basic.algorithm.cs61b.week2;

public class A_Int_List {

    private int [] elements;

    private int count;
    public A_Int_List(){
        elements = new int[1000];
        count =0;
    }
    public A_Int_List(int capacity){
        elements = new int[capacity];
        count =0;
    }

    public void addLast(int t){
        if(count <= elements.length * 0.8){
            elements[count] = t;
            count+=1;
        }else{
            //extends the container;

            int newLength = elements.length*2;
            int[] newContainer = new int[newLength];

            for(int i=0;i<count-1;i++){
                newContainer[i] = elements[i];
            }
            elements = newContainer;

            elements[count] =1;
            count +=1;
        }
    }

    public int getLast(){
        if(count-1 >=0){
            return elements[count-1];
        }else{
            try {
                throw new Exception("out of the range ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void removeLast(){
        elements[count-1] =0;
        count= count-1;
    }

    public int get(int i){
        if(i<=count-1){
            return elements[i];
        }else{
            try {
                throw new Exception("out of the range");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static  void main(String[] args){
        A_Int_List a_int_list = new A_Int_List();

        a_int_list.addLast(1);
        a_int_list.addLast(2);
        a_int_list.addLast(3);

        a_int_list.removeLast();

        System.out.println(a_int_list.getLast());
        System.out.println(a_int_list.get(0));


    }
}
