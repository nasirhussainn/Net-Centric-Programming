package Qno_3;

import java.io.*;

public class Employee implements Serializable {
    private int empID;
    private String name;
    private String department;
    private String designation;

    public Employee(int e, String n, String d, String desg){
        empID=e;
        name=n;
        department=d;
        designation=desg;
    };

    public Employee(){}

    public int getEmpID(){
        return this.empID;
    }
    public String getName(){
        return this.name;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getDesignation(){
        return this.designation;
    }
    public String toStr() {
        return empID + "," + name + "," + department + "," + designation;
    }

    public static byte[] serializeObject(Serializable obj) throws IOException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static <T extends Serializable> T deserializeObject(byte[] bytes) throws IOException, ClassNotFoundException {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }


}
