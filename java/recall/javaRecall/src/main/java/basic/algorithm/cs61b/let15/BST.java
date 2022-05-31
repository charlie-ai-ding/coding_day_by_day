package basic.algorithm.cs61b.let15;


class Node{
    private int item;
    private Node left;
    private Node right;

    public Node(int t){
        item =t;
        left =null;
        right=null;
    }
    public int getItem(){
        return item;
    }

    public void setItem(int v){
        item =v;
    }

    public Node getLeft(){
        return  left;
    }
    public Node getRight(){
        return right;
    }
    public void setLeft(Node n){
        left =n;
    }

    public void setRight(Node n){
        right =n;
    }

    public boolean isLeaf(){
        boolean result = false;

        if(left == null && right  == null){
            result = true;
        }
        return result;
    }

    public boolean hasOneChild(){
        boolean result = true;
        if(left != null && right != null){
            result =false;
        }
        if(left == null && right == null){
            result =false;
        }
        return result;
    }

    public Node getOneChild(){
        Node result=null ;
        if(left !=null){
            result = left;
        }
        if(right !=null){
            result = right;
        }
        return result;
    }

    public boolean hasTwoChild(){
        boolean result = false;
        if(left != null && right != null){
            result =true;
        }
        return result;
    }

}
public class BST {

    private Node sentiel;
    private Node root;


    public BST(){
        sentiel = new Node(Integer.MAX_VALUE);
        root = sentiel;
    }

    private void help_print(Node root){
        if(root.getLeft() == null && root.getRight() ==null) {
            System.out.println(root.getItem());
        }else{
            System.out.println(root.getItem());
            if(root.getLeft()!=null){

                help_print(root.getLeft());
            }
            if(root.getRight()!=null){

                help_print(root.getRight());
            }
        }

    }
    public void print(){

        help_print(root);
    }


    public void insert(int t){
        insert_help(root,t);
    }
    private Node insert_help(Node root,int t){

        if(search(root,t)){
            return null;
        }else{
            Node n = new Node(t);
            if(root == null){
                return n;
            }

            if(root.getItem() == Integer.MAX_VALUE){
                root.setItem(t);
                return root;
            }

            if(t>root.getItem()){
              root.setRight(insert_help(root.getRight(),t));

            }
            if(t<root.getItem()){
                root.setLeft(insert_help(root.getLeft(),t));
            }
            return root;
        }
    }

    public boolean search(Node root,int t){
        if(root  ==null){
            return false;
        }
        if(root.getItem() ==Integer.MAX_VALUE){
            return false;
        }

        if (root.getItem() == t){
            return true;
        }
        if(t> root.getItem()){
            return search(root.getRight(),t);
        }
        if(t< root.getItem()){
            return search(root.getLeft(), t);
        }
        return false;
    }


    private Node[] search_node(Node parent, Node root, int t){
        Node[] rs = new Node[2];

        if(root  == null){
            rs[0] =parent;
            rs[1] =null;
            return rs;
        }
        if(root.getItem() ==Integer.MAX_VALUE){
            rs[0] =parent;
            rs[1] =root;
            return rs;
        }

        if (root.getItem() == t){
            rs[0] =parent;
            rs[1] =root;
            return rs;
        }
        if(t> root.getItem()){
            return search_node(root,root.getRight(),t);
        }
        if(t< root.getItem()){
            return search_node(root,root.getLeft(), t);
        }
        return rs;
    }

    private void delete_help(Node root,int n){

    }
    private Node[] leftMaxNode_help(Node parent, Node current){
        Node[] rs = new Node[2];
        if(current.isLeaf()){
            rs[0]=parent;
            rs[1]= current;

        }else if(current.getRight() !=null){
            return leftMaxNode_help(current,current.getRight());
        }

        return rs;
    }


    public void delete(int i){

        Node[] nodes = search_node(sentiel,root,i);
        Node delNode = nodes[1];
        Node parent = nodes[0];

        if(delNode == null){
            System.out.println("this is no item :[" + i +"] in the tree");
        }else{
            if(delNode.isLeaf()){
                parent.setLeft(null);
                parent.setRight(null);
            }else if (delNode.hasOneChild()){
                if(parent.getLeft() == delNode){
                    parent.setLeft(delNode.getOneChild());
                }
                if(parent.getRight() == delNode){
                    parent.setRight(delNode.getOneChild());
                }
            }else if(delNode.hasTwoChild()){
                Node[] rs = leftMaxNode_help(delNode,delNode.getLeft());
                Node two_delNode = rs[1];
                Node two_parent = rs[0];
                delNode.setItem(two_delNode.getItem());
                two_parent.setRight(null);
            }
        }

    }


    public void insert_balance(int[] arr){

        insert_balance_help(arr,0,arr.length);
    }
    private   void insert_balance_help(int[] arr, int start, int end){
        if(start >arr.length-1){
            return;
        }
        if(start<0){
            return;
        }
        if(start >end){
            return;
        }
        if(start == end){
           // System.out.println(arr[start]);
            insert(arr[start]);
        }else{
            int middle = (start +end) /2;
          //  System.out.println(arr[middle]);
            insert(arr[middle]);
            insert_balance_help(arr,start,middle-1);
            insert_balance_help(arr,middle+1,end);
        }
    }

    public static void main(String[] args) {
        test_2();
    }

    public static void test_0() {
        BST bst = new BST();
        int[] arr = new int[]{8,5,14,2,7,11,12,15,17};
        for(int i=0;i<arr.length;i++){
            bst.insert(arr[i]);
        }

        bst.insert(1);
        bst.insert(10);
        System.out.println("begin delete");

        // bst.delete(1);
        System.out.println("deleted 1");
        // bst.delete(2);
        System.out.println("deleted 2");
        bst.delete(8);


        System.out.println("deleted 1,2,8");

        bst.print();
    }

    public static void test_1(){
        BST bst = new BST();
        int[] arr = new int[]{4,2,1,3,6,5,7};
        for(int i=0;i<arr.length;i++){
            bst.insert(arr[i]);
        }

        System.out.println("test_1");
    }

    public static void test_2(){
        BST bst = new BST();
        int []  aa = new int[10000000];
        for(int i=0;i<10000000;i++){
            aa[i]=i+1;
        }
        long begin = System.currentTimeMillis();
        System.out.println(begin);
        bst.insert_balance(aa);

        System.out.println(System.currentTimeMillis());
        long use = System.currentTimeMillis()- begin;

        System.out.println(use);

//        System.out.println(bst);
    }
}
