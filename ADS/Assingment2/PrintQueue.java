package Assingment2;

public class PrintQueue{
    static Node front;
    static Node rear;
    static int size;

    public void enqueue(Job job){
        Node newNode=new Node(job);
        if(isEmpty()){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
        size++;
    }
    public void dequeue(){
        if(isEmpty()){
            return;
        }else{
            front=front.next;
        }
        size--;
        if(front==null)
            rear=null;
    }
    public boolean cancel(String id){
        if(isEmpty()){
            return false;
        }
        if(front.job.id.equals(id)){
            front=front.next;
            size--;

            if(front==null){
                rear=null;
            }
            return true;
        }
        Node current=front;
        while (current.next!=null){
            if(current.next.job.id.equals(id)){
                current.next=current.next.next;

                if(current.next==null){
                    rear=current;
                }
                size--;
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public void printSchedule(){
        int time =0;
        Node temp=front;
        while (temp!=null){
            time=time+temp.job.pages*6;
            System.out.println(temp.job.id+" finishes at "+time+" s");
            temp=temp.next;
        }
    }
    public static boolean isEmpty(){
        return rear==null;
    }

    public static void main(String[] args) {
        PrintQueue queue=new PrintQueue();
        Job J1=new Job("J1","Ravi",25);
        Job J2=new Job("J2","Asha",10);
        Job J3=new Job("J3","Karan",5);

        queue.enqueue(J1);
        queue.enqueue(J2);
        queue.enqueue(J3);

        System.out.println("Schedule Without Cancellation: ");
        queue.printSchedule();

        System.out.println();
        queue.cancel("J2");
        System.out.println();
        System.out.println("Schedule With Cancellation: ");
        queue.printSchedule();

    }
}
class Job{
    String id;
    String owner;
    int pages;

    Job(String id,String owner,int pages){
        this.id=id;
        this.owner=owner;
        this.pages=pages;
    }
}
class Node{
    Job job;
    Node next;

    Node(Job job){
        this.job=job;
        this.next=null;
    }
}