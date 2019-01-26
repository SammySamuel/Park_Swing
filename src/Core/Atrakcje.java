package Core;

import java.io.Serializable;
import java.util.Date;

public class Atrakcje implements Serializable {
     int id_atrakcji ;
    String nazwa_atrakcji ;
    double cena_idywidualna;
    double cena_grupowa;
    Date data_otwarcia ;
    Date data_zamkniecia ;


    public Atrakcje(int id_atrakcji, String nazwa_atrakcji,double cena_idywidualna,double cena_grupowa,Date data_otwarcia,Date data_zamkniecia)
    {
        this.id_atrakcji=id_atrakcji;
        this.nazwa_atrakcji=nazwa_atrakcji;
        this.cena_idywidualna=cena_idywidualna;
        this.cena_grupowa=cena_grupowa;
        this.data_otwarcia=data_otwarcia;
        this.data_zamkniecia=data_zamkniecia;
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

    public double getCena_idywidualna() {
        return cena_idywidualna;
    }

    public void setCena_idywidualna(double cena_idywidualna) {
        this.cena_idywidualna = cena_idywidualna;
    }

    public double getCena_grupowa() {
        return cena_grupowa;
    }

    public void setCena_grupowa(double cena_grupowa) {
        this.cena_grupowa = cena_grupowa;
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

}
