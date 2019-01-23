import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;

import java.util.Date;

public class MMain {
    public static void main(String[] args){
        System.out.println("dziadostwo pierdolone");
        Pracownik pr = new Pracownik(1,"chuj","chuj","chuj","chuj",2);


        Pracownik pracownik = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getPracownik,1);
        System.out.println(pr.getImie());
    }
}