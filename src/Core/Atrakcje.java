package Core;

import java.io.Serializable;
import java.sql.Date;

public class Atrakcje implements Serializable {
     int id_atrakcji ;
    String nazwa_atrakcji ;
    Date data_otwarcia ;
    Date data_zamkniecia ;
    int id_cennika ;

    public Atrakcje(int id_atrakcji, String nazwa_atrakcji,Date data_otwarcia,Date data_zamkniecia, int id_cennika)
    {
        this.id_atrakcji=id_atrakcji;
        this.nazwa_atrakcji=nazwa_atrakcji;
        this.data_otwarcia=data_otwarcia;
        this.data_zamkniecia=data_zamkniecia;
        this.id_cennika=id_cennika;
    }

    public int getId_atrakcji() {
        return id_atrakcji;
    }

    public void setId_atrakcji(int id_atrakcji) {
        this.id_atrakcji = id_atrakcji;
    }

    public String getNazwa_atrakcji() {
        return nazwa_atrakcji;
    }

    public void setNazwa_atrakcji(String nazwa_atrakcji) {
        this.nazwa_atrakcji = nazwa_atrakcji;
    }

    public Date getData_otwarcia() {
        return data_otwarcia;
    }

    public void setData_otwarcia(Date data_otwarcia) {
        this.data_otwarcia = data_otwarcia;
    }



    public Date getData_zamkniecia() {
        return data_zamkniecia;
    }

    public void setData_zamkniecia(Date data_zamkniecia) {
        this.data_zamkniecia = data_zamkniecia;
    }
    public int getId_cennika() {
        return id_cennika;
    }

    public void setId_cennika(int id_cennika) {
        this.id_cennika = id_cennika;
    }
}
