    public class SinglyLinkedList{
        static class Node{
            int data;
            Node next;

            Node(int data){
                this.data=data;
                this.next=null;
            }
        }
        private Node head;
        private Node tail;
        private int size;

        SinglyLinkedList(){
            this.head=null;
            this.tail=null;
            size=0;
        }

        public static void main(String[] args) {
            SinglyLinkedList mylist=new SinglyLinkedList();
            mylist.insertAtHead(10);
            mylist.display();

            mylist.insertAtHead(20);
            mylist.display();

            mylist.insertAtTail(5);
            mylist.display();

            mylist.insertAtPos(2,15);
            mylist.display();

            mylist.deleteAtHead();
            mylist.display();

            mylist.deleteAtTail();
            mylist.display();

            mylist.deleteAtPos(2);
            mylist.display();

            System.out.println("Size of LinkedList: "+mylist.size);
        }
        public void insertAtHead(int data){
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
        public void insertAtTail(int data){
            Node newNode=new Node(data);
            if(head==null && tail==null){
                head=null;
                tail=null;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
            size++;
        }
        public void insertAtPos(int position,int data){
            Node newNode=new Node(data);
            if(position<1 || position>size+1){
                System.out.println("Insert is not possible");
                return;
            }
            if(position==1){
                insertAtHead(data);
            }
            if(position==size+1){
                insertAtTail(data);
            }

            Node prevNode=head;
            for(int i=1;i<=position-2;i++){
                prevNode=prevNode.next;
            }
            newNode.next=prevNode.next;
            prevNode.next=newNode;

            size++;
        }
        public void deleteAtHead(){
            if(head==null && tail==null){
                System.out.println("No need to delete");
                return;
            }
            head=head.next;
            size--;
        }
        public void deleteAtTail(){
            if(head==null && tail==null){
                System.out.println("No need to delete");
                return;
            }
            if (head == tail) {
                head = null;
                tail = null;
                size--;
                return;
            }
            Node temp=head;
            while (temp.next!=tail){
                temp=temp.next;
            }
            tail=temp;
            tail.next=null;

            size--;
        }
        public void deleteAtPos(int position){
            if(position<1 || position>size){
                System.out.println("Invalid Position");
                return;
            }
            if(position==1){
                deleteAtHead();
                return;
            }
            if(position==size){
                deleteAtHead();
                return;
            }
            Node prevNode=head;
            for(int i=0;i<=position-2;i++){
                prevNode=prevNode.next;
            }
            Node currentNode=prevNode.next;
            Node forward=currentNode.next;

            prevNode.next=forward;
            currentNode.next=null;

            size--;
        }
        public void display(){
            Node temp=head;
            while (temp!=null){
                System.out.print("|"+temp.data+"|->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }