import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int serverPort = 20008;

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String messageToSend = "Nasir";

            out.println(messageToSend);

            String receivedMessage = in.readLine();
            System.out.println("Received from server: " + receivedMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
