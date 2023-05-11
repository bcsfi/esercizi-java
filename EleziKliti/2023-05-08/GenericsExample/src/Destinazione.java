public class Destinazione<Luogo>
{
    private Luogo plc;

    public Destinazione(Luogo luogo){
        plc=luogo;
    }

    public Luogo getLuogo(){
        return plc;
    }

    public String getDescriptiveLuogo(){
        return plc.toString();
    }


}
