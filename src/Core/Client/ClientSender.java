package Core.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientSender  {
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public ClientSender(ObjectInputStream objectInputStream,ObjectOutputStream objectOutputStream) {
        this.objectInputStream = objectInputStream;
        this.objectOutputStream = objectOutputStream;
    }

    public Object sendToServer(ServerOperation serverOperation,Object object) {

        try {
            objectOutputStream.writeObject(serverOperation.toString());
            objectOutputStream.writeObject(object);

            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
