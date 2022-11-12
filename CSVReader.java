import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CSVReader {
  private ArrayList<String> rows;

  public CSVReader(String fileName) {
    rows = new ArrayList<>();
    try (Scanner inFile = new Scanner(new File(fileName))) {
      while (inFile.hasNext()) {
        rows.add(inFile.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
    }
  }

  public int numberOfRows() {
    return rows.size();
  }

  public int numberOfFields(int row) {
    if (row < 0 || row >= rows.size()) {
      throw new IllegalArgumentException("Row: " + row);
    }
    return getFields(row).size();
  }

  private ArrayList<String> getFields(int row) {
    ArrayList<String> fields = new ArrayList<>();
    Scanner line = new Scanner(rows.get(row));
    line.useDelimiter(",");
    while (line.hasNext()) {
      String field = line.next().trim();
      if (field.startsWith("\"")) {
        while (!field.endsWith("\"")) {
          field = field + "," + line.next();
        }
        field = field.substring(1, field.length() - 1);
      }
      field = field.replaceAll("\"\"", "\"");
      fields.add(field);
    }
    return fields;
  }

  public String field(int row, int column) {
    if (row < 0 || row >= rows.size()) {
      throw new IllegalArgumentException("Row: " + row);
    }
    if (column < 0 || column >= numberOfFields(row)) {
      throw new IllegalArgumentException("Column: " + column);
    }
    return getFields(row).get(column);
  }
}