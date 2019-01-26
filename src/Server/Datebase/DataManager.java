package Server.Datebase;

import Core.Atrakcje;
import Core.Pracownik;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataManager {

    public static void addPracownik(Pracownik pracownik) {
        String sql = ("INSERT INTO Pracownik (id_pracownika,login,imie,pass,nazwisko,id_typ_pracownika)  VALUES ("
                +  "sekwencja_pracownicy.nextval,'"
                + pracownik.getLogin() + "','"
                + pracownik.getImie() + "','"
                + pracownik.getPass() + "','"
                + pracownik.getNazwisko() + "',"
                + pracownik.getIdTyp() + ")"
        );

        DatebaseConnector.execute(sql);
    }

    public static Object getPracownik(int id) {
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

    public static Object getSPracownik(String lancuch) {
        System.out.println(lancuch);

        String[] tekst = null;
        tekst = lancuch.split(" ");

        String sql = "SELECT * FROM Pracownik WHERE login = '" + tekst[0] + "' AND pass = '" + tekst[1] + "'";
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
    public static void addAttraction(Atrakcje attraction) {
        String sql = ("INSERT INTO Atrakcje (id_atrakcji,nazwa_atrakcji,cena_idywidualna,cena_grupowa,data_otwarcia,data_zamkniecia)  VALUES ("
                +  "sekwencja_atrakcje.nextval,'"
                + attraction.getNazwa_atrakcji() + "',"
                + attraction.getCena_idywidualna() + ","
                + attraction.getCena_grupowa() + " ,To_Date('"
                + attraction.getData_otwarcia() + " ','YYYY.MM.DD'),To_Date('"
                + attraction.getData_zamkniecia() + "','YYYY.MM.DD'))"
        );
//(sekwencja_atrakcje.nextval,'Karuzela',10,7,To_Date('2019.06.12','YYYY.MM.DD'),To_Date('2019.10.01','YYYY.MM.DD'));
        DatebaseConnector.execute(sql);
    }

    public static Object getAttraction(int id_atrakcji) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String sql = "SELECT * FROM Atrakcje WHERE id_atrakcji = " + id_atrakcji + "";
        ResultSet result = DatebaseConnector.getResultSet(sql);
        Atrakcje atrakcja = null;
        try {
            result.next();
            atrakcja = new Atrakcje(
                    result.getInt("id_atrakcji"),
                    result.getString("nazwa_atrakcji"),
                    result.getDouble("cena_idywidualna"),
                    result.getDouble("cena_grupowa"),
                    result.getString("data_otwarcia"),
                    result.getString("data_zamkniecia"));
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
        return atrakcja;
    }


}