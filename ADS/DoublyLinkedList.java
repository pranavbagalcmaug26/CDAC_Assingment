public class DoublyLinkedList {
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public static void main(String[] args) {
        DoublyLinkedList mylist=new DoublyLinkedList();
        mylist.insertAtHead(40);
        mylist.display();

        mylist.insertAtHead(30);
        mylist.display();

        mylist.insertAtHead(20);
        mylist.display();

        mylist.insertAtHead(10);
        mylist.display();

        System.out.println("Size of Doubly LinkedList: "+mylist.size);
    }
    public void insertAtHead(int data){
        Node newNode=new Node(data);
        if(head==null && tail==null){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            newNode.prev=null;
            head=newNode;
        }
        size++;
    }
    public void insertAtTail(int data){
        Node newNode=new Node(data);
        if(head==null && tail==null){
            head=newNode;
            tail=newNode;
        }
    }
    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print("|"+temp.data+"|<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
