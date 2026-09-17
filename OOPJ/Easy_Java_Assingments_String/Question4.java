package Easy_Java_Assingments_String;

public class Question4 {
    public static void main(String[] args) {
        String str="The quick brown fox jumps over the lazy dog.";
        str=str.toLowerCase();

        for(char ch='a';ch<='z';ch++){
            System.out.print(ch+" ");
        }
        System.out.println();
        System.out.println("======================================================================");
        for(char ch='a';ch<='z';ch++){
            int index=str.indexOf(ch);
            System.out.print(index+" ");
        }
    }
}
