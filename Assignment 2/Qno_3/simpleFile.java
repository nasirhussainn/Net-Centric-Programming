package Qno_3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class simpleFile {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee(2,"Sajjad Ali","Software Engineering","Project Manager");

        String empStr = employee.toStr();

        FileWriter fw = new FileWriter("employeeSimpleFile.txt");
        fw.write(empStr);
        fw.close();
        System.out.println("\nWRITING EMP OBJECT IN FILE\nEmployee Object Stored in employeeSimpleFile.txt File.\n");
        FileReader fr = new FileReader("employeeSimpleFile.txt");
        int ch;
        String sb="";
        while ((ch = fr.read()) != -1) {
            sb+=((char) ch);
        }
        String[] tokens = sb.split(",");
        Employee employee2 = new Employee(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3]);
        System.out.println("READING EMP OBJECT FROM FILE\nEmployee Object Read from file successfully.\n");
        System.out.print((employee2.toStr()));
    }
}
