package Lecture_6;
import java.util.*;
import java.io.*;
public class StudentRecordReader {
    DataInputStream dataInput;
    public StudentRecordReader(String inputFile) throws IOException {
        dataInput = new DataInputStream(new FileInputStream(inputFile));
    }
    public List<Student> readAll() throws IOException {
        List<Student> listStudent = new ArrayList<>();
        while (true) {
            try {
                String name = dataInput.readUTF();
                boolean gender = dataInput.readBoolean();
                int age = dataInput.readInt();
                float grade = dataInput.readFloat();
                Student student = new Student(name, gender, age, grade);
                listStudent.add(student);
            } catch (EOFException e) {
                // End of file reached, exit the loop
                break;
            }
        }
        dataInput.close();
        return listStudent;
    }

    public static void main(String[] args) throws Exception {
        StudentRecordReader reader = new StudentRecordReader("students.txt");
        List<Student> listStudent = reader.readAll();
        for (Student student : listStudent) {
            System.out.print(student.getName() + "\t");
            System.out.print(student.getGender() + "\t");
            System.out.print(student.getAge() + "\t");
            System.out.println(student.getGrade());
        }
    }
}
