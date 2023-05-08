package net.bcsoft.shapewithinterface;

public class Round implements Shape{
    private String nome;
    private Double raggio;

    public Round(Double raggio, String nome){
        setNome(nome);
        setRaggio(raggio);
    }

    public void setRaggio(Double raggio){
        this.raggio = raggio;
    }
    public void setNome(String nome){this.nome = nome;}

    public Double calculateArea() {
        return (raggio * raggio) * Math.PI;
    }

    public Double calculatePerimeter() {
        return 2 * raggio * Math.PI;
    }

}
