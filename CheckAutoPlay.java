import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckAutoPlay {

    public static void main(String[] args) {
        try {
            // Command to query a common Autoplay registry setting
            String command = "reg query \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\" /v NoDriveTypeAutoRun";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("NoDriveTypeAutoRun")) {
                    System.out.println("Autoplay registry setting found: " + line.trim());
                    // Parsing the specific value to determine if Autoplay is enabled/disabled
                    // would depend on interpreting the registry key's data value, which
                    // can vary based on system configuration.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}