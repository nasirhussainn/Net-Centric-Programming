import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 20008;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to client: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            String reversed = reverseString(clientMessage);

            out.println(reversed);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (Character.isLowerCase(c)) {
                reversed.append(Character.toUpperCase(c));
            } else {
                reversed.append(c);
            }
        }
        return reversed.toString();
    }
}
