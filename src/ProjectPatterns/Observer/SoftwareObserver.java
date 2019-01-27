package ProjectPatterns.Observer;

public class SoftwareObserver implements RaportObserver {
    @Override
    public void update(int typPracownika,int typAwarii) {
        if(typAwarii==3 && typPracownika==6)
        {
            System.out.println("\nYou have reports that require your attention about the type of failure software");
        }
    }
}
