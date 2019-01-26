import Core.Atrakcje;
import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;

public class MMain {
    public static void main(String[] args){
        System.out.println("dziadostwo pierdolone i taki chuj jak słonia nos");
        Pracownik pr = new Pracownik(1,"pip@gmail.com","pip","pip","pip",1);
        Client client = new Client("localhost",4821);
        ClientManager clientManager = new ClientManager();


        //Atrakcje atrakcje = new Atrakcje(1,"jak",12,5,"2015.05.06","2020.05.06");
        //ClientManager.clientSender.sendToServer(ServerOperation.addAttraction,atrakcje);

        //Atrakcje atrakcje = (Atrakcje)ClientManager.clientSender.sendToServer(ServerOperation.getAttraction,2);
        //System.out.println(atrakcje.getNazwa_atrakcji());

        int ilosc = (Integer)ClientManager.clientSender.sendToServer(ServerOperation.howManyPracownik,null);
        System.out.println(ilosc);

        //ClientManager.clientSender.sendToServer(ServerOperation.addPracownik,pr);

        //Pracownik pracownik = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getPracownik,2052);
        //System.out.println(pracownik.getImie());
    }
}