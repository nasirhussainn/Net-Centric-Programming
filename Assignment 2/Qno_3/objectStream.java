package Qno_3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class objectStream {

    public static void main(String[] args) throws Exception {
        Employee emp1 = new Employee(10, "Nasir Hussain", "GDSC", "Lead");

        FileOutputStream fileOutputStream = new FileOutputStream("objectStream.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(emp1);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("\nWRITING EMP OBJECT IN FILE\nEmployee Object Stored in objectStream.txt File.\n");

        FileInputStream fileInputStream = new FileInputStream("objectStream.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Employee> employeeObjects = new ArrayList<>();

        while (true) {
            try {
                Employee empReadObj = (Employee) objectInputStream.readObject();
                employeeObjects.add(empReadObj);
            } catch (EOFException e) {
                break;
            }
        }
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("READING EMP OBJECT FROM FILE\nEmployee Object Read from file successfully.\n");

        for (Employee employeeObject : employeeObjects) {
            System.out.println(employeeObject.toStr());
        }
    }
}
