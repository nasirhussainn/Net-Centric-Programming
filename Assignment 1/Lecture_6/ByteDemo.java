package Lecture_6;
import java.io.*;


class ByteDemo {
    public static void main (String []args) {
        try {
            String str = "Testing Byte Array Input Stream.";
            byte[] b = str.getBytes();
            InputStream bais = new ByteArrayInputStream(b,0,b.length);
            int ch;

            while((ch = bais.read()) != -1)
                System.out.print((char) ch);
            System.out.println();
            bais.reset();  //using reset ( ) method and again reading
            ch = 0;
            while((ch = bais.read()) != -1)
                System.out.print((char) ch);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }}}
