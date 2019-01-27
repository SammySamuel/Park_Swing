package Core;

import java.io.Serializable;

public class Stanowisko implements Serializable {
    int idS;
    String nazwa;

    public Stanowisko(int idS, String nazwa) {
        this.idS = idS;
        this.nazwa = nazwa;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
