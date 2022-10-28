import java.io.*;
import java.util.Scanner;

public class ReadInput {
    String output = "";

    public ReadInput() throws FileNotFoundException {

        File file = new File("InputFile1.dat");
        if (file.exists()) {
            Scanner sc = new Scanner(file);

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

        }else{
            System.out.println("file doesn't exist");
            output = "";
        }
        WriteOutputToFile w = new WriteOutputToFile(output);
    }
}