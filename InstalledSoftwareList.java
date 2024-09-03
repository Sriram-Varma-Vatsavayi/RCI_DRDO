import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InstalledSoftwareList {
    public static void main(String[] args) {
        try {
            String line;
            Process process = Runtime.getRuntime().exec("wmic product get name");
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (!line.isEmpty()) {
                    System.out.println(line);
                }
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}