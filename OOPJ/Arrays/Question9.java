package Arrays;

import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Size of an Array: ");
        int size=sc.nextInt();

        int []arr=new int[size];

        System.out.print("Enter "+size+" array elements: ");
        for(int i=0;i< arr.length;i++){
            arr[i]= sc.nextInt();
        }
        System.out.print("Array elemsnts: [");
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");

        System.out.print("Duplicate values: [");
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j])
                    System.out.print(arr[i]+" ");
            }
        }
        System.out.println("]");
    }
}
