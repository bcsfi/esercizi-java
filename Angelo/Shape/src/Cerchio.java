public class Cerchio implements Shape{
    private double raggio;
    public Cerchio(double raggio){
        this.raggio = raggio;
    }
    public double calculateArea(){
        return Math.PI * Math.pow(raggio, 2);
    }
    public double calculatePerimeter(){
        return 2 * Math.PI * raggio;
    }
}
