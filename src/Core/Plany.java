package Core;

import java.io.Serializable;

public class Plany implements Serializable {
    int id_planu;
    int id_pracownika;
    int id_stanowiska;
    int id_atrakcji;
    String data;

    public Plany(int id_planu,int id_pracownika, int id_stanowiska, int id_atrakcji, String data)
    {
        this.id_planu=id_planu;
        this.id_pracownika=id_pracownika;
        this.id_stanowiska=id_stanowiska;
        this.id_atrakcji=id_atrakcji;
        this.data=data;
    }

    public int getId_planu() {
        return id_planu;
    }

    public void setId_planu(int id_planu) {
        this.id_planu = id_planu;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    public int getId_atrakcji() {
        return id_atrakcji;
    }

    public void setId_atrakcji(int id_atrakcji) {
        this.id_atrakcji = id_atrakcji;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
