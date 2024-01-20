import java.io.*;
import java.net.*;

public class StudentClient {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int serverPort = 20009;

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String serverQuestion;
            while ((serverQuestion = in.readLine()) != null) {
                System.out.println("Teacher : " + serverQuestion);

                String clientResponse = userInput.readLine();
                out.println(clientResponse);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
