package Assingment2;

public class WaitingList {
    static class Patient{
        String data;
        Patient prev;
        Patient next;

        Patient(String data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    private Patient head;
    private Patient tail;
    private Patient lastEmergency;
    private int size;

    WaitingList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public static void main(String[] args) {
        WaitingList appointment=new WaitingList();
        appointment.addNormal("Riya");
        appointment.addNormal("Sam");
        appointment.addEmergency("Tom");
        appointment.addNormal("Uma");
        appointment.callNext();
        appointment.leave("Sam");
        appointment.addEmergency("Vik");
        appointment.display();
        appointment.displayReverse();
        appointment.waiting();
    }
    public void addEmergency(String data){
        Patient newPatient=new Patient(data);
        if(head==null && tail==null){
            head=newPatient;
            tail=newPatient;
            lastEmergency=newPatient;
        }else if(lastEmergency==null){
            newPatient.next=head;
            head.prev=newPatient;
            head=newPatient;
            lastEmergency=newPatient;
        }else {
            newPatient.next=lastEmergency.next;
            newPatient.prev=lastEmergency;
            if(lastEmergency.next!=null){
                lastEmergency.next.prev=newPatient;
            }else{
                tail=newPatient;
            }
            lastEmergency.next=newPatient;
            lastEmergency=newPatient;
        }
        size++;
    }
    public void addNormal(String data){
        Patient newPatient=new Patient(data);
        if(head==null && tail==null){
            head=newPatient;
            tail=newPatient;
        }else{
            tail.next=newPatient;
            newPatient.prev=tail;
            tail=newPatient;
            tail.next=null;
        }
        size++;
    }
    public void callNext(){
        if(head==null)
            return;

        System.out.println(head.data+" please go the Doctor");
        if(head==lastEmergency){
            lastEmergency=null;
        }
        head=head.next;
        size--;
        if (head==null){
            tail=null;
            lastEmergency=null;
        }else{
            head.prev=null;
        }
    }
    public boolean leave(String data){
        Patient temp=head;
        while (temp!=null){
            if(temp.data.equals(data)){
                if (temp == lastEmergency) {
                    lastEmergency = temp.prev;
                }
                if(temp==head){
                    head=temp.next;
                    if(head!=null){
                        head.prev=null;
                    }
                } else if (temp==tail) {
                    tail=temp.prev;
                    if(tail!=null){
                        tail.next=null;
                    }
                }else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                size--;
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public void display(){
        Patient temp=head;
        System.out.print("List: ");
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void displayReverse(){
        Patient temp=tail;
        System.out.print("Reverse List: ");
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.prev;
        }
        System.out.println();
    }
    public void waiting(){
        System.out.println("Waiting: "+size);
    }
}
