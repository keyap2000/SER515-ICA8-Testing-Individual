import java.io.*;

public class WriteOutputToFile {

    public  WriteOutputToFile(String output) {
        try {
            FileWriter myWriter = new FileWriter("rule.txt");
            myWriter.write(output);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
