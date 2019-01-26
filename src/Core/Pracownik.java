package Core;

import java.io.Serializable;

public class Pracownik implements Serializable {
    int id;
    String login;
    String imie;
    String pass;
    String nazwisko;
    int idTyp;

    public Pracownik(int id, String login, String imie, String pass, String nazwisko, int idTyp) {
        this.id = id;
        this.login = login;
        this.imie = imie;
        this.pass = pass;
        this.nazwisko = nazwisko;
        this.idTyp = idTyp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIdTyp() {
        return idTyp;
    }

    public void setIdTyp(int idTyp) {
        this.idTyp = idTyp;
    }
}
