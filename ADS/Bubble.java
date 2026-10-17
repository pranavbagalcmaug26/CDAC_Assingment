import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int []arr={6,4,2,8,3,1};
        Bubble obj=new Bubble();
        System.out.println("Bubble Sort: ");
        System.out.println("Before: "+ Arrays.toString(arr));
        obj.BubbleSort(arr);
        System.out.println("After: "+ Arrays.toString(arr));
    }
    public void BubbleSort(int []arr){
        for(int i=0;i<arr.length-1;i++){
            boolean swapFlag=false;
            for(int j=0;j< arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    Swap(arr,j,j+1);
                    swapFlag=true;
                }
            }
            if(!swapFlag)
                break;
        }
    }
    public static void Swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
