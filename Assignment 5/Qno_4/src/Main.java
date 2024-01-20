import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String host = "localhost";
        int startPort = 1;
        int endPort = 65535;

        for (int port = startPort; port <= endPort; port++) {
            Thread thread = new Thread(new PortScanTask(host, port));
            thread.start();
        }
    }
}

class PortScanTask implements Runnable {
    private String host;
    private int port;

    public PortScanTask(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 1000);

            System.out.println("Port " + port + " is open");
            socket.close();
        } catch (IOException e) {
        }
    }
}
