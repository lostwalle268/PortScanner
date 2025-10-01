import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class PortScanner {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";

    private static final Map<Integer, String> portServices = new HashMap<>();
    static {
        portServices.put(21, "FTP");
        portServices.put(22, "SSH");
        portServices.put(23, "Telnet");
        portServices.put(25, "SMTP");
        portServices.put(53, "DNS");
        portServices.put(80, "HTTP");
        portServices.put(110, "POP3");
        portServices.put(143, "IMAP");
        portServices.put(443, "HTTPS");
        portServices.put(3306, "MySQL");
        portServices.put(3389, "RDP");
        // Add more as needed
    }

    public static void main(String[] args) {
        String host = "localhost";
        int startPort = 0;
        int endPort = 1024;

        System.out.printf("%-8s %-10s %-20s\n", "Port", "Status", "Service");
        System.out.println("---------------------------------------------");

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket(host, port)) {
                String service = portServices.getOrDefault(port, "Unknown Service");
                System.out.printf("%-8d %s%-10s%s %-20s\n", port, GREEN, "OPEN", RESET, service);
            } catch (Exception ex) {
                // Uncomment to show closed ports:
                // System.out.printf("%-8d %s%-10s%s %-20s\n", port, RED, "CLOSED", RESET, "");
            }
        }
    }
}