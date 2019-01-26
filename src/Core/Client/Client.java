package Core.Client;

import java.io.*;
import java.net.Socket;

public class Client {
    private int port;
    private String ip;

    private ClientSender clientSender;

    public int getPORT() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public ClientSender getClientServer() {
        return clientSender;
    }

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;

        try {
            Socket socket = new Socket(ip, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            clientSender = new ClientSender(objectInputStream, objectOutputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
