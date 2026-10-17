import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int []arr={6,4,2,8,3,1};
        Selection obj=new Selection();
        System.out.println("Selection Sort: ");
        System.out.println("Before: "+ Arrays.toString(arr));
        obj.SelectionSort(arr);
        System.out.println("After: "+ Arrays.toString(arr));
    }
    public void SelectionSort(int []arr){
        for(int i=0;i< arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]>arr[j])
                    Swap(arr,i,j);
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void Swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}