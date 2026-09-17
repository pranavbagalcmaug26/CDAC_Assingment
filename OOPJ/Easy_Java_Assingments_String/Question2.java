package Easy_Java_Assingments_String;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first String: ");
        String str1=sc.nextLine();

        System.out.print("Enter Second String: ");
        String str2=sc.nextLine();

        int result=str1.compareTo(str2);

        System.out.println("String 1: "+str1);
        System.out.println("String 2: "+str2);

        if(result==0)
            System.out.println("\""+str1+"\" is Equal to \""+str2+"\"");
        else if(result<0)
            System.out.println("\""+str1+"\" is less than \""+str2+"\"");
        else
            System.out.println("\""+str1+"\" is greater than \""+str2+"\"");
    }
}
