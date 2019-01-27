package ProjectPatterns.Repairment;

public class software extends Repair {

    @Override
    void checkUsing() {
        System.out.println(" rozpoczÄ™cie naprawy softwerowej");
    }

    @Override
    String checkTypeFailure() {
        return "software";
    }

    @Override
    void  testRepair() {
        System.out.println("Sprawdzanie naprawy typu software");
    }

    void checkConnectionDB(){
        System.out.println("Sprawdzanie poprawnosci polaczenia z baza danych");
    }

    void checkLogs(){
        System.out.println("Sprawdzanie poprawnosci logow");
    }

    void checkSoftwareSettings(){
        System.out.println("Sprawdzanie poprawnosci ustawien");
    }
}
