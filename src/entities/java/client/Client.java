package client;

import structures.Address;
import structures.MessageSettings;


public class Client {
    private Address serverAddress;

    private ClientSocket socket;

    private MessageSettings messageSettings;

    public Client(MessageSettings messageSettings) {
        this.messageSettings = messageSettings;
    }


    public void connectTo(Address serverAddress) {
        this.serverAddress = serverAddress;
        this.connect();
    }

    private void connect() {
        this.socket = new ClientSocket(this.serverAddress, this.messageSettings);
    }

    public void send()
    {
        this.socket.send(null);
    }

    public void setMessageSettings(MessageSettings messageSettings) {
        this.messageSettings = messageSettings;
        if (this.socket.isConnected())
            this.socket.setMessageSettings(this.messageSettings);
        //TODO: invio al server le nuove impostazioni
    }
}
