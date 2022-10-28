import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteOutputToFile {

    public  WriteOutputToFile(String output) {
        try {
            String fileName = "rule.txt";
            File file = new File("rule.txt");
            String extension = "";
            String name = "";

            int indexOfDot = fileName.lastIndexOf('.');
            extension = fileName.substring(indexOfDot + 1);
            name = fileName.substring(0, indexOfDot);

            Path path = Paths.get(fileName);
            int counter = 1;

            while(Files.exists(path)){
                fileName = name + "" + counter + "." + extension;
                path = Paths.get(fileName);
                counter++;
            }

            //
            if (file.exists()) {
                System.out.println("file already exists");
            } else {
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write(output);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            }
        } catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
    }
}