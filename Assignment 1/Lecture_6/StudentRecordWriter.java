package Lecture_6;
import java.util.*;import java.io.*;
public class StudentRecordWriter {
    DataOutputStream dataOutput;
    public StudentRecordWriter(String outputFile) throws IOException {
        dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
    }
    public void write(Student student) throws IOException {
        dataOutput.writeUTF(student.getName());
        dataOutput.writeBoolean(student.getGender());
        dataOutput.writeInt(student.getAge());
        dataOutput.writeFloat(student.getGrade());
    }
    public void save() throws IOException {
        dataOutput.close();
    }
    public static void main(String[] args) throws Exception{
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("Alice", false, 23, 80.5f));
        listStudent.add(new Student("Brian", true, 22, 95.0f));
        listStudent.add(new Student("Carol", false, 21, 79.8f));
        StudentRecordWriter writer = new StudentRecordWriter("students.txt");
        for (Student student : listStudent) {
            writer.write(student);
        }
        writer.save();
    }
}
