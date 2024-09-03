import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteSystemCommand {

    public static void main(String[] args) {
        try {
            // Example command that is generally safe and informative
            String command;
            String osName = System.getProperty("os.name").toLowerCase();
            
            if (osName.contains("windows")) {
                command = "whoami";
            } else if (osName.contains("mac") || osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
                command = "whoami";
            } else {
                System.out.println("Unsupported operating system.");
                return;
            }

            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Current user is: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}