import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileCounter {

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

    public static void main(String[] args) {
        String commandOutput = executeCommand("cmd /c start /wait countFiles.bat");
        System.out.println(commandOutput);
    }
}