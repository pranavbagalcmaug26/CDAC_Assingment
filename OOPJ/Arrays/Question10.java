package Arrays;

import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Size of an Array1: ");
        int size1=sc.nextInt();
        int []arr1=new int[size1];


        System.out.print("Enter Size of an Array2: ");
        int size2=sc.nextInt();
        int []arr2=new int[size2];

        System.out.print("Enter "+size1+" array elements of Array1: ");
        for(int i=0;i< arr1.length;i++){
            arr1[i]= sc.nextInt();
        }

        System.out.print("Enter "+size1+" array elements of Array2: ");
        for(int i=0;i< arr2.length;i++){
            arr2[i]= sc.nextInt();
        }
        System.out.print("Array 1 elements: [");
        for(int i=0;i< arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println("]");

        System.out.print("Array 2 elements: [");
        for(int i=0;i< arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println("]");

        System.out.print("Common Array elements from Array1 & Array2: [");
        for(int i=0;i< arr1.length;i++){
            for(int j=0;j< arr2.length;j++){
                if(arr1[i]==arr2[j])
                    System.out.print(arr1[i]+" ");
            }
        }
        System.out.println("]");
    }
}
