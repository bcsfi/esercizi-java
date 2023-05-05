package net.bcsoft.padreFiglio;

public class Persona {
    private String firstName;
    private String lastName;

    public Persona(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
