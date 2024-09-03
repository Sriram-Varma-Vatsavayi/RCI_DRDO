import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckBitLockerStatus {
    public static void main(String[] args) {
        try {
            
            String command = "manage-bde -status C:";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            // Read and process the command's output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isBitLockerEnabled = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Conversion Status") && !line.contains("Fully Decrypted")) {
                    isBitLockerEnabled = true;
                    break;
                }
            }
            
            // Output the BitLocker status
            if (isBitLockerEnabled) {
                System.out.println("BitLocker is enabled for the C: drive.");
            } else {
                System.out.println("BitLocker is not enabled for the C: drive.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
 try {
            
            String command = "manage-bde -status D:";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            // Read and process the command's output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isBitLockerEnabled = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Conversion Status") && !line.contains("Fully Decrypted")) {
                    isBitLockerEnabled = true;
                    break;
                }
            }
            
            // Output the BitLocker status
            if (isBitLockerEnabled) {
                System.out.println("BitLocker is enabled for the  D: drive.");
            } else {
                System.out.println("BitLocker is not enabled for the D: drive.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}