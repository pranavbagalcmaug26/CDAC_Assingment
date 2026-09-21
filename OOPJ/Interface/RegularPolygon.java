/*Interfaces
1. Start by making a normal Java-7-style application with these features:
• An interface called RegularPolygon with two abstract methods: getNumSides and getSideLength
 • A class EquilateralTriangle that implements the interface, has getNumSides return 3 and getSideLength return an instance variable that is set by the constructor.
• A class Square that implements the interface, has getNumSides return 4 and getSideLength return an instance variable that is set by the constructor.

2. Add a static totalSides method, that given a RegularPolygon[], returns the sum of the number of sides of all the elements.

3. Add two default methods: • getPerimeter (n * length, where n is the number of sides) • getInteriorAngle ( (n-2)π/n in radians)*/



package Interface;

public interface RegularPolygon {
    public int getNumSides();
    public int getSideLength();

    static int totalSides(RegularPolygon[] polygons) {

        int total = 0;

        for (RegularPolygon polygon : polygons) {
            total += polygon.getNumSides();
        }

        return total;
    }
    default double getPerimeter() {

        return getNumSides() * getSideLength();
    }
    default double getInteriorAngle() {

        int n = getNumSides();

        return (n - 2) * Math.PI / n;
    }
}
class EquilateralTriangle implements RegularPolygon{
    private int sideLength;

    public EquilateralTriangle(int sideLength){
        this.sideLength=sideLength;
    }
    public int getSideLength() {
        return 3;
    }
    public int getNumSides() {
        return sideLength;
    }
}

class Square implements RegularPolygon{
    private int sideLength;

    public Square(int sideLength){
        this.sideLength=sideLength;
    }
    public int getSideLength() {
        return 4;
    }
    public int getNumSides() {
        return sideLength;
    }
}

class main{
    public static void main(String[] args) {
        EquilateralTriangle triangle=new EquilateralTriangle(5);
        Square square=new Square(10);
        RegularPolygon[] polygons = {
                triangle,
                square
        };

        System.out.println("Equilateral Triangle");
        System.out.println("Number of Sides: "+square.getNumSides());
        System.out.println("Side Length: "+square.getSideLength());
        System.out.println("Perimeter: "+triangle.getPerimeter());
        System.out.println("Interior Angle: "+triangle.getInteriorAngle());

        System.out.println();
        System.out.println("Square");
        System.out.println("Number of Sides: "+square.getNumSides());
        System.out.println("Side Length: "+square.getSideLength());
        System.out.println("Perimeter: "+square.getPerimeter());
        System.out.println("Interior Angle: "+square.getInteriorAngle());

        int total = RegularPolygon.totalSides(polygons);

        System.out.println("Total Number of Sides: "
                + total);
    }
}