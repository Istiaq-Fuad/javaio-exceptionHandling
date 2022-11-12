import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BlankLineRemoverRunner {
  public static void main(String[] args) {
    // objective 1 remove :call the method with a filename
    BlankLinesRemover.removeLines("lines.txt");
    // declare the variable
    int count = 0;
    // get the file name in try block
    try (Scanner in = new Scanner(new File("lines.txt"))) {
      // check the condition
      while (in.hasNextLine()) {
        // get the input
        in.nextLine();
        // increment the value
        count++;
      }
    }
    // catch block
    catch (FileNotFoundException e) {
      // throw exception
      e.printStackTrace();
    }
    // display the outputs
    System.out.println("Number of non-blank lines: " + count);
    System.out.println("Expected: 10");
  }
}
