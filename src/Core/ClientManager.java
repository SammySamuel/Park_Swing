package Core;

import Core.Client.Client;
import Core.Client.ClientSender;

public class ClientManager {
    public static ClientSender clientSender;
    public static Client client;

    public ClientManager(){
        System.out.println("68.183.221.215");
        client = new Client("localhost",4810);
        clientSender =client.getClientServer();
    }
}
