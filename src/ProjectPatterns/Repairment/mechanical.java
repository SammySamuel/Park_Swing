package ProjectPatterns.Repairment;

public class mechanical extends Repair {


    @Override
    void checkUsing() {
        System.out.println(" rozpoczÄ™cie naprawy mechanicznej");
    }

    @Override
    String checkTypeFailure() {
        return "mechanical";
    }

    @Override
    void testRepair() {
        System.out.println("Sprawdzanie naprawy typu mechanical");
    }

    void checkWheels(){
        System.out.println("Sprawdzanie kol");
    }

    void checkDrive(){
        System.out.println("sprawdzanie toru jazdy");
    }

    void checkMechanismRotated(){
        System.out.println("sprawdzanie mechanizmu rotacyjnego");
    }
}
