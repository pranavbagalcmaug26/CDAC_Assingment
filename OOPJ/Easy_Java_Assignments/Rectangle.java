package Easy_Java_Assignments;

public class Rectangle {
    int length;
    int breadth;

    Rectangle(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public static void main(String[] args) {
        Rectangle obj1=new Rectangle(4,5);
        Rectangle obj2=new Rectangle(5,8);

        System.out.println("Area of Rectangle1: "+obj1.area());
        System.out.println("Area of Rectangle2: "+obj2.area());
    }
    public int area(){
        return length*breadth;
    }
}
