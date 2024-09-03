import java.io.FileNotFoundException;
import java.io.PrintStream;
public class Notepad{
public static void main(String[] args) {
    try {
        PrintStream fileOut = new PrintStream("./hello.txt");
        System.setOut(fileOut);

        System.out.println("Hello, World!");

        // Automatically open the file in Notepad
        Runtime.getRuntime().exec("notepad.exe hello.txt");

        fileOut.close(); // It's good practice to close the stream after its use

    } catch (FileNotFoundException e) {
        System.err.println("File not found exception: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("An error occurred: " + e.getMessage());
    }
}
}
