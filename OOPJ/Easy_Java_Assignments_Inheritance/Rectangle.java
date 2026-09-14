package Easy_Java_Assignments_Inheritance;

public class Rectangle {
    protected int length;
    protected int breadth;

    public Rectangle(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public void area(){
        int area=length*breadth;
        System.out.println("Area of Rectangle: "+area);
    }
    public void perimeter(){
        int perimeter=2*(length+breadth);
        System.out.println("Area of Rectangle: "+perimeter);
    }
}
class Square extends Rectangle{
    public Square(int side){
        super(side,side);
    }

    public static void main(String[] args) {
        Rectangle r=new Rectangle(10,5);
        r.area();
        r.perimeter();

        Square s=new Square(5);
        s.area();
        s.perimeter();
    }
    public void area(){
        System.out.println("Area of Square: "+(length*breadth));
    }
    public void perimeter(){
        System.out.println("Area of Square: "+(2*(length+breadth)));
    }
}