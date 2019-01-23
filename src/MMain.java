import Core.Atrakcje;
import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;

import java.util.Date;

public class MMain {
    public static void main(String[] args){
        System.out.println("dziadostwo pierdolone i taki chuj jak słonia nos");
        Pracownik pr = new Pracownik(1,"pip@gmail.com","pip","pip","pip",1);
        Client client = new Client("localhost",4821);
        ClientManager clientManager = new ClientManager();

        ClientManager.clientSender.sendToServer(ServerOperation.addPracownik,pr);

        Pracownik pracownik = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getPracownik,2052);
        System.out.println(pracownik.getImie());
    }
}