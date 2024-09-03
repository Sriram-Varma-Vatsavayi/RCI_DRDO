import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UnwantedSoftwareDetector {

    public static void main(String[] args) {
        // Example list of unwanted software names or patterns
        List<String> unwantedSoftwarePatterns = List.of("Toolbar", "Adware");

        // Get the list of installed programs
        List<String> installedPrograms = getInstalledPrograms();

        // Filter installed programs based on the unwanted patterns
        List<String> detectedUnwantedSoftware = new ArrayList<>();
        for (String program : installedPrograms) {
            for (String pattern : unwantedSoftwarePatterns) {
                if (program.contains(pattern)) {
                    detectedUnwantedSoftware.add(program);
                    break;
                }
            }
        }

        // Output the results
        if (detectedUnwantedSoftware.isEmpty()) {
            System.out.println("No unwanted software detected.");
        } else {
            System.out.println("Detected unwanted software:");
            detectedUnwantedSoftware.forEach(System.out::println);
        }
    }

    private static List<String> getInstalledPrograms() {
        List<String> programs = new ArrayList<>();
        try {
            String command = "wmic product get name";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            // Skip the first line (Title of the column)
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    programs.add(line.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return programs;
    }
}