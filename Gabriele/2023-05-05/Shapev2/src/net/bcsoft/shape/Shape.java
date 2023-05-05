package net.bcsoft.shape;

public abstract class Shape {
    private String nome;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public abstract Double calculateArea();
    public abstract Double calculatePerimeter();
}
