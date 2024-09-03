import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntivirusChecker {

    /**
     * Checks if an antivirus product is installed on the system.
     * This method specifically works for Windows operating systems.
     *
     * @return true if an antivirus is found, false otherwise.
     */
    public static boolean isAntivirusInstalled() {
        try {
            // PowerShell command to query antivirus status from WMI
            String command = "powershell \"Get-CimInstance -Namespace root/SecurityCenter2 -ClassName AntivirusProduct\"";

            // Execute the PowerShell command
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

            String line;
            // Process the command output
            while ((line = reader.readLine()) != null) {
                if (line.contains("displayName")) {
                    System.out.println("Antivirus Found: " + line.split(":")[1].trim());
                    return true; // Antivirus found
                }
            }
            return false; // No antivirus found
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Check if an antivirus is installed and print the result
        boolean isInstalled = isAntivirusInstalled();
        if (isInstalled) {
            System.out.println("An antivirus is installed on this system.");
        } else {
            System.out.println("No antivirus found on this system.");
        }
    }
}