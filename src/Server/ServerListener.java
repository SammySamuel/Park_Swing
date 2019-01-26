package Server;

import Server.Datebase.DatebaseConnector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {
    static final int PORT = 4821;

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DatebaseConnector datebaseConnector = new DatebaseConnector();

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println("Oczekuje");
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            new ConnectedClient(socket).start();
        }
    }
}
