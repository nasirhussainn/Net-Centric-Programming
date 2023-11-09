import java.io.*;

public class CopyFileTV_ex {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = null;
        FileOutputStream fout = null;
// File fil = new File("a1.txt");
        fin = new FileInputStream("a1.txt");//or: (fil)
        fout = new FileOutputStream("xyz.txt");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fin.read(buffer)) > 0) {
            fout.write(buffer, 0, bytesRead);
        }
        fin.close();
        fout.close();
    }
}