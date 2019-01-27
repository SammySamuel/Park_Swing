package ProjectPatterns.Observer;

public class MechanicObserver implements RaportObserver {

    @Override
    public void update(int typPracownika, int typAwarii) {
        if(typAwarii==2 && typPracownika==5)
        {
            System.out.println("\nYou have reports that require your attention about the type of failure mechanic");
        }
    }
}
