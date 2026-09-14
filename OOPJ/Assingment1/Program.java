package Assingment1;

import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date d=new Date();
        int choice;
        do{
            System.out.println("1. Set Date");
            System.out.println("2. Add Days");
            System.out.println("3. Add Months");
            System.out.println("4. Add Years");
            System.out.println("5. Display Date");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter day: ");
                    int day=sc.nextInt();

                    System.out.print("Enter month: ");
                    int month=sc.nextInt();

                    System.out.print("Enter year: ");
                    int year=sc.nextInt();

                    d.setDate(day,month,year);
                    System.out.println("Date set successfully.");
                    break;

                case 2:
                    System.out.print("Enter number of days to add: ");
                    int days=sc.nextInt();

                    d.addDays(days);
                    System.out.println("Days added successfully.");
                    break;

                case 3:
                    System.out.print("Enter number of months to add: ");
                    int months=sc.nextInt();

                    d.addMonths(months);
                    System.out.println("Months added successfully.");
                    break;

                case 4:
                    System.out.print("Enter number of years to add: ");
                    int years=sc.nextInt();

                    d.addYears(years);
                    System.out.println("Years added successfully.");
                    break;

                case 5:
                    d.display();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice!=6);
    }
}