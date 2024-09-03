import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckUSBStorageBlockStatus {
    public static void main(String[] args) {
        try {
            // Command to read the 'Start' value under the USBSTOR service key
            String command = "reg query \"HKLM\\SYSTEM\\CurrentControlSet\\Services\\USBSTOR\" /v Start";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isBlocked = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Start") && line.contains("0x4")) {
                    isBlocked = true;
                }
            }
            
            // Determine whether USB storage is blocked
            if (isBlocked) {
                System.out.println("USB storage is blocked.");
            } else {
                System.out.println("USB storage is not blocked.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}