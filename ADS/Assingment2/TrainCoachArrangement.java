package Assingment2;

public class TrainCoachArrangement {
    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    TrainCoachArrangement(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    public static void main(String[] args) {
        TrainCoachArrangement myList=new TrainCoachArrangement();
        myList.attachEngine("ENGINE");
        myList.display();

        myList.attachGEN("GEN");
        myList.display();

        myList.attachBetween(2,"S1");
        myList.display();

        myList.attachBetween(3,"S2");
        myList.display();

        System.out.println("Train Size: "+myList.size);
    }
    public void attachEngine(String data){
        if (contains(data)) {
            System.out.println(data + " already exists");
            return;
        }
        Node newNode=new Node(data);
        if(head==null && tail==null){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        size++;
    }
    public void attachGEN(String data){
        if (contains(data)) {
            System.out.println(data + " already exists");
            return;
        }
        Node newNode=new Node(data);
        if(head==null && tail==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public void attachBetween(int position,String data){
        if (contains(data)) {
            System.out.println(data + " already exists");
            return;
        }
        Node newNode=new Node(data);
        if(position<1 || position>size+1){
            System.out.println("Attachment is Not possible");
            return;
        }
        if(position==1){
            System.out.println("Attachment of Coach is not possible before Engine Coach");
            return;
        }
        if(position==size+1){
            attachGEN(data);
            return;
        }
        Node prevNode=head;
        for(int i=1;i<=position-2;i++){
            prevNode=prevNode.next;
        }
        newNode.next=prevNode.next;
        prevNode.next=newNode;

        size++;
    }
    public boolean contains(String data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
}
