import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BabyNames {
  public static String processName(Scanner in) {
    String name = in.next();
    return name;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new File("babynames.txt"));
        PrintWriter boyOut = new PrintWriter("boynames.txt");
        PrintWriter girlOut = new PrintWriter("girlnames.txt")) {
      while (in.hasNextInt()) {
        boyOut.println(processName(in));
        girlOut.println(processName(in));
      }

      System.out.println("The program runs successfully");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}