package network;

import java.io.Serializable;

/**
 * Created by Esi on 6/25/2016.
 */
public class NetworkResponse implements Serializable {
    private Serializable response;

    public NetworkResponse(Serializable response) {
        this.response = response;
    }

    public Serializable getResponse() {
        return response;
    }
}
