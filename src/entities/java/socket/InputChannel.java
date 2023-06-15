package socket;

import client.ClientSocket;
import structures.Message;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputChannel {

    private final InputStream socketInputStream;

    private final DataInputReader dataInputReader;

    private final ClientSocket socket;


    public InputChannel(ClientSocket socket) {
        this.socket = socket;
        try {
            this.socketInputStream = this.socket.getSocketObject().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.dataInputReader = new DataInputReader(this);
    }

    public String read() {
        ByteList byteList = this.dataInputReader.readAll();
        return new String(byteList.getBytes());
        /*
        try {
            data = this.socketInputStream.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/
        // System.out.println(data);
    }

    public String readAll()
    {
        ByteList byteList = this.dataInputReader.readAll();
        return new String(byteList.getBytes());
    }

    public InputStream getSocketInputStream() {
        return this.socketInputStream;
    }

    public ClientSocket getClientSocket() {
        return socket;
    }
}
