package Easy_Java_Assignments;

import java.util.Scanner;

public class Complex {
    public static void main(String[] args) {
        Complex obj=new Complex();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter real part Number 1: ");
        int real1=sc.nextInt();

        System.out.print("Enter imaginary part Number 1: ");
        int imaginary1=sc.nextInt();
        System.out.print("Enter real part Number 2: ");
        int real2=sc.nextInt();

        System.out.print("Enter imaginary part Number 2: ");
        int imaginary2=sc.nextInt();
        System.out.println();

        obj.sum(real1,real2,imaginary1,imaginary2);
        obj.Difference(real1,real2,imaginary1,imaginary2);
        obj.Product(real1,real2,imaginary1,imaginary2);
    }
    public void sum(int a,int b,int c,int d){
        int realNo=a+b;
        int imgNo=c+d;
        System.out.println("Sum of Two Complex Number: "+realNo+" + "+imgNo+"i");
    }
    public void Difference(int a,int b,int c,int d){
        int realNo=a-b;
        int imgNo=c-d;
        System.out.println("Difference of Two Complex Number: "+realNo+" + "+imgNo+"i");
    }
    public void Product(int a,int b,int c,int d){
        int realNo=(a*b)-(c*d);
        int imgNo=(a*d)+(c*b);
        System.out.println("Product of Two Complex Number: "+realNo+" + "+imgNo+"i");
    }
}
