public class Rettangolo extends Shape {

    private double width, height;

    Rettangolo(String name, double width, double height){
        super(name);
        this.width = width;
        this.height = height;
    }



    public double calculateArea(){
        return this.width * this.height;
    }
    public double calculatePerimeter(){
        return 2 * (this.width + this.height);
    }
}
