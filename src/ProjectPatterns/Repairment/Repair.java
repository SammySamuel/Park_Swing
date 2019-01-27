package ProjectPatterns.Repairment;

public abstract class Repair {
    String type = null;

    abstract void checkUsing();

    abstract String checkTypeFailure();

    abstract void testRepair();

    void turnOfPower() {
        System.out.println("wylaczono zasilanie");
    }

    boolean checkValtage() {
        return true;
    }

    void checkFuses() {
    }

    void checkIsolated() {
    }

    void checkWheels() {
    }

    void checkDrive() {
    }

    void checkMechanismRotated() {
    }

    String editTypeFailure() {
        return null;
    }

    void checkConnectionDB() {
    }

    void checkLogs() {
    }

    void checkSoftwareSettings() {
    }

    void turnOnPower() {
        System.out.println("wlaczono zasilanie");
    }

    private void reportToTheElectricitySupplier() {
    }


    final void startRepair() {
        checkUsing();
        type = checkTypeFailure();
        if(checkValtage() == false){
            reportToTheElectricitySupplier();
        }
        if (type.equals("mechanical") == true || type.equals("unknown") == true) {
            turnOfPower();
        }

        if (type.equals("electrical") == true) {
            if (checkValtage() == false) {
                turnOfPower();

            }
        }

        checkFuses();
        checkIsolated();

        checkWheels();
        checkDrive();
        checkMechanismRotated();

        editTypeFailure();

        checkConnectionDB();
        checkLogs();
        checkSoftwareSettings();

        if (type.equals("electrical") == true || type.equals("mechanical") == true || type.equals("unknown") == true) {
            turnOnPower();
        }

        testRepair();

    }




}
