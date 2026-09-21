package Assingemnt3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class FileEncryptionDecryption{
    static final int KEY=123;
    static final String FOLDER="C:\\Users\\Tejasshree\\Downloads\\OOPJ\\src\\";

    public static void processFile(String inputFile, String outputFile) {
        System.out.println("Input File: "+inputFile);
        System.out.println("Output File: "+outputFile);
        try (
                FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile)
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                int result = data ^ KEY;
                fos.write(result);
            }
            System.out.println("Operation completed successfully!");
            System.out.println("Output file: " + outputFile);
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== FILE ENCRYPTION & DECRYPTION =====");
            System.out.println("1. Encrypt File");
            System.out.println("2. Decrypt File");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:

                    System.out.print("Enter original file name: ");
                    String originalFile = sc.nextLine().trim();

                    System.out.print("Enter encrypted file name: ");
                    String encryptedFile = sc.nextLine().trim();

                    processFile(
                            FOLDER + originalFile,
                            FOLDER + encryptedFile
                    );
                    break;

                case 2:
                    System.out.print("Enter encrypted file name: ");
                    String encryptedInput = sc.nextLine();
                    System.out.print("Enter decrypted file name: ");
                    String decryptedFile = sc.nextLine();
                    processFile(
                            FOLDER + encryptedInput,
                            FOLDER + decryptedFile
                    );
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
        sc.close();
    }
}