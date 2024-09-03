import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SystemChecker {

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

    public static boolean isAntivirusInstalled() {
        String command = "powershell \"Get-CimInstance -Namespace root/SecurityCenter2 -ClassName AntivirusProduct\"";
        String result = executeCommand(command);
        return result.contains("displayName");
    }

    public static boolean isWindowsLicensed() {
        String command = "cscript //Nologo %windir%\\system32\\slmgr.vbs /dli";
        String result = executeCommand(command);
        return result.contains("License Status: Licensed");
    }

    public static int countConnectedUSBDrives() {
        String command = "wmic logicaldisk where drivetype=2 get DeviceID";
        String result = executeCommand(command);
        int driveCount = 0; // Start at 0, increment for each line that contains a drive letter.
        for (String line : result.split("\n")) {
            if (line.trim().matches("^[A-Z]:$")) {
                driveCount++;
            }
        }
        return driveCount;
    }

    public static String getLastOSUpdateDate() {
        String command = "wmic qfe get InstalledOn /format:list";
        String output = executeCommand(command);
        return output.trim();
    }

    public static String getAntivirusLastUpdate() {
        return "This feature requires specific implementation based on the antivirus software.";
    }

    public static boolean isUSBStorageBlocked() {
        String command = "reg query \"HKLM\\SYSTEM\\CurrentControlSet\\Services\\USBSTOR\" /v Start";
        String result = executeCommand(command);
        return result.contains("0x4");
    }

    public static boolean isBluetoothEnabled() {
        String command = "reg query \"HKLM\\SYSTEM\\CurrentControlSet\\Services\\BTHSERV\" /v Start";
        String result = executeCommand(command);
        return result.contains("0x3") || result.contains("0x2");
    }

    public static boolean isWiFiEnabled() {
        String command = "netsh wlan show interfaces";
        String result = executeCommand(command);
        return result.contains("State") && !result.contains("disconnected");
    }

    public static boolean isBitLockerEnabled() {
        String command = "cmd /c manage-bde -status";
        String result = executeCommand(command);
        return result.contains("Protection Status: Protection On");
    }

    public static String listUSBDevicesFromRegistry() {
        String command = "reg query HKLM\\SOFTWARE\\Microsoft\\Windows Portable Devices\\Devices";
        String result = executeCommand(command);
        return result;
    }

    public static void listSystemUsers() {
        String command = "net user";
        String result = executeCommand(command);
        System.out.println(result);
    }
    
    public static boolean isPasswordSetForCurrentUser() {
        String command = "net user %username%";
        String result = executeCommand(command);
        return result.contains("Password required");
    }
public static String getInstalledSoftwareList() {
        // Command to get the list of installed software on Windows
        String command = "wmic product get name";
        return executeCommand(command);
    }

    public static void main(String[] args) {
try {
        PrintStream fileOut = new PrintStream("./systemdetails.txt");
        System.setOut(fileOut);


        
            System.out.println("Antivirus Installed: " + isAntivirusInstalled());
            System.out.println("Windows Licensed: " + isWindowsLicensed());
            System.out.println("Connected USB Drives: " + countConnectedUSBDrives());
            System.out.println("Last OS Update Date: " + getLastOSUpdateDate());
            System.out.println("Antivirus Last Update: " + getAntivirusLastUpdate());
            System.out.println("USB Storage Blocked: " + isUSBStorageBlocked());
            System.out.println("Bluetooth Enabled: " + isBluetoothEnabled());
            System.out.println("Wi-Fi Enabled: " + isWiFiEnabled());
            System.out.println("BitLocker Enabled: " + isBitLockerEnabled());
            System.out.println("Listing USB Devices from Registry:");
            System.out.println(listUSBDevicesFromRegistry());
            listSystemUsers();
            System.out.println("Password set for current user: " + isPasswordSetForCurrentUser());
System.out.println("List of Installed Software:");
        System.out.println(getInstalledSoftwareList());
Runtime.getRuntime().exec("notepad.exe systemdetails.txt");

        fileOut.close(); // It's good practice to close the stream after its use

    } catch (FileNotFoundException e) {
        System.err.println("File not found exception: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("An error occurred: " + e.getMessage());
    }
            
    }
}