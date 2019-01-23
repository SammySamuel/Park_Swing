package Server.Datebase;

import Core.Atrakcje;
import Core.Pracownik;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataManager {

    public static void addPracownik(Pracownik pracownik){
        String sql = ("INSERT INTO Pracownik (id_pracownika,login,imie,pass,nazwisko,id_typ_pracownika)  VALUES ("
                + pracownik.getId()+",'"
                +pracownik.getLogin()+"','"
                +pracownik.getImie()+"','"
                +pracownik.getPass()+"','"
                +pracownik.getNazwisko()+"',"
                +pracownik.getIdTyp()+")"
        );

        DatebaseConnector.execute(sql);
    }

    public static Object getPracownik(int id){
        String sql = "SELECT * FROM Pracownik WHERE id_pracownika = " + id + "";
        ResultSet rs = DatebaseConnector.getResultSet(sql);
        Pracownik pracownik = null;

        try {
            rs.next();
            pracownik = new Pracownik(
                    rs.getInt("ID_PRACOWNIKA"),
                    rs.getString("LOGIN"),
                    rs.getString("IMIE"),
                    rs.getString("PASS"),
                    rs.getString("NAZWISKO"),
                    rs.getInt("ID_TYP_PRACOWNIKA")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pracownik;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void addAttraction(Atrakcje attraction)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String sql = ("INSERT INTO Atrakcje (id_atrakcji,nazwa_atrakcji,data_otwarcia,data_zamkniecia,id_cennika)  VALUES ("
                + attraction.getId_atrakcji()+",'"
                +attraction.getNazwa_atrakcji()+"','"
                +sdf.format(attraction.getData_otwarcia())+"','"
                +sdf.format(attraction.getData_zamkniecia())+"',"
                +attraction.getId_cennika()+")"
        );

        DatebaseConnector.execute(sql);
    }

    public  static  Object getAttraction(int id_atrakcji)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String sql = "SELECT * FROM Atrakcje WHERE id_atrakcji = " + id_atrakcji + "";
        ResultSet result=DatebaseConnector.getResultSet(sql);
        Atrakcje atrakcja = null;
        try
        {
            result.next();
            atrakcja=new Atrakcje(
                    result.getInt("id_atrakcji"),
                    result.getString("nazwa_atrakcji"),
                    sdf.parse(result.getString("data_otwarcia")),
                    sdf.parse(result.getString(" data_zamkniecia")),
                    result.getInt("id_cennika"));
        }catch (SQLException sqlex)
        {
            sqlex.printStackTrace();
        }catch (ParseException pe)
        {
            pe.printStackTrace();
        }
        return atrakcja;
    }


}
