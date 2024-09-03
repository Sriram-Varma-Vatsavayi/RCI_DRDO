import java.io.File;

public class ListFolders {
    public static void main(String[] args) {
        // Specify the path of the directory you want to list folders from
        String directoryPath = "Sriram/System/";

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Get all the files and directories within the specified directory
        File[] filesList = directory.listFiles();

        if (filesList != null) {
            for (File file : filesList) {
                // Check if the file object is a directory
                if (file.isDirectory()) {
                    // Print the name of the directory
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("The specified path does not exist or is not a directory.");
        }
    }
}