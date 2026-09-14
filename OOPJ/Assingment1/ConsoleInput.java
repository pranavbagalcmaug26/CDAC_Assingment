package Assingment1;

public class ConsoleInput {

    public static float getFloat() {
        String objString=getString();
        float data = Float.parseFloat(objString);
        return data;
    }
    public static int getInt() {
        return Integer.parseInt(getString());
    }
    public static String getString() {
        try {
            byte arrInput[] = new byte[100]; // heap arr of 100 size

            int length = System.in.read(arrInput);   //length stores the length,elements in array

            byte [] arrFinal = new byte[length -2];   //last 2 are \n and \r there we change it

            System.arraycopy(arrInput, 0, arrFinal, 0,length-2); //copies data from 1 array to another
            String objString = new String(arrFinal);

            return objString;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }

}
