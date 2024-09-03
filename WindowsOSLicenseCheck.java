import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WindowsOSLicenseCheck {

    public static void main(String[] args) {
        try {
            // Command to check Windows activation status
            String command = "cmd /c cscript //Nologo %windir%\\system32\\slmgr.vbs /xpr";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
            
            // Example output parsing - This is simplistic and might need to be adapted
            if (output.toString().contains("The machine is permanently activated.")) {
                System.out.println("Windows is activated.");
            } else {
                System.out.println("Windows activation status is unclear, or it is not activated.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking the OS license status.");
            e.printStackTrace();
        }
    }
}