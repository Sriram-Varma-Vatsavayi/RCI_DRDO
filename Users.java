import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Users {

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

    public static void listSystemUsers() {
        String command = "net user";
        String result = executeCommand(command);
        System.out.println(result);
        // Further parsing needed to count users
    }
    
    public static void checkUserPasswordSet(String username) {
        String command = "net user " + username;
        String result = executeCommand(command);
        if(result.contains("Account active               Yes") && !result.contains("Password Required            No")) {
            System.out.println("Password is set for user: " + username);
        } else {
            System.out.println("Password might not be set or account is inactive for user: " + username);
        }
        // Note: This is an approximation. Windows does not directly expose whether a password is set.
    }

    public static void main(String[] args) {
        listSystemUsers();
        checkUserPasswordSet("username"); // Replace "username" with the actual username to check
    }
}