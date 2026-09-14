package Easy_Java_Assignments;

public class Student {
    String name;
    int roll_no;
    String phone_no;
    String address;
    public static void main(String[] args) {
        Student s1=new Student();
        s1.name="Sam";
        s1.roll_no=1;
        s1.phone_no="7977508958";
        s1.address="Navi Mumbai";

        Student s2=new Student();
        s2.name="John";
        s2.roll_no=2;
        s2.phone_no="9137597045";
        s2.address="Navi Mumbai";

        System.out.println("=============Student 1 Details============");
        System.out.println("Name: "+s1.name);
        System.out.println("Roll Number: "+s1.roll_no);
        System.out.println("Phone Number: "+s1.phone_no);
        System.out.println("Address: "+s1.address);

        System.out.println("=============Student 2 Details============");
        System.out.println("Name: "+s2.name);
        System.out.println("Roll Number: "+s2.roll_no);
        System.out.println("Phone Number: "+s2.phone_no);
        System.out.println("Address: "+s2.address);
    }
}
