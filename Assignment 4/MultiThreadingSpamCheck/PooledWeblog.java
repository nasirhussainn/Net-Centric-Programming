package MultiThreadingSpamCheck;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.*;
// Requires Java 7 for try-with-resources and multi-catch
public class PooledWeblog {
    public static final String BLACKHOLE = "sbl.spamhaus.org";
    private final static int NUM_THREADS = 5;
    private static Set<String> processedIPs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Queue<LogEntry> results = new LinkedList<LogEntry>();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream("apache_logs.txt"), "UTF-8"));) {
            for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
                String ipAddress = extractIPAddressFromLog(entry);
                LookupTask task = new LookupTask(ipAddress);
                Future<String> future = executor.submit(task);
                LogEntry result = new LogEntry(ipAddress, future);
                results.add(result);
            }
        }

// Start printing the results. This blocks each time a result isn't ready.
        for (LogEntry result : results) {
            try {
                boolean isSpammer = isSpammer(result.future.get());
                if (isSpammer) {
                    if (!processedIPs.contains(result.future.get())) {
                        processedIPs.add(result.future.get()); // Add the address to processed IPs
                        System.out.println(result.future.get() + " is a known spammer.");
                    }
                } else {
//                    System.out.println(result.original + " appears legitimate.");
                }
            } catch (InterruptedException | ExecutionException ex) {
                System.out.println(result.original);
            }
        }
        executor.shutdown();
    }
    private static class LogEntry {
        String original;
        Future<String> future;
        LogEntry(
                String original, Future<String> future) {
            this.original = original;
            this.future = future;
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