package basic.algorithm.cs61b.week1;

public class IntList {

    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first =f;
        rest =r;
    }

    private int help_size(IntList list,int count){
        if(list.rest == null){
            return count;
        }else{
            return help_size(list.rest,count+1);
        }
    }
    public int size(){
        return help_size(this,1);
    }

    public int size2(){
        if(this.rest == null){
            return 1;
        }else{
            return 1+ this.rest.size2();
        }
    }

    public int interativesize(){
        int size =0;
        IntList p = this;

        while(p.rest != null){
            size +=1;
            p = p.rest;
        }

        return size+1;
    }

    public int get(int index) throws Exception {

        if(index> this.size() || index < 1 ){
            throw new Exception("out of the range");
        }else {
            int result =this.first;

            int count =1;
            IntList p = this;
            while(p!=null){
                if(count == index){
                    result = p.first;
                    break;
                }else{
                    count+=1;
                    p = p.rest;
                }
            }
            return result;
        }
    }

    private int help_get(IntList p,int count,int index){
        if(count == index){
            return p.first;
        }else{
            return help_get(p.rest,count+1,index);
        }
    }

    public int get2(int index){
        return help_get(this,1,index);
    }

    public static void main(String[] args){
        IntList list = new IntList(1,null);

        list = new IntList(2,list);
        list = new IntList(3,list);
        list = new IntList(4,list);


        System.out.println(list.size());

        System.out.println(list.size2());


        System.out.println(list.interativesize());


        try {
            System.out.println(list.get(2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(list.get2(2));
    }
}
