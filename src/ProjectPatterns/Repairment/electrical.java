package ProjectPatterns.Repairment;

public class electrical extends Repair {


    @Override
    void checkUsing() {
        System.out.println(" rozpoczęcie naprawy elektrycznej");
    }

    @Override
    String checkTypeFailure() {
        return "electrical";
    }

    @Override
    void  testRepair() {
        System.out.println("Sprawdzanie naprawy typu electrical");
    }

    boolean checkValtage(){
        System.out.println("napiecie jest zbyt niskie");
        return false;
    }

    void reportToTheElectricitySupplier(){
        System.out.println("awarie zastała zgłoszona do dostawcy prądy");
        System.out.println("awarie pradu naprawiono");
    }

    void checkFuses(){
        System.out.println("sprawdzanie bezpieczników");
    }

    void checkIsolated(){
        System.out.println("sprawdzanie izolacji ochronnej przewodow");
    }


}
