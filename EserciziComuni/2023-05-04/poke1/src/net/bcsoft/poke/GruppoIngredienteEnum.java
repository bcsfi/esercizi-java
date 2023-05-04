package net.bcsoft.poke;

public enum GruppoIngredienteEnum {
    BASE(1),
    TOPPING(3),
    PROTEINA(2),
    MARINATURA(1);

    int quantita;
    GruppoIngredienteEnum(int quantita){
        this.quantita= quantita;
    }

    public static int sommaIngredientiCorretti(){
        int risultato = 0;
        risultato += BASE.quantita;
        risultato += TOPPING.quantita;
        risultato += PROTEINA.quantita;
        risultato += MARINATURA.quantita;

        return risultato;
    }
}