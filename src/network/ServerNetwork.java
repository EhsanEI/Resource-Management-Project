package network;

import java.net.Socket;

/**
 * Created by Esi on 6/25/2016.
 */
public class ServerNetwork {
    private Socket socket;

    public ServerNetwork(Socket socket) {
        this.socket = socket;
    }

    public void sendResponse(NetworkResponse response) {
        //TODO
    }
}
