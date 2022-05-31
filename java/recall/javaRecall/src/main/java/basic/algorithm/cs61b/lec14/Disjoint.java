package basic.algorithm.cs61b.lec14;

class Node{
    private int item;
    private Node next;

    public Node(int n){
        item =n;
        next=null;
    }

    public void connect(Node n){
        this.next =n;
    }

    public Node getNext(){
        return next;
    }
    public int getItem(){
        return item;
    }

}

public class Disjoint {

    private Node[] containers;

    public Disjoint(int n){
        containers = new Node[n];

        for(int i=0;i<n;i++){
            containers[i] = new Node(i);
        }

    }
    private Node get(int value){
        for(int i=0;i<containers.length;i++){
            if (containers[i].getItem() == value){
                return containers[i];
            }
        }
        return null;
    }
    public void connect(Node n1,Node n2){
        n1.connect(n2);
        n2.connect(n1);
    }

    public void conncet(int n1,int n2){
        Node nd1 = get(n1);
        Node nd2 = get(n2);

        nd1.connect(nd2);
        nd2.connect(nd1);

    }

    public boolean isConnected(Node n1, Node n2){
        if(n1.getNext() == n2)
            return true;
        else if (n2.getNext()== n1){
            return true;
        }
        while(n1.getNext()!=null){
            if(n1.getNext() ==n2){
                return true;
            }else{
                n1= n1.getNext();
            }
        }

        while(n2.getNext()!=null){
            if(n2.getNext() ==n1){
                return true;
            }else{
                n2= n2.getNext();
            }
        }


        return false;
    }

    public boolean isConnected(int node1, int node2){
        Node n1 = get(node1);
        Node n2 = get(node2);

        if(n1.getNext() == n2)
            return true;
        else if (n2.getNext()== n1){
            return true;
        }
        Node h = n1;
        while(n1.getNext()!=null && n1.getNext() != h){
            if(n1.getNext() ==n2){
                return true;
            }else{
                n1= n1.getNext();
            }
        }

        Node head = n2;
        while(n2.getNext()!=null && n2.getNext() != head){
            if(n2.getNext() ==n1){
                return true;
            }else{
                n2= n2.getNext();
            }
        }


        return false;
    }

    public static void main(String[] args) {
        Disjoint ds = new Disjoint(7);

        ds.conncet(0,1);
        ds.conncet(1,2);
        ds.conncet(0,4);
        ds.conncet(3,5);

        System.out.println(ds.isConnected(2,4));
        System.out.println(ds.isConnected(3,0));

    }
}

