package ProjectPatterns.Repairment;

import java.util.Random;

class unknown extends Repair {

    @Override
    void checkUsing() {
        System.out.println(" rozpoczÄ™cie naprawy ");
    }

    @Override
    String checkTypeFailure() {
        return "unknown";
    }

    @Override
    void testRepair() {
        System.out.println("Sprawdzanie naprawy typu unknown");
    }


    String editTypeFailure(){
        String[] typeAncient = {"electricial", "mechanical", "software"};
        Random rand = new Random();

        int nap = rand.nextInt(3);
        if (nap == 1){
            Repair elect = new electrical();
            elect.startRepair();
        }else{
            if(nap ==2){
                Repair mech = new mechanical();
                mech.startRepair();
            }else{
                if (nap==3){
                    Repair soft = new software();
                    soft.startRepair();
                }
            }
        }

        String ttype=typeAncient[nap] ;
        return ttype;
    }

}