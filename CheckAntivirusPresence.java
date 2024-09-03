import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckAntivirusPresence {
    public static void main(String[] args) {
        try {
            // Command to list all antivirus products registered with the Security Center
            String command = "wmic /Namespace:\\\\root\\SecurityCenter2 Path AntiVirusProduct Get displayName,productState /Format:List";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            boolean foundAntivirus = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("displayName") || line.startsWith("productState")) {
                    System.out.println(line); // Print the name and product state of the antivirus
                    foundAntivirus = true;
                }
            }
            
            if (!foundAntivirus) {
                System.out.println("No antivirus product is registered with the Windows Security Center.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}