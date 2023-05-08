public class Main {
    public static void main(String[] args)

    {

        Shape rettangoloTest = new Rettangolo("Rettangolo", 5, 5);
        Shape CircleTest = new Circle("Cerchio di giovanni", 4);

        System.out.print("Area del rettangolo" + rettangoloTest.calculateArea() + "\n");
        System.out.print("Area del cerchio" + CircleTest.calculatePerimeter() + "\n");

    }
}