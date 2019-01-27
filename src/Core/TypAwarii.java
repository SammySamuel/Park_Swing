package Core;

import java.io.Serializable;

public class TypAwarii implements Serializable {
    int idTypAwarii;
    String nazwa;

    public TypAwarii(int idTypAwarii, String nazwa) {
        this.idTypAwarii = idTypAwarii;
        this.nazwa = nazwa;
    }

    public int getIdTypAwarii() {
        return idTypAwarii;
    }

    public void setIdTypAwarii(int idTypAwarii) {
        this.idTypAwarii = idTypAwarii;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
