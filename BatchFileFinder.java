import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BatchFileFinder {

    // List to hold found batch files
    private List<File> foundBatchFiles = new ArrayList<>();

    public static void main(String[] args) {
        BatchFileFinder finder = new BatchFileFinder();
        // Starting directory for the search
        String startDir = "C:\\path\\to\\start\\directory"; // Change this to your starting directory

        finder.findBatchFiles(startDir);

        // Print out found batch files
        for (File file : finder.getFoundBatchFiles()) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public void findBatchFiles(String directoryName) {
        File directory = new File(directoryName);

        // Get all files from the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // If the file is a directory, recursively search it
                if (file.isDirectory()) {
                    findBatchFiles(file.getAbsolutePath());
                } else {
                    // Check if file is a batch file
                    if (file.getName().toLowerCase().endsWith(".bat")) {
                        foundBatchFiles.add(file);
                    }
                }
            }
        }
    }

    public List<File> getFoundBatchFiles() {
        return foundBatchFiles;
    }
}