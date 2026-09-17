package Easy_Java_Assingments_String;

public class Question7 {
    public static void main(String[] args) {
        String str1="The quick brown fox jumps";
        System.out.println("The given string is: "+str1);

        System.out.print("The string in reverse order is: ");
        for(int i=str1.length()-1;i>=0;i--){
            System.out.print(str1.charAt(i));
        }
    }
}
