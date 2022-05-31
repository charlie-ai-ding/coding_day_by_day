package basic.algorithm.cs61b.lec14;

class Point<T>{
    private T item;
    private Point<T> left;
    private Point<T> right;

    public Point(T t){
        item =t;
        left = null;
        right= null;
    }
    public T getItem(){
        return item;
    }

    public Point getLeft(){

        return left;
    }

    public Point getRight(){

        return right;
    }

    public Point leftNext(Point<T> pre){
       Point<T> next = this.getLeft();
       if(next == pre){
           next = this.getRight();
       }
       return next;
    }

    public Point rightNext(Point<T> pre){
        Point<T> next = this.getRight();
        if(next == pre){
            next = this.getLeft();
        }
        return next;
    }

    public void setRight(Point<T> p){

        if(right ==null){
            right =p;
        }else if(left ==null){
            left =p;
        }
    }
    public void setLeft(Point<T> p){
       if(left ==null){
           left =p;
       } else if (right ==null) {
           right =p;
       }
    }

}
public class DisjointSets<T> {
    private Point<T>[] containers;

    public DisjointSets(){
        containers = new Point[10];

    }

    public void of(T... args){
        int i =0;
        for (T t: args){
            containers[i] = new Point<>(t);
            i +=1;
        }
    }

    private Point<T> getPoint(T t){
        for(int i=0;i<containers.length;i++){
            if(containers[i] !=null){
                if (containers[i].getItem().equals(t)){
                    return containers[i];
                }
            }

        }
        return null;
    }

    public void connect(T p1, T p2){

        Point<T> point1 = getPoint(p1);
        Point<T> point2 = getPoint(p2);

        point1.setRight(point2);
        point2.setLeft(point1);

    }

    private boolean isConnectedFromLeft(Point<T> from ,Point to){
        Point<T> head = from;

        while(from.leftNext(head) != null){
            if(from == to){
                return true;
            }
            if(from.leftNext(head) == to){
                return true;
            }else{
                Point<T> temp = from.leftNext(head);
                head = from;
                from  = temp;

            }
        }
        return false;
    }

    private boolean isConnectedFromRight(Point<T> from ,Point to){
        Point<T> head = from;

        while(from.getRight() != null){
            if(from.getRight() == to){
                return true;
            }else{
                from = from.getRight();
            }
        }
        return false;
    }

    public boolean isConnected(T p1, T p2){
        Point<T> point1 = getPoint(p1);
        Point<T> point2 = getPoint(p2);

        if(point1.getRight() == p2){
            return true;
        }
        if(point2.getLeft() == p1){
            return true;
        }
        if(point1.getLeft()!=null && point1.getRight() == null){
            return isConnectedFromLeft(point1,point2);
        }
        if(point1.getRight()!=null && point1.getLeft() ==null){
            return isConnectedFromRight(point1,point2);
        }
        if(point1.getLeft()!=null && point1.getRight()!=null){
            return isConnectedFromLeft(point1,point2) || isConnectedFromRight(point1,point2);
        }
        return false;

    }

    public static void main(String[] args) {

        DisjointSets<Integer> ds = new DisjointSets<>();
        ds.of(0,1,2,3,4,5,6);

        ds.connect(0,1);
        ds.connect(1,2);
        ds.connect(0,4);

        ds.connect(3,5);

//        System.out.println(ds.isConnected(2,4));
//        System.out.println(ds.isConnected(3,0));

        ds.connect(3,6);
        ds.connect(4,6);

        System.out.println(ds.isConnected(2,3));

        System.out.println(ds.isConnected(0,5));

        System.out.println(ds.isConnected(3,0));
    }
}
