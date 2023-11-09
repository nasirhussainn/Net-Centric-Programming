package Lecture_6;
import java.io.*;
public class AccessCharacter
{
    public static void main(String[] args) throws IOException
    {
        int c;
        RandomAccessFile inFile = new  RandomAccessFile("test.txt","r");
        int pos = 17;
        try
        {
            inFile.seek(pos);
            while( (c = inFile.read())!=-1)
                System.out.print((char)c);
        }
        catch (IOException e)
        { System.out.println();
            inFile.close();
        }
    }
}


