import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ITAudit {
    public static void main(String[] args) {
 String command1 = "wmic /Namespace:\\\\root\\SecurityCenter2 Path AntiVirusProduct Get displayName,productState /Format:List";
String command2 = "powershell \"Get-HotFix | Sort-Object InstalledOn | Select-Object -Last 1\"";
try {
  Process process1 = Runtime.getRuntime().exec(command1);
  BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()));
  String line1;
  boolean foundAntivirus = false;
  while ((line1 = reader.readLine()) != null) {
  if (line1.startsWith("displayName") || line1.startsWith("productState")) {
  System.out.println(line1); 
  foundAntivirus = true;
  }
try{
  Process process2 = Runtime.getRuntime().exec(command2);
  BufferedReader reader = new BufferedReader(new InputStreamReader(process2.getInputStream()));
  String line2;
  StringBuilder sb = new StringBuilder();
  while ((line2 = reader.readLine()) != null) {
  sb.append(line2).append(System.lineSeparator());
  }
  if (!foundAntivirus) {
  System.out.println("No antivirus product is registered with the Windows Security Center.");
  }
  } 
catch (IOException e) {
  e.printStackTrace();
  }
  System.out.println("Most recent update:");
  System.out.println(sb.toString());
e.printStackTrace();
}

  
  
 
}

