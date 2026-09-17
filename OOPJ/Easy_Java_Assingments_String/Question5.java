package Easy_Java_Assingments_String;

public class Question5 {
    public static void main(String[] args) {
        String str1="The quick brown fox jumps over the lazy dog.";
        System.out.println("Original String: "+str1);

        String str2 = str1.replaceAll("fox","cat");
        System.out.println("New String: "+str2);
    }
}
