import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckBluetoothStatus {
    public static void main(String[] args) {
        try {
            // Command to query the 'Start' value for the Bluetooth support service
            String command = "reg query \"HKLM\\SYSTEM\\CurrentControlSet\\Services\\BTHSERV\" /v Start";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isEnabled = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Start")) {
                    if (line.contains("0x3") || line.contains("0x2")) {
                        isEnabled = true;
                    }
                }
            }
            
            // Output whether Bluetooth is enabled or disabled
            if (isEnabled) {
                System.out.println("Bluetooth is enabled.");
            } else {
                System.out.println("Bluetooth is disabled or not configured.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}