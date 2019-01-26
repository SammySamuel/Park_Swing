package Server;

import Server.Datebase.DatebaseConnector;

public class MainServer {
    public static void main(String[] args) {
        DatebaseConnector datebaseConnector = null;
        datebaseConnector.connect();

        ServerListener serverListener = new ServerListener();
        System.out.println("Uruchamiam serwer...");

        serverListener.start();

    }
}
