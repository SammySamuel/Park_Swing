package ProjectPatterns.Observer;

public class AllObserver implements RaportObserver {
    @Override
    public void update(int typPracownika,int typAwarii) {
        if((typPracownika==4 || typPracownika==5 || typPracownika==6) && typAwarii==4)
        {
            System.out.println("\nYou have reports that require your attention about the type of failure unknow");
        }
    }
}

