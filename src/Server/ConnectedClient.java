package Server;

import Core.*;
import Core.Client.ServerOperation;
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

    private synchronized void executeOperation(ServerOperation serverOperation, Object object) {
        switch (serverOperation) {
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
                int id = (Integer) object;
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


            case addAttraction:
                Atrakcje atrkacja = (Atrakcje) object;
                DataManager.addAttraction(atrkacja);
                try {
                    objectOutputStream.writeObject("cos");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getAttraction:
                int id_atrakcji = (Integer) object;
                try {
                    objectOutputStream.writeObject(DataManager.getAttraction(id_atrakcji));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case getAttractionToList:
                try {
                    objectOutputStream.writeObject(DataManager.getAttractionToList());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case addRaport:
                Raport raport = (Raport) object;
                DataManager.addRaport(raport);
                try {
                    objectOutputStream.writeObject("cos");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getRaport:
                int idgr = (Integer)object;
                try {
                    objectOutputStream.writeObject(DataManager.getRaport(idgr));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;


            case addPlan:
                Plany plany = (Plany) object;
                DataManager.addPlan(plany);
                try {
                    objectOutputStream.writeObject("cos");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getPlan:
                int typ = (Integer) object;
                try {
                    objectOutputStream.writeObject(DataManager.getPlan(typ));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getUnimplementedRaport:
                 typ = (Integer)object;
                try {
                    objectOutputStream.writeObject(DataManager.getUnimplementedRaport(typ));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getReportRaport:
                int raporcik=(Integer) object;
                try
                {
                    objectOutputStream.writeObject(DataManager.getReportRaport(raporcik));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getTypPracownika:
                int idt = (Integer)object;
                try {
                    objectOutputStream.writeObject(DataManager.getTypPracownika(idt));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case updateStatusRaport:
                int idr = (Integer) object;
                DataManager.updateStatusRaport(idr);
                try {
                    objectOutputStream.writeObject("cos");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case takeRaport:
                int idrap = (Integer) object;
                DataManager.takeRaport(idrap);
                try {
                    objectOutputStream.writeObject("cos");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getTypAwarii:
                id = (Integer)object;
                try {
                    objectOutputStream.writeObject(DataManager.getTypAwarii(id));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getOneDayPlanList:
                id = (Integer)object;
                try {
                    objectOutputStream.writeObject(DataManager.getOneDayPlanList(id));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getWeekPlanList:
                id = (Integer)object;
                try {
                    objectOutputStream.writeObject(DataManager.getWeekPlanList(id));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case getStanowisko:
                id = (Integer) object;
                try {
                    objectOutputStream.writeObject(DataManager.getStanowisko(id));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
