public  class Circle extends Shape {


    private double pG = 3.14;
    private double raggio;

    Circle(String name, double raggio){
        super(name);
        this.raggio = raggio;
    }

    public double calculateArea(){
        return pG * (raggio * raggio);
    }
    public double calculatePerimeter(){
        return 2 * this.pG * this.raggio;
    }

}
