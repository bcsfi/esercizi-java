public class Incasso
{
    @Special
    public void primoMetodoConAnnotazione()
    {
        System.out.println("ciao sono GiampierGiorgia");
    }

    public int primoMetodoSenzaAnnotazione()
    {
        System.out.println("ciao ! ciaociao! ciaociaociao!");
        return 47;
    }

    @Special
    public String secodnoMetodoConAnnotazione()
    {
        return "mi stai simpatico! XD";
    }

    public double secondoMetodoSenzaAnnotazione()
    {
        double valore = 0.9;
        System.out.println("aggiungo 2");
        valore = valore + 2;
        return valore;
    }

    @Special
    public boolean terzoMetodoConAnnotazione()
    {
        return ( 2 == 2 );
    }

    public char terzoMetodoSenzaAnnotazione()
    {
        String stringa = "Bartolomeo";
        return stringa.charAt(4);
    }
}
