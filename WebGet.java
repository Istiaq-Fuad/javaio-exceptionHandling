import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// definition of "WebGet" class
public class WebGet {
  // definition of "dumpScannerToFile" method
  public static void dumpScannerToFile(Scanner in, String filename) {
    // objective 2 write all data from url web page to a file try block
    try (PrintWriter outfile = new PrintWriter(filename)) {
      // check the condition
      while (in.hasNextLine()) {
        // get the file name from the user
        String line = in.nextLine();
        // write the content to the file
        outfile.println(line);
      }
    }
    // catch block
    catch (FileNotFoundException e) {
      // display an error message
      System.out.println("Cannot write to file " + filename);
    }
  }

  // definition of main method
  public static void main(String[] args) {
    // create an object for "Scanner" class
    Scanner console = new Scanner(System.in);
    // get the url from the user
    System.out.println("Enter the url to scan: ");

    String url = console.nextLine();
    // get the file name from the user
    System.out.println("Enter the file to write to: ");
    String fileName = console.nextLine();
    // create an object for "URL"
    URL locator;

    // try block
    try {
      // create an object for "URL"
      locator = new URL(url);
      // objective1 read all data from url web page try block
      try (Scanner in = new Scanner(locator.openStream())) {
        // call the method
        dumpScannerToFile(in, fileName);
      }
      // catch block
      catch (IOException e) {
        // display an error message
        System.out.println("IO Exception!");
      }
    }
    // catch block
    catch (MalformedURLException e) {
      // display an error message
      System.out.println("Invalid URL.");
    }

    console.close();
  }
}