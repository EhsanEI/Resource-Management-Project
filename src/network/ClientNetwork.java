package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Esi on 6/25/2016.
 */

public class ClientNetwork {
    private Socket server;
    private ObjectOutputStream serverOutputStream;
    private ObjectInputStream serverInputStream;


    public ClientNetwork(Socket server) throws IOException {
        this.server = server;
        serverOutputStream = new ObjectOutputStream(server.getOutputStream());
        serverInputStream = new ObjectInputStream(server.getInputStream());
    }


    public NetworkResponse sendRequest(NetworkRequest request) throws IOException, ClassNotFoundException {
        serverOutputStream.writeObject(request);
        return (NetworkResponse) serverInputStream.readObject();
    }
}
