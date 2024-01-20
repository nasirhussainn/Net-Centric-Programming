import java.io.*;
import java.net.*;

public class TeacherServer {
    public static void main(String[] args) {
        final int PORT = 20009;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to client: " + clientSocket);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                askQuestions(out, in);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void askQuestions(PrintWriter out, BufferedReader in) throws IOException {
        String[] questions = {
                "What are you major subjects?",
                "What is your research interest?",
                "Do you have any publication?"
        };

        for (String question : questions) {
            out.println(question);
            String clientResponse = in.readLine();
            System.out.println("Student Answer: " + clientResponse);
        }
    }
}
