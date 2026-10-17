import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int []arr={6,4,2,8,3,1};
        Insertion obj=new Insertion();
        System.out.println("Insertion Sort: ");
        System.out.println("Before: "+ Arrays.toString(arr));
        obj.InsertionSort(arr);
        System.out.println("After: "+Arrays.toString(arr));
    }
    public void InsertionSort(int []arr){
        for(int i=1;i< arr.length;i++){
            int prev=i-1;
            int currValue=arr[i];

            while (prev>=0 && currValue<arr[prev]){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=currValue;
        }
    }
}
