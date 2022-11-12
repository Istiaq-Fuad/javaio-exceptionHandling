public class CSVColumnSummary {
  private CSVReader reader;

  public CSVColumnSummary(String fileName) {
    reader = new CSVReader(fileName);
  }

  public double columnAvg(int col) {
    double sum = 0;

    for (int row = 0; row < reader.numberOfRows(); ++row) {
      sum += Double.parseDouble(reader.field(row, col));
    }

    return sum / reader.numberOfRows();
  }

  public double columnMin(int col) {
    double min = Double.parseDouble(reader.field(0, col));

    for (int row = 1; row < reader.numberOfRows(); ++row) {
      double value = Double.parseDouble(reader.field(row, col));

      if (value < min) {
        min = value;
      }
    }
    return min;
  }

  public double columnMax(int col) {
    double max = Double.parseDouble(reader.field(0, col));

    for (int row = 1; row < reader.numberOfRows(); ++row) {
      double value = Double.parseDouble(reader.field(row, col));

      if (value > max) {
        max = value;
      }
    }
    return max;
  }
}