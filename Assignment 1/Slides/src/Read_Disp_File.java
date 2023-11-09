import java.io.FileInputStream;
class Read_Disp_File {
    public static void main(String args[]) throws Exception {
        FileInputStream fis = new FileInputStream("a.txt");
// Read and display data (int type)
        int i;
        while ((i = fis.read()) != -1) {
        }
        fis.close();
    }
}