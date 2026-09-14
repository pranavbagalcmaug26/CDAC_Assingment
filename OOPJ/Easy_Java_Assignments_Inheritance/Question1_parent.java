package Easy_Java_Assignments_Inheritance;

public class Question1_parent {
    public void parentMethod(){
        System.out.println("This is Parent class");
    }
}
class Question1_child extends Question1_parent{
    public static void main(String[] args) {
        Question1_parent obj1=new Question1_child();
        obj1.parentMethod();

        Question1_child obj2=new Question1_child();
        obj2.childMethod();
        obj2.parentMethod();
    }
    public void childMethod(){
        System.out.println("This is child class");
    }
}
