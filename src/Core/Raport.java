package Core;

import java.io.Serializable;

public class Raport implements Serializable {
    int id_raport;
    int id_pracownika;
    int id_atrakcji;
    int id_typ_awarii;
    String opis;
    String status;

    public Raport(int id_raport, int id_pracownika, int id_atrakcji, int id_typ_awarii, String opis, String status)
    {
        this.id_raport=id_raport;
        this.id_pracownika=id_pracownika;
        this.id_atrakcji=id_atrakcji;
        this.id_typ_awarii=id_typ_awarii;
        this.opis=opis;
        this.status=status;
    }

    public int getId_raport() {
        return id_raport;
    }

    public void setId_raport(int id_raport) {
        this.id_raport = id_raport;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_atrakcji() {
        return id_atrakcji;
    }

    public int getId_typ_awarii() {
        return id_typ_awarii;
    }

    public void setId_typ_awarii(int id_typ_awarii) {
        this.id_typ_awarii = id_typ_awarii;
    }

    public void setId_atrakcji(int id_atrakcji) {
        this.id_atrakcji = id_atrakcji;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
