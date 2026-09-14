package Easy_Java_Assignments;

import java.util.Scanner;

public class Employee {
    String name;
    String YearOfJoining;
    int Salary;
    String address;
    int no_of_hrs_work;

    public static void main(String[] args) {
        Employee e1=new Employee();
        Employee e2=new Employee();
        Employee e3=new Employee();

        System.out.println("Enter Employee 1 Details: ");
        e1.empDetails();

        System.out.println("Enter Employee 2 Details: ");
        e2.empDetails();

        System.out.println("Enter Employee 3 Details: ");
        e3.empDetails();

        System.out.println("========Employee Details Table=========");
        System.out.println("Name\t\tYear of Joining\t\tSalary\t\tAddress");
        e1.display();
        e2.display();
        e3.display();

        System.out.println();

        System.out.println("Salary\t\tNumber of hrs work per day");
        e1.getInfo(e1.Salary,e1.no_of_hrs_work);
        e2.getInfo(e2.Salary,e2.no_of_hrs_work);
        e3.getInfo(e3.Salary,e3.no_of_hrs_work);

        System.out.println("Name\t\tNumber of hrs work per day\t\tSalary");
        System.out.println(e1.name+"\t\t"+e1.no_of_hrs_work+"\t\t\t\t\t\t\t\t\t"+e1.addWork(e1.no_of_hrs_work));
        System.out.println(e2.name+"\t\t"+e2.no_of_hrs_work+"\t\t\t\t\t\t\t\t\t"+e2.addWork(e2.no_of_hrs_work));
        System.out.println(e3.name+"\t\t"+e3.no_of_hrs_work+"\t\t\t\t\t\t\t\t\t"+e3.addWork(e1.no_of_hrs_work));

    }
    public void empDetails(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Name: ");
        name= sc.nextLine();

        System.out.print("Enter Year of Joining: ");
        YearOfJoining=sc.nextLine();

        System.out.print("Enter Sal: ");
        Salary=addSal(sc.nextInt());

        sc.nextLine();

        System.out.print("Enter Address: ");
        address=sc.nextLine();

        System.out.print("Enter Number of hrs work per day: ");
        no_of_hrs_work=sc.nextInt();
    }
    public void display(){
        System.out.println(name+"\t\t"+YearOfJoining+"\t\t\t\t"+Salary+"\t\t\t\t"+address);
    }
    public void getInfo(int salary,int no_of_hrs_work){
        System.out.println(salary+"\t\t\t\t"+no_of_hrs_work);
    }
    public int addSal(int Salary){
        int add=0;
        if(Salary<500)
            add=Salary+10;
        else
            add=Salary;
        return add;
    }
    public int addWork(int no_of_hrs_work){
        int add=0;
        if(no_of_hrs_work>6)
            add=Salary+5;
        else
            add=Salary;
        return add;
    }
}
