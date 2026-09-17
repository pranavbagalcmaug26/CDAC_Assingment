package Easy_Java_Assingments_String;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String1: ");
        String str1=sc.nextLine();
        System.out.print("Enter String2: ");
        String str2=sc.nextLine();

        System.out.print("Enter Ending String: ");
        String ending=sc.nextLine();

        boolean result1=str1.endsWith(ending);
        boolean result2=str2.endsWith(ending);

        System.out.println("\""+str1 +"\" ends with \""+ending+"\"? "+result1);
        System.out.println("\""+str2 +"\" ends with \""+ending+"\"? "+result2);
    }
}