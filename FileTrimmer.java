import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.ListIterator;

//definition of "FileTrimmer" class

public class FileTrimmer

{

  // definition of "trimBlankLines" class

  public static void trimBlankLines(String fileName)

  {

    // create an object for "ArrayList" class

    ArrayList<String> lines = new ArrayList<>();

    boolean nonBlankFound = false;

    // get the filename in try block

    try (Scanner in = new Scanner(new File(fileName)))

    {

      // check the condition

      while (in.hasNextLine())

      {

        // get the input

        String line = in.nextLine();

        /* Skip lines until non blank found */

        if (!line.trim().isEmpty() || nonBlankFound)

        {

          // set the value

          nonBlankFound = true;

          // add the values

          lines.add(line);

        }

      }

    }

    // catch block

    catch (FileNotFoundException e)

    {

      // throw an error message

      e.printStackTrace();

    }

    // create an object for "ListIterator" class

    ListIterator<String> it = lines.listIterator(lines.size());

    // check the condition

    while (it.hasPrevious() && it.previous().trim().isEmpty())

    {

      /* objective 1 :: remove blank lines at the end of the file */

      it.remove();

    }

    // objective 1 :: write the remaining line back to the same file get the
    // filename in try block

    try (PrintWriter out = new PrintWriter(fileName))

    {

      // check the condition

      for (String line : lines)

      {

        // print the output

        out.println(line);

      }

    }

    // catch block

    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}