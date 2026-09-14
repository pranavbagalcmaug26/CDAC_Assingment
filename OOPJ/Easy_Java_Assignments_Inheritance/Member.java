package Easy_Java_Assignments_Inheritance;

import java.util.Scanner;

public class Member {
    private String Name;
    private int age;
    private String Phone_Number;
    private String Address;
    private int Salary;

    public void printSalary(){
        System.out.println("Salary: "+Salary);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}

class PrimeMembers extends Member{
    int JoiningYear;
    int JoiningFees;
    String isActive;

    public int getJoiningYear() {
        return JoiningYear;
    }

    public void setJoiningYear(int joiningYear) {
        JoiningYear = joiningYear;
    }

    public int getJoiningFees() {
        return JoiningFees;
    }

    public void setJoiningFees(int joiningFees) {
        JoiningFees = joiningFees;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        PrimeMembers obj=new PrimeMembers();
        System.out.print("Enter Name: ");
        obj.setName(sc.nextLine());

        System.out.print("Enter Age: ");
        obj.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Phone Number: ");
        obj.setPhone_Number(sc.nextLine());

        System.out.print("Enter Address: ");
        obj.setAddress(sc.nextLine());

        System.out.print("Enter Salary: ");
        obj.setSalary(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter JoiningYear: ");
        obj.setJoiningYear(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter JoiningFees: ");
        obj.setJoiningFees(sc.nextInt());
        sc.nextLine();

        System.out.print("Is Active: ");
        obj.setIsActive(sc.nextLine());

        System.out.println("Name\t\tAge\t\tPhone     \t\tAddress\t\tSalary\t\tJoiningYear\t\tJoiningFees\t\tIs Active");
        obj.display();
        obj.printSalary();
    }
    public void display(){
        System.out.println(getName()+"\t\t"+getAge()+"\t\t"+getPhone_Number()+"\t\t"+getAddress()+"\t\t"+getSalary()+"\t\t"
                +getJoiningYear() +"\t\t\t"+getJoiningFees()+"\t\t\t"+getIsActive());
    }
}
