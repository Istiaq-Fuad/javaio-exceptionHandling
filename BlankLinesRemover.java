import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class BlankLinesRemover {
  public static void removeLines(String fileName) {
    ArrayList<String> lines = new ArrayList<>();

    try (Scanner in = new Scanner(new File(fileName))) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        if (!line.trim().isEmpty()) {
          lines.add(line);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try (PrintWriter out = new PrintWriter(fileName)) {
      for (String line : lines) {
        out.println(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}