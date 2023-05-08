package net.bcsoft.poke;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Ingrediente insalata = new Ingrediente("Insalata", "valeriana fresca Toscana", GruppoIngredienteEnum.BASE);
        Ingrediente risoSushi = new Ingrediente("Riso sushi", "riso bianco", GruppoIngredienteEnum.BASE);
        Ingrediente risoVenere = new Ingrediente("Riso venere", "Riso km0", GruppoIngredienteEnum.BASE);
        Ingrediente risoIntegrale = new Ingrediente("Riso integrale", "Riso integrale", GruppoIngredienteEnum.BASE);
        Ingrediente salmone = new Ingrediente("Salmone ", "Salmone di provenienza norvegese", GruppoIngredienteEnum.PROTEINA);
        Ingrediente tonno = new Ingrediente("Tonno", "Provenienza svedese", GruppoIngredienteEnum.PROTEINA);
        Ingrediente gamberetto = new Ingrediente("Gamberetto", "Provenienza Arno", GruppoIngredienteEnum.PROTEINA);
        Ingrediente pollo = new Ingrediente("Pollo", "Provenienza colline Toscane", GruppoIngredienteEnum.PROTEINA);
        Ingrediente tartareSalmone = new Ingrediente("Tartare di salmone", "Provenienza svedese", GruppoIngredienteEnum.PROTEINA);
        Ingrediente mandorle = new Ingrediente("Mandorle", "Bio", GruppoIngredienteEnum.TOPPING);
        Ingrediente cipollaFritta = new Ingrediente("Cipolla fritta", "Cipolla rossa", GruppoIngredienteEnum.TOPPING);
        Ingrediente noci = new Ingrediente("Noci", "Bio", GruppoIngredienteEnum.TOPPING);
        Ingrediente alghe = new Ingrediente("Alghe nori", "provenienza Giappone", GruppoIngredienteEnum.TOPPING);
        Ingrediente baccheGoji = new Ingrediente("Bacche di goji", "provenienza Giappone", GruppoIngredienteEnum.TOPPING);
        Ingrediente teryaki = new Ingrediente("Salsa Teryaki", "Salsa fatta in casa", GruppoIngredienteEnum.MARINATURA);
        Ingrediente soia = new Ingrediente("Salsa Soia", "Salsa fatta in casa", GruppoIngredienteEnum.MARINATURA);
        Ingrediente yogurt = new Ingrediente("Salsa yogurt", "Salsa fatta in casa", GruppoIngredienteEnum.MARINATURA);
        Ingrediente ponzu = new Ingrediente("Salsa Ponzu", "Salsa fatta in casa", GruppoIngredienteEnum.MARINATURA);

        Ingrediente[] listaIngredienti = {
                risoSushi, mandorle, cipollaFritta, noci, teryaki, tartareSalmone, salmone
        };
        verificaPoke(listaIngredienti);


    }

    public static int contaElementi(Ingrediente[] listaIngredienti, GruppoIngredienteEnum checkEnum) {
        int res = 0;

        for (int i = 0; i < listaIngredienti.length; i++) {
            if (listaIngredienti[i].getGruppoIngrediente().name() == checkEnum.name()) {
                res++;
            }

        }
        return res;
    }

    private static void verificaPoke(Ingrediente[] listaIngredienti) {
        if (listaIngredienti.length != GruppoIngredienteEnum.sommaIngredientiCorretti()) {
            System.out.println("il numero totale di ingredienti indica un poke sbagliato");
        } else {
            int baseQ = 0, toppingQ = 0, proteinaQ = 0, marinaturaQ = 0;
            boolean poke = true;
            if (contaElementi(listaIngredienti, GruppoIngredienteEnum.BASE) != GruppoIngredienteEnum.BASE.quantita) {
                baseQ = GruppoIngredienteEnum.BASE.quantita - contaElementi(listaIngredienti, GruppoIngredienteEnum.BASE);
                poke = false;
            }
            if (contaElementi(listaIngredienti, GruppoIngredienteEnum.TOPPING) != GruppoIngredienteEnum.TOPPING.quantita) {
                toppingQ = GruppoIngredienteEnum.TOPPING.quantita - contaElementi(listaIngredienti, GruppoIngredienteEnum.TOPPING);
                poke = false;
            }
            if (contaElementi(listaIngredienti, GruppoIngredienteEnum.PROTEINA) != GruppoIngredienteEnum.PROTEINA.quantita) {
                proteinaQ = GruppoIngredienteEnum.PROTEINA.quantita - contaElementi(listaIngredienti, GruppoIngredienteEnum.PROTEINA);
                poke = false;
            }
            if (contaElementi(listaIngredienti, GruppoIngredienteEnum.MARINATURA) != GruppoIngredienteEnum.MARINATURA.quantita) {
                marinaturaQ = GruppoIngredienteEnum.MARINATURA.quantita - contaElementi(listaIngredienti, GruppoIngredienteEnum.MARINATURA);
                poke = false;
            }
            if (poke == false) {
                System.out.print("la tua poke è incompleta: \n - Base: "+ baseQ + "\n - Topping: " + toppingQ + "\n - Proteina: " + proteinaQ + "\n - Marinatura: " + marinaturaQ);
            } else {
                System.out.print("poke corretta !");
            }
        }
    }
}


