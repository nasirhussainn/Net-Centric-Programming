package Qno_2;
import java.util.*;
import java.util.zip.*;
import java.io.*;
public class ZipExtractor {
    public static void main(String[] args) throws Exception{
        ZipFile zipFile = new ZipFile("test.zip");
        // Get a single entry from a zip file
        ZipEntry zipEntry = zipFile.getEntry("nasirZipTest.txt");
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        String temp="";

        int i ;
        while ((i=inputStream.read())!=-1) {
            System.out.print((char) i);
            temp += (char)i;
        }


        byte b[] = temp.getBytes();
        try {
            FileOutputStream fos = new FileOutputStream("nasirZipExt.txt");
            fos.write(b,0,b.length);
            System.out.println("\n\nWritten in File, check it Now!\n");
        } catch(IOException e) {
            System.out.println("Error creating file!");
        }
    }
}
