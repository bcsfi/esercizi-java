public abstract class Shape {

    // Final permette al nome di non essere modificato
    private final String name;

    Shape(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();




}
