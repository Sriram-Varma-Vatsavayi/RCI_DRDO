import java.io.BufferedReader;
import java.io.InputStreamReader;

public class USBDevices {

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

    public static String listUSBDevicesFromRegistry() {
        String command = "reg query HKLM\\SOFTWARE\\Microsoft\\Windows Portable Devices\\Devices";
        String result = executeCommand(command);
        return result; // Further parsing might be needed to extract useful information
    }

    // Add other methods from your original SystemChecker class here.

    public static void main(String[] args) {
        System.out.println("Listing USB Devices from Registry:");
        System.out.println(listUSBDevicesFromRegistry());
    }
}