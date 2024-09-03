import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntivirusUpdate {

    /**
     * Runs a PowerShell command and returns the output.
     *
     * @param command The PowerShell command to run.
     * @return The output of the command.
     * @throws IOException If an I/O error occurs.
     */
    private static String runPowerShellCommand(String command) throws IOException {
        StringBuilder output = new StringBuilder();
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        return output.toString();
    }

    /**
     * Checks for installed antivirus and its status.
     *
     * @throws IOException If an I/O error occurs.
     */
    public static void checkAntivirusStatus() throws IOException {
        // PowerShell command to query antivirus status from WMI
        String command = "powershell \"Get-CimInstance -Namespace root/SecurityCenter2 -ClassName AntivirusProduct\"";

        String result = runPowerShellCommand(command);

        if (result.contains("displayName")) {
            System.out.println("Antivirus Found");
            System.out.println(result); // Print raw result for demonstration

            // Additional parsing could be implemented here to interpret the productState and other properties.
            // Interpretation of productState to determine up-to-date status and licensing would require
            // specific knowledge of the bitmask values used by Windows Security Center, which can vary.
            
        } else {
            System.out.println("No antivirus found on this system.");
        }
    }
public class WindowsOSStatusChecker {

    /**
     * Executes a PowerShell command and returns its output as a string.
     * 
     * @param command The command to execute.
     * @return The output of the command.
     * @throws IOException If an error occurs during command execution.
     */
    private static String executePowerShellCommand(String command) throws IOException {
        StringBuilder output = new StringBuilder();
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        return output.toString();
    }

    /**
     * Checks if the Windows OS is licensed.
     * 
     * @return True if licensed, false otherwise.
     * @throws IOException If an error occurs during command execution.
     */
    public static boolean isWindowsLicensed() throws IOException {
        String command = "cscript //Nologo %windir%\\system32\\slmgr.vbs /dli";
        String result = executePowerShellCommand(command);

        // Simple check for license status in the output
        return result.contains("License Status: Licensed");
    }


    public static void main(String[] args) {
        try {
            checkAntivirusStatus();
        } catch (IOException e) {
            System.err.println("An error occurred while checking the antivirus status.");
            e.printStackTrace();
        }
}
}
    try {
            // Check Windows licensing status
            boolean licensed = isWindowsLicensed();
            System.out.println("Windows Licensed: " + licensed);
            
            // Additional checks for OS updates can be performed here using appropriate PowerShell commands
            // Note: Demonstrating the check for updates requires specific setup and might not work out of the box
            
        } catch (IOException e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }
}
}}
}
}
}