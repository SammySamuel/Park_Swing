package ProjectPatterns.Observer;

import java.util.ArrayList;

public class RaportSubject {
    private ArrayList<RaportObserver> observers= new ArrayList<RaportObserver>();

    int currenttypPracownika;
    int currenttypAwarii;

    public void registerObserver(RaportObserver newObserver)
    {
        observers.add(newObserver);
    }
    public void unregisterObserver(RaportObserver deleteObserver)
    {
        int idexObserver=observers.indexOf(deleteObserver);
        observers.remove(idexObserver);
    }
    public void notifyObserver()
    {
        for(RaportObserver observer: observers)
        {
            observer.update(currenttypPracownika,currenttypAwarii);
        }
    }
    public void reportRaport(int typPracownika, int typAwarii)
    {
        this.currenttypPracownika=typPracownika;
        this.currenttypAwarii=typAwarii;
        notifyObserver();
    }
}
