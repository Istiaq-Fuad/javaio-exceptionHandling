import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

//definition of "BlankLinesRemover" class
public class BlankLinesRemover {
  // objective 1 remove definition of "removeLines" class
  public static void removeLines(String fileName) {
    // create an object for "ArrayList" class
    ArrayList<String> lines = new ArrayList<>();
    // get the filename in try block
    try (Scanner in = new Scanner(new File(fileName))) {
      // check the condition
      while (in.hasNextLine()) {
        // get the input
        String line = in.nextLine();
        // check the "line" is empty
        if (!line.trim().isEmpty()) {
          // add the values
          lines.add(line);
        }
      }
    }
    // catch block
    catch (FileNotFoundException e) {
      // throw an error message
      e.printStackTrace();
    }
    // objective 2 write non blank in the same file again get the filename in try
    // block
    try (PrintWriter out = new PrintWriter(fileName)) {
      // check the condition
      for (String line : lines) {
        // print the output
        out.println(line);
      }
    }
    // catch block
    catch (FileNotFoundException e) {
      // throw an error message
      e.printStackTrace();
    }
  }
}