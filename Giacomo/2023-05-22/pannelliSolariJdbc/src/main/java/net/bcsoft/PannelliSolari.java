package net.bcsoft;

import java.io.IOException;
import java.sql.SQLException;

public class PannelliSolari
{
    public static void main(String[] args)
    {

        try
        {
            ReportCreator reportCreator = new ReportCreator((Integer.parseInt(args[0] != null ? args[0] : "4")));
        }
        catch (IOException | ClassNotFoundException | SQLException e)
        {
       System.out.println(e.getMessage());
        }
    }
}