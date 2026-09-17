package Easy_Java_Assingments_String;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str=sc.nextLine();

        System.out.println("Original String: "+str);
        System.out.println("The character at position 0 is: "+str.charAt(0));
        System.out.println("The character at position 10 is: "+str.charAt(10));
    }
}
