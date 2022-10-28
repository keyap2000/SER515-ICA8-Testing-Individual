import java.io.*;
import java.util.Scanner;

public class ReadInput {

    public ReadInput() throws FileNotFoundException{

        File file = new File("InputFile.dat");
        Scanner sc = new Scanner(file);
        String output = "";

        if (file.length() == 0) {
            System.out.println("empty file");
            output = "empty file";
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            CountUrinals cu = new CountUrinals(line);
            int count = cu.countUrinals();
            System.out.println("input: " + line + " , count: " + count);
            output = output + count + "\n";
        }
        WriteOutputToFile w = new WriteOutputToFile(output);
    }
}