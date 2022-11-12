import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DualGenderNames {
    public static String processName(Scanner in) {
        String name = in.next();
        return name;
    }

    public static void printSameNames(ArrayList<String> boyNames, ArrayList<String> girlNames) {
        for (String name : boyNames) {
            if (girlNames.contains(name)) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("babynames.txt"))) {
            ArrayList<String> boyNames = new ArrayList<String>();
            ArrayList<String> girlNames = new ArrayList<String>();

            while (in.hasNextInt()) {
                boyNames.add(processName(in));
                girlNames.add(processName(in));
            }
            printSameNames(boyNames, girlNames);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}