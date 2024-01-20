import java.io.*;
import java.net.*;
import java.util.*;
public class SpamCheckLec11 {
    public static final String BLACKHOLE = "sbl.spamhaus.org";
    private static Set<String> processedIPs = new HashSet<>();
    public static void main(String[] args) {
        String logFileName = "apache_logs.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(logFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String ipAddress = extractIPAddressFromLog(line);
                if (ipAddress != null) {
                    if (isSpammer(ipAddress)) {
                        if (!processedIPs.contains(ipAddress)) {
                            processedIPs.add(ipAddress); // Add the address to processed IPs
                            System.out.println(ipAddress + " is a known spammer.");
                        }
//                        System.out.println(ipAddress + " is a known spammer.");
                    } else {
//                        System.out.println(ipAddress + " appears legitimate.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractIPAddressFromLog(String line) {
        String[] parts = line.split(" - - ");
        if (parts.length > 0) {
            String[] ipPart = parts[0].split(" ");
            if (ipPart.length > 0) {
                return ipPart[0];
            }
        }
        return null;
    }
    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }}}