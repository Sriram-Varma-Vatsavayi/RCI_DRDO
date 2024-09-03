import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegistryAccess {
    public static void main(String[] args) {
        try {
            // Command to read a registry key value
            // For example, reading the value of 'Path' in 'Environment' variables of the current user
            String command = "reg query \"HKU\\Colors\" /v GrayText";
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            
            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
