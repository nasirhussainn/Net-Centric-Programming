package Lecture_6;
import java.io.*;
public class RandomAccess {
    public static void main(String args[]) throws IOException
    {
        RandomAccessFile myfile = new RandomAccessFile("rand.dat", "rw");
        myfile.writeInt(120);
        myfile.writeDouble(375.50);
        myfile.writeInt('A'+1);
        myfile.writeBoolean(true);
        myfile.writeChar('X');
    }
}
