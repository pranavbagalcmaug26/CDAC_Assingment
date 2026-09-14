package Easy_Java_Assignments;

public class Triangle {
    int side1;
    int side2;
    int side3;
    Triangle(int side1,int side2,int side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }
    public static void main(String[] args) {
        Triangle obj=new Triangle(3,4,5);

        System.out.println("Area Of Triangle: "+obj.area());
        System.out.println("Perimeter Of Triangle: "+obj.perimeter());
    }
    public double area(){
       return 0.5*(side2*side1);
    }

    public int perimeter(){
        return side1+side2+side3;
    }
}
