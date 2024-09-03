import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {

    // List to hold found files
    private List<File> foundFiles = new ArrayList<>();

    public static void main(String[] args) {
        FileFinder finder = new FileFinder();
        // Starting directory for the search
        String startDir = "C:\\path\\to\\start\\directory"; // Change this to your starting directory
        // Extensions to look for
        String[] extensions = {"jpg", "pdf"};

        finder.findFiles(startDir, extensions);

        // Print out found files
        for (File file : finder.getFoundFiles()) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public void findFiles(String directoryName, String[] extensions) {
        File directory = new File(directoryName);

        // Get all files from the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // If the file is a directory, recursively search it
                if (file.isDirectory()) {
                    findFiles(file.getAbsolutePath(), extensions);
                } else {
                    // Check if file matches any of the extensions
                    for (String extension : extensions) {
                        if (file.getName().toLowerCase().endsWith("." + extension)) {
                            foundFiles.add(file);
                            break;
                        }
                    }
                }
            }
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}