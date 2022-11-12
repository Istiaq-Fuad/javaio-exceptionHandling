import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Class
class GFG { // Fundamental driver technique
    public static void main(String[] args) //
    {
        try {
            FileReader fr = new FileReader("gfgInput.txt");
            // Creating a FileWriter object
            FileWriter fw = new FileWriter("gfgOutput.txt");
            String str = "";
            int i;
            while ((i = fr.read()) != -1) { // Storing every character in the string
                str += (char) i;
            }
            // Print and show the string that // contains record information
            System.out.println(str); // Writing above string data to // FileWriter object
            fw.write(str); // Shutting the record utilizing close() strategy
            fr.close();
            fw.close(); // Display message
            System.out.println("File reading and writing both done");
        } catch (IOException e) { // If there is no file in specified path
            System.out.println("There are some IOException");
        }

    }
}