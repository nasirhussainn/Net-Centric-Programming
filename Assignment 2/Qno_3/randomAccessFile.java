package Qno_3;
import java.io.*;

import static Qno_3.Employee.deserializeObject;
import static Qno_3.Employee.serializeObject;

public class randomAccessFile {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("empRAF.dat", "rw");
            Employee employee = new Employee(3, "Kashif Khan", "IT", "Officer");

            byte[] empBytes = serializeObject(employee);
            file.write(empBytes);
            System.out.println("\nWRITING EMP OBJECT IN FILE\nEmployee Object Stored in empRAF.dat File.\n");

            file.seek(0);

            byte[] readBytes = new byte[empBytes.length];
            file.read(readBytes);
            System.out.println("READING EMP OBJECT FROM FILE\nEmployee Object Read from file successfully.\n");
            try {
                Employee readEmp = deserializeObject(readBytes);
                System.out.println(readEmp.toStr());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}