import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class USBDriveCount {
    public static void main(String[] args) {
        try {
            // Command to list logical disk drives where DriveType is 2 (removable drives)
            String command = "wmic logicaldisk where drivetype=2 get DeviceID";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int driveCount = -1; // Start at -1 to account for the header row
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    driveCount++;
                }
            }
            
            // Print the number of connected USB drives
            System.out.println("Number of connected USB drives: " + driveCount);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}