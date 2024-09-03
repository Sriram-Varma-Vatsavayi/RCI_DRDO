import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastOSUpdate {
    public static void main(String[] args) {
        try {
            // PowerShell command to get the most recent update
            String command = "powershell \"Get-HotFix | Sort-Object InstalledOn | Select-Object -Last 1\"";

            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }

            System.out.println("Most recent update:");
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}