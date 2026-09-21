package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Question1 {
    public static void main(String[] args) {
        //1. Write a Java program to create a new array list, add some colors (string) and print out the collection.
        ArrayList<String> colours=new ArrayList<String>();
        colours.add("Violet");
        colours.add("Indigo");
        colours.add("Blue");
        colours.add("Green");
        colours.add("Yellow");
        colours.add("Orange");
        colours.add("Red");
        System.out.println("1."+colours);

        //2. Modify the above Java program to insert an element into the array list at the first position.
        colours.add(0,"purple");
        System.out.println("2."+colours);

        //3. Modify the above Java program to retrieve an element (at a specified index) from a given array list.
        System.out.println("3. Element at Index 2: "+colours.get(2));

        //4. Modify the above Java program to update specific array element by given element.
        colours.set(2,"pink");
        System.out.println("4. Updated Colours: "+colours);

        //5. Modify the above Java program to remove the third element from a array list.
        colours.remove(2);
        System.out.println("5."+colours);

        // 6. Search an element in an ArrayList
        if (colours.contains("Blue"))
            System.out.println("6. Blue is present in the list");
        else
            System.out.println("6. Blue is not present in the list");

        //7. Modify the above Java program to sort a given array list. (Hint : Use the class Collections)
        Collections.sort(colours);
        System.out.println("7. Sorted ArrayList: "+colours);

        //8. Modify the above Java program to copy one array list into another. (Hint : Use the class Collections)
        ArrayList<String> copiedArray=new ArrayList<String>();
        for(int i=0;i<colours.size();i++){
            copiedArray.add("");
        }
        Collections.copy(copiedArray,colours);
        System.out.println("8. Original Array: "+colours);
        System.out.println("8. Copied Array: "+copiedArray);

        //9. Modify the above Java program to shuffle elements in a array list. (Hint : Use the class Collections)
        Collections.shuffle(colours);
        System.out.println("9. Shuffled Array: "+colours);

        //10. Modify the above Java program to reverse elements in a array list. (Hint : Use the class Collections)
        Collections.reverse(colours);
        System.out.println("10. Reversed Array: "+colours);

        //11. Write a Java program to create a new tree set, add some colors (string) and print out the tree set.
        TreeSet<String> coloursTree = new TreeSet<String>();

        coloursTree.add("Violet");
        coloursTree.add("Indigo");
        coloursTree.add("Blue");
        coloursTree.add("Green");
        coloursTree.add("Yellow");
        coloursTree.add("Orange");
        coloursTree.add("Red");

        System.out.println("11. TreeSet: " + coloursTree);

        //12. Modify the above Java program to add all the elements of a specified tree set to another tree set.
        TreeSet<String> colours1 = new TreeSet<String>();

        colours1.add("Red");
        colours1.add("Blue");
        colours1.add("Green");

        TreeSet<String> colours2 = new TreeSet<String>();
        colours2.add("Yellow");
        colours2.add("Orange");
        colours2.add("Violet");
        colours2.addAll(colours1);

        System.out.println("12. TreeSet 1: " + colours1);
        System.out.println("12. TreeSet 2: " + colours2);

        //13. Modify the above Java program to create a reverse order view of the elements contained in a given tree set.
        System.out.println("13. Original TreeSet: " + colours2);
        TreeSet<String> reverseColours = (TreeSet<String>) colours2.descendingSet();
        System.out.println("13. Reverse TreeSet: " + reverseColours);

        //14. Modify the above Java program to get the first and last elements in a tree set.
        System.out.println("14. First Element: "+ reverseColours.first());
        System.out.println("14. Last Element: "+ reverseColours.last());

        //15. Write a Java program to get the element in a tree set which is greater than or equal to the given element.
        // (Hint : Use the ceiling method of the TreeSet)

        TreeSet<Integer> numbers = new TreeSet<Integer>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        int givenElement = 25;
        Integer result=numbers.ceiling(givenElement);
        System.out.println("15. TreeSet: "+numbers);
        System.out.println("15. Given Element: "+givenElement);
        System.out.println("15. Ceiling Element: "+result);
    }
}
