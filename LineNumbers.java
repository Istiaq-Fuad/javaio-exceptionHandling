import java.io.*;
import java.util.Scanner;

//definition of "LineNumbers" class
public class LineNumbers {
  // definition of main method
  public static void main(String[] args) {
    // create an object for "Scanner" class
    Scanner in = new Scanner(System.in);
    // get the input file name
    System.out.print("Please enter the file name for input: ");
    String filename1 = in.next();
    // get the output file name
    System.out.print("Please enter the file name for output: ");
    String filename2 = in.next();
    // objective 1 :: read text file and send it to out file and also line number
    // try block
    try (Scanner inFile = new Scanner(new File(filename1)); PrintWriter out = new PrintWriter(filename2)) {
      // declare the variable and set the value
      int count = 1;
      // check the condition
      while (inFile.hasNext()) {
        // add the "/* */" to the line
        out.println("/* " + count + " */ " + inFile.nextLine());
        // increment the value
        count++;
      }
    }
    // catch block
    catch (FileNotFoundException e) {
      // display an error message
      System.out.println("File not found!");
    }

    in.close();
  }
}