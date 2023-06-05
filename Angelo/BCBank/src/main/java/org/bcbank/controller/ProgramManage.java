package org.bcbank;
import org.bcbank.controller.ElaboratoreDati;
import org.bcbank.controller.ElaboratoreElenchi;
import org.bcbank.jdbc.ConnectionProvider;
import org.bcbank.model.Conto;
import org.bcbank.model.Estratto;
import org.bcbank.model.Risultati;
import org.bcbank.model.Transazione;

import java.sql.SQLException;
import java.util.List;

public class ProgramManage {

    List<Risultati> elencoRisultati;

    public ProgramManage(){

        try {

            ConnectionProvider driver = new ConnectionProvider("localhost", "5432", "bc_bank", "postgres", "Astrorep");
            ElaboratoreElenchi elaboratoreElenchi = new ElaboratoreElenchi(driver);

            List<Conto> elencoConti = elaboratoreElenchi.creaElencoConti("SELECT * from elenco_conti");
            List<Transazione> elencoTransazioni = elaboratoreElenchi.creaElencoTransazioni("SELECT * from transazioni");
            List<Estratto> elencoEstratti = elaboratoreElenchi.creaElenecoEstratti("SELECT * from estratto_corrente_mensile");
            driver.closeConnection();

            ElaboratoreDati elaboratoreDati = new ElaboratoreDati(elencoTransazioni, elencoConti, elencoEstratti);

            // ReportWriter.reportWrite("C:\\Users\\bcsoft\\Desktop\\Oggi\\result.txt", elaboratoreDati.creaListaDeiRisultati());

            this.elencoRisultati=elaboratoreDati.creaListaDeiRisultati();

        } catch (ClassNotFoundException ignored){

        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }

    }

    public List<Risultati> getListaRisultati(){
        return this.elencoRisultati;
    }
}