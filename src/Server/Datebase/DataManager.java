package Server.Datebase;

import Core.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataManager {

    public static void addPracownik(Pracownik pracownik) {
        String sql = ("INSERT INTO Pracownik (id_pracownika,login,imie,pass,nazwisko,id_typ_pracownika)  VALUES ("
                + "sekwencja_pracownicy.nextval,'"
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

    public static int howManyPracownik() {
        String sql = "SELECT COUNT(*) AS count from PRACOWNIK";
        ResultSet resultSet = DatebaseConnector.getResultSet(sql);
        int ilosc = 0;
        try {
            while (resultSet.next()) {
                ilosc = (resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ilosc;
    }

    public static ArrayList<Pracownik> getPracownikToList() {
        ArrayList<Pracownik> pracownicy = new ArrayList<Pracownik>();
        int number = howManyPracownik();

        String sql = "SELECT * FROM PRACOWNIK";
        ResultSet rs = DatebaseConnector.getResultSet(sql);
        Pracownik pracownik = null;

        for (int i = 0; i < number; i++) {
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
                pracownicy.add(pracownik);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pracownicy;
    }

    public static void removeUserFromBase(String index) {
        String sql = "DELETE FROM PRACOWNIK WHERE LOGIN = '" + index + "'";
        DatebaseConnector.execute(sql);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void addAttraction(Atrakcje attraction) {
        String sql = ("INSERT INTO Atrakcje (id_atrakcji,nazwa_atrakcji,cena_idywidualna,cena_grupowa,data_otwarcia,data_zamkniecia)  VALUES ("
                + "sekwencja_atrakcje.nextval,'"
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

    public static int howManyAttraction() {
        String sql = "SELECT COUNT(*) AS count from ATRAKCJE";
        ResultSet resultSet = DatebaseConnector.getResultSet(sql);
        int ilosc = 0;
        try {
            while (resultSet.next()) {
                ilosc = (resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ilosc;
    }

    public static ArrayList<Atrakcje> getAttractionToList() {
        ArrayList<Atrakcje> atrakcje = new ArrayList<Atrakcje>();
        int number = howManyAttraction();

        String sql = "SELECT * FROM ATRAKCJE";
        ResultSet rs = DatebaseConnector.getResultSet(sql);
        Atrakcje at = null;

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        for (int i = 0; i < number; i++) {
            try {
                rs.next();
                at = new Atrakcje(
                        rs.getInt("id_atrakcji"),
                        rs.getString("nazwa_atrakcji"),
                        rs.getDouble("cena_idywidualna"),
                        rs.getDouble("cena_grupowa"),
                        /*null,
                        null);*/
                        df.format(rs.getDate("data_otwarcia")),
                        df.format(rs.getDate("data_zamkniecia")));
                atrakcje.add(at);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return atrakcje;
    }

    //////////////////////////////////////////////////////////////////

    public static void addRaport(Raport raport) {
        String sql = ("INSERT INTO Raport(id_raport,id_pracownika,id_atrakcji,id_typ_awarii,opis,status) Values(sekwencja_raport.nextval,"
                + raport.getId_pracownika() + ","
                + raport.getId_atrakcji() + ","
                + raport.getId_typ_awarii() + ",'"
                + raport.getOpis() + "','"
                + raport.getStatus() + "')"
        );
        DatebaseConnector.execute(sql);
    }

    public static Object getRaport(int id_raport) {
        String sql = "SELECT * FROM Raport WHERE id_raport = " + id_raport + "";
        ResultSet result = DatebaseConnector.getResultSet(sql);
        Raport raport = null;
        try {
            result.next();
            raport = new Raport(
                    result.getInt("id_raport"),
                    result.getInt("id_pracownika"),
                    result.getInt("id_atrakcji"),
                    result.getInt("id_typ_awarii"),
                    result.getString("opis"),
                    result.getString("status")
            );
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
        return raport;
    }

    public static int howManyRaports() {
        String sql = "SELECT COUNT(*) AS count from RAPORT";
        ResultSet resultSet = DatebaseConnector.getResultSet(sql);
        int ilosc = 0;
        try {
            while (resultSet.next()) {
                ilosc = (resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ilosc;
    }

    public static ArrayList<Raport> getUnimplementedRaport(int typ) {
        ArrayList<Raport> raportArrayList = new ArrayList<Raport>();
        int number = howManyRaports();

        String sql = " SELECT * FROM RAPORT WHERE STATUS = 'przyjety'";
        ResultSet rs = DatebaseConnector.getResultSet(sql);
        Raport r = null;

        for (int i = 0; i < number; i++) {
            try {
                rs.next();
                r = new Raport(
                        rs.getInt("id_raport"),
                        rs.getInt("id_pracownika"),
                        rs.getInt("id_atrakcji"),
                        rs.getInt("id_typ_awarii"),
                        rs.getString("opis"),
                        rs.getString("status")
                );
                raportArrayList.add(r);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return raportArrayList;

    }

    public static ArrayList<Raport> getReportRaport(int typ) {
        ArrayList<Raport> raportArrayList = new ArrayList<Raport>();
        int number = howManyRaports();

        String sql = " SELECT * FROM RAPORT WHERE STATUS = 'zgloszony'";
        ResultSet rs = DatebaseConnector.getResultSet(sql);
        Raport r = null;

        for (int i = 0; i < number; i++) {
            try {
                rs.next();
                r = new Raport(rs.getInt("id_raport"), rs.getInt("id_pracownika"), rs.getInt("id_atrakcji"), rs.getInt("id_typ_awarii"), rs.getString("opis"), rs.getString("status"));
                raportArrayList.add(r);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return raportArrayList;
    }
    public static void updateStatusRaport(int id_raport){
        String sql = "UPDATE RAPORT SET STATUS ='wykonany' WHERE id_raport = " + id_raport + " ";
        ResultSet rs = DatebaseConnector.getResultSet(sql);
    }
    public static void takeRaport(int id_raport)
    {
        String sql = "UPDATE RAPORT SET STATUS ='przyjety' WHERE id_raport = " + id_raport + " ";
        ResultSet rs = DatebaseConnector.getResultSet(sql);
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public static void addPlan(Plany plan) {
        String sql = ("INSERT INTO Plany (id_planu,id_pracownika,id_stanowiska,id_atrakcji,data) VALUES(sekwencja_plany.nextval,"
                + plan.getId_pracownika() + ","
                + plan.getId_stanowiska() + ","
                + plan.getId_atrakcji() + ",To_Date('"
                + plan.getData() + "','YYYY.MM.DD'))"
        );

        DatebaseConnector.execute(sql);
    }

    public static Object getPlan(int id_planu) {
        String sql = "Select *From Plany Where id_planu=" + id_planu + "";
        ResultSet result = DatebaseConnector.getResultSet(sql);
        Plany plan = null;
        try {
            result.next();
            plan = new Plany(
                    result.getInt("id_planu"),
                    result.getInt("id_pracownika"),
                    result.getInt("id_stanowiska"),
                    result.getInt("id_atrakcji"),
                    result.getString("Data")
            );
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

        return plan;
    }


    //////////////////////////////////////////////////////////////////////////////////////////
    public static Object getTypPracownika(int id){
        String sql = "SELECT * FROM TYP_PRACOWNIKA WHERE id_typ_pracownika ="+id + " ";
        ResultSet rs =DatebaseConnector.getResultSet(sql);

        TypPracownika tp = null;
        try {
            rs.next();
            tp = new TypPracownika(
                    rs.getInt("id_typ_pracownika"),
                    rs.getString("typ_pracownika")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tp;
    }
}