package Qno_2;
import java.io.*;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class BufferStream {

    private static OperatingSystemMXBean osMxBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    private static long getProcessCpuTime() {
        return osMxBean.getProcessCpuTime();
    }

    public static long WithoutBufferStream() {
        String inFileStr = "pic1.jpg";
        String outFileStr = "pic2.jpg";
        long startTime, elapsedTime;  // for speed benchmarking
        // Check file length
        File fileIn = new File(inFileStr);
//        System.out.println("File size is " + fileIn.length() + " bytes");
        // "try-with-resources" automatically closes all opened resources.
        try (FileInputStream in = new FileInputStream(inFileStr); FileOutputStream out = new FileOutputStream(outFileStr)) {
            startTime = System.nanoTime();
            int byteRead;
            // Read a raw byte, returns an int of 0 to 255.
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }
            elapsedTime = (System.nanoTime() - startTime);
//            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
            return elapsedTime;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static long WithBufferStream() {
        String inFileStr = "pic1.jpg";
        String outFileStr = "pic2.jpg";
        long startTime, elapsedTime;  // for speed benchmarking
        // Check file length
        File fileIn = new File(inFileStr);
//        System.out.println("File size is " + fileIn.length() + " bytes");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr)); BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {
            startTime = System.nanoTime();
            int byteRead;
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
//            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
            return elapsedTime;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.print("Elapsed Time Comparison\n");
        long tempTime1 = WithBufferStream();
        double elapsedTime1 = tempTime1/1000000.0;
        System.out.println("Elapsed Time for WithBufferStream : " + elapsedTime1 + " msec");

        long tempTime2 = WithoutBufferStream();
        double elapsedTime2 = tempTime2/1000000.0;
        System.out.println("Elapsed Time is for WithoutBufferStream : " + elapsedTime2 + " msec");

        System.out.print("Elapsed Time Conclusion\n");
        if(elapsedTime2<elapsedTime1){
            System.out.print("WithoutBufferStream() took "+ (elapsedTime1-elapsedTime2)+ " msec less than WithBufferStream\n");
        }
        else{
            System.out.print("WithBufferStream() took "+ (elapsedTime2-elapsedTime1)+ " msec less than WithoutBufferStream\n");
        }

        System.out.print("\nCPU Usage Comparison\n");


        long startCpuTime1 = getProcessCpuTime();
        long d1 = WithBufferStream();
        long endCpuTime1 = getProcessCpuTime();

        long elapsedCpuTime1 = endCpuTime1 - startCpuTime1;
        double totalCpuTime1 = osMxBean.getProcessCpuTime();

        double cpuUsage1 = (elapsedCpuTime1 / totalCpuTime1) * 100.0;

        System.out.println("CPU Usage for WithBufferStream: " + cpuUsage1 + " %");

        long startCpuTime2 = getProcessCpuTime();
        long d2 = WithBufferStream();
        long endCpuTime2 = getProcessCpuTime();

        long elapsedCpuTime2 = endCpuTime2 - startCpuTime2;
        double totalCpuTime2 = osMxBean.getProcessCpuTime();

        double cpuUsage2 = (elapsedCpuTime2 / totalCpuTime2) * 100.0;

        System.out.println("CPU Usage for WithoutBufferStream: " + cpuUsage2 + " %");

        System.out.print("CPU Usage Conclusion\n");
        if(cpuUsage2<cpuUsage1){
            System.out.print("WithoutBufferStream() consume "+ (cpuUsage1-cpuUsage2)+ " % CPU less than WithBufferStream");
        }
        else{
            System.out.print("WithBufferStream() consume "+ (cpuUsage2 - cpuUsage1)+ " % CPU less than WithoutBufferStream");
        }


    }
}
