import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckWiFiStatus {
    public static boolean isWiFiEnabled() {
        try {
            // Execute the command to show Wi-Fi interface information
            String command = "netsh wlan show interfaces";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Look for lines indicating the state of the Wi-Fi interface
                if (line.trim().startsWith("State")) {
                    // Check if the state is not disconnected
                    return !line.contains("disconnected");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Assume Wi-Fi is disabled if we cannot determine its state
        return false;
    }

    public static void main(String[] args) {
        if (isWiFiEnabled()) {
            System.out.println("Wi-Fi is enabled.");
        } else {
            System.out.println("Wi-Fi is disabled or not available.");
        }
    }
}