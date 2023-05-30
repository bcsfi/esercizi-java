package net.bcsoft.bcbank;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;
import net.bcsoft.bcbank.util.ConnessioneDatabase;
import net.bcsoft.bcbank.util.Query;
import net.bcsoft.bcbank.util.ReportCreator;
import net.bcsoft.bcbank.util.StartProgram;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StartProgram startProgram = new StartProgram();
        startProgram.start();
    }
}