import javax.swing.text.StyledEditorKit;

public class Mobile implements InterfaceArticolo{

    String name;
    Double price;
    int width, height, depth;

    Mobile(String name, double price, int width, int height, int depth){
        this.name = name;
        this.price = price;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getDepth(){
        return this.depth;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrezzo() {
        return this.price;
    }

    @Override
    public double getPrezzo(double price) {
        return this.price;
    }
}
