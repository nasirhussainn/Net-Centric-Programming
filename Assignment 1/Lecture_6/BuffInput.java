package Lecture_6;
import java.io.*;
public class BuffInput {
    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream("b.txt"));
        int bytesRead = 0;
        int i=1;
        while ((bytesRead = bi.read(buffer)) != -1)
        {
            String chunk = new String(buffer, 0, bytesRead);
            System.out.println("Chunk No: "+i);
            System.out.println(chunk);
            i++;
        }
        bi.close();
    }
}
