package network;

import java.net.Socket;

/**
 * Created by Esi on 6/25/2016.
 */
public class ClientNetwork {
    private Socket socket;

    public ClientNetwork(Socket socket) {
        this.socket = socket;
    }

    public void sendRequest(NetworkRequest request) {
        //TODO
    }
}
