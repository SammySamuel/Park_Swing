package Server;

import Core.Atrakcje;
import Core.Client.ServerOperation;
import Core.Pracownik;
import Server.Datebase.DataManager;
import Server.Datebase.DatebaseConnector;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class ConnectedClient extends Thread {

    protected Socket socket;
    OutputStream outputStream;
    InputStream inputStream;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public ConnectedClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {


        try {
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            return;
        }

        while (true) {
            try {
                String read = (String) objectInputStream.readObject();
                ServerOperation serverOperation = ServerOperation.valueOf(read);
                if (serverOperation == serverOperation.disconnect) {
                    socket.close();
                    return;
                } else {
                    Object object = objectInputStream.readObject();
                    executeOperation(serverOperation, object);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void executeOperation(ServerOperation serverOperation,Object object){
        switch (serverOperation){
            case addPracownik:
                Pracownik pracownik = (Pracownik) object;
                DataManager.addPracownik(pracownik);

                try {
                    objectOutputStream.writeObject("nic");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getPracownik:
                int id =(Integer) object;
                try {
                    objectOutputStream.writeObject(DataManager.getPracownik(id));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case getSPracownik:
                String login = (String) object;
                System.out.println((String) object);

                try {
                    objectOutputStream.writeObject(DataManager.getSPracownik(login));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case howManyPracownik:
                try {
                    objectOutputStream.writeObject(DataManager.howManyPracownik());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case getPracownikToList:
                Pracownik[] pracownicy = (Pracownik[]) object;

                try {
                    objectOutputStream.writeObject(DataManager.getPracownikToList());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case removeUserFromBase:
                String index = (String) object;

                DataManager.removeUserFromBase(index);
                try {
                    objectOutputStream.writeObject("nic");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;


            case addAttraction :
                Atrakcje atrkacja= (Atrakcje) object;
                DataManager.addAttraction(atrkacja);
                try
                {
                    objectOutputStream.writeObject("cos");
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case getAttraction:
                int id_atrakcji= (Integer) object;
                try
                {
                    objectOutputStream.writeObject(DataManager.getAttraction(id_atrakcji));
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;

        }
    }

}
