package Arrays;

import java.util.Scanner;

public class ComplexNumber {
    int number1;
    int number2;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

       ComplexNumber []arr=new ComplexNumber[5];
       for(int i=0;i< arr.length;i++){
           arr[i]=new ComplexNumber();
           System.out.println("Enter details for Complex number: "+(i+1));

           System.out.print("Enter Number1: ");
           int n1=sc.nextInt();

           System.out.print("Enter Number2: ");
           int n2=sc.nextInt();

           arr[i].setNumber1(n1);
           arr[i].setNumber2(n2);
       }
        System.out.println();
       for(int i=0;i<5;i++){
           System.out.println("ComplexNumber "+(i+1)+": ");
           System.out.println("Number1: "+arr[i].getNumber1());
           System.out.println("Number2: "+arr[i].getNumber2());
           System.out.println("Result: "+arr[i].computeComplexNumber());
       }

    }

    public int computeComplexNumber(){
        return number1*number2;
    }

}
