package net.bcsoft.shapewithinterface;

public class Rectangle implements Shape{
    private String nome;
    private Double lunghezza, larghezza;

    public Rectangle(Double lunghezza, Double larghezza, String nome){
        setNome(nome);
        setLarghezza(larghezza);
        setLunghezza(lunghezza);
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setLunghezza(Double lunghezza){
        this.lunghezza = lunghezza;
    }

    public void setLarghezza(Double larghezza){
        this.larghezza = larghezza;
    }

    public Double calculateArea() {
        return lunghezza * larghezza;
    }

    public Double calculatePerimeter() {
        return (lunghezza + larghezza) * 2;
    }
}
