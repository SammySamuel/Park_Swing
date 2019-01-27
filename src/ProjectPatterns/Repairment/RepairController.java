package ProjectPatterns.Repairment;

public class RepairController {
    public String typAncient;

    public  RepairController(String typAncient) {
        this.typAncient = typAncient;
    }

    public void repair() {
        if (typAncient.equals("Mechanik") == true) {
            Repair mechani = new mechanical();
            System.out.println("me");
            mechani.startRepair();

        } else {
            if (typAncient.equals("Elektryk") == true) {
                Repair electr = new electrical();
                electr.startRepair();
            } else {
                if (typAncient.equals("Informatyk") == true) {
                    Repair soft = new software();
                    soft.startRepair();
                } else {
                    Repair unkno = new unknown();
                    unkno.startRepair();

                }
            }
        }

    }

}
