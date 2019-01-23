import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;

import java.util.Date;

public class MMain {
    public static void main(String[] args){
        System.out.println("dziadostwo pierdolone");
        Pracownik pr = new Pracownik(1,"chuj","chuj","chuj","chuj",2);
        Client client = new Client("localhost",4810);
        ClientManager clientManager = new ClientManager();
        ClientManager.clientSender.sendToServer(ServerOperation.addPracownik,pr);
        Pracownik pracownik = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getPracownik,2002);
        System.out.println(pracownik.getImie());
    }
}