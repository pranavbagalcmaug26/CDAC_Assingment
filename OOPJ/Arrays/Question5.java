package Arrays;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Size of an Array: ");
        int size=sc.nextInt();

        int []arr=new int[size];

        System.out.print("Enter "+size+" array elements: ");
        for(int i=0;i< arr.length;i++){
            arr[i]= sc.nextInt();
        }

        int []copy=new int[size];
        for(int i=0;i< copy.length;i++){
            copy[i]=arr[i];
        }
        System.out.print("Original Array: [");
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");

        System.out.print("Copy Array: [");
        for(int i=0;i<copy.length;i++){
            System.out.print(copy[i]+" ");
        }
        System.out.println("]");
    }
}
