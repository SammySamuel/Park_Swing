package Core;

import java.io.Serializable;

public class TypPracownika implements Serializable {
    int id;
    String typ;

    public TypPracownika(int id, String typ) {
        this.id = id;
        this.typ = typ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
