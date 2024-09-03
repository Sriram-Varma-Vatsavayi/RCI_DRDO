import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SystemUpdateInfo {

    private static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static String getLastOSUpdateDate() {
        // Command to get the install date of the latest installed update
        String command = "wmic qfe get InstalledOn /format:list";
        String output = executeCommand(command);
        
        // Parsing the output to find the latest date might require more sophisticated logic
        // For demonstration, simply return the raw output
        return output.trim();
    }

    public static String getAntivirusLastUpdate() {
        // This method assumes there's a way to query the antivirus last update via WMI or similar
        // In reality, antivirus software may not expose this information in a standardized way
        // As an example, we'll return a placeholder string
        return "This feature requires specific implementation based on the antivirus software.";
    }

    public static void main(String[] args) {
        System.out.println("Last OS Update Date:");
        System.out.println(getLastOSUpdateDate());
        
        System.out.println("\nAntivirus Last Update:");
        System.out.println(getAntivirusLastUpdate());
    }
}
