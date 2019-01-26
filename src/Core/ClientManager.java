package Core;

import Core.Client.Client;
import Core.Client.ClientSender;

public class ClientManager {
    public static ClientSender clientSender;
    public static Client client;

    public ClientManager() {

        client = new Client("localhost", 4821);
        clientSender = client.getClientServer();
    }
}
