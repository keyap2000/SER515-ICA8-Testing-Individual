import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class WriteOutputToFile {

    public  WriteOutputToFile(String output) {
        try {
            String fileName = outputFileName();
            File file = new File(fileName);
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

            if (file.exists()) {
                System.out.println("file already exists");
            } else {
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write(output);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            }
        } catch(IOException e){
                System.out.println("IOException occurred.");
        }
    }
    
    public String outputFileName() {
        String outputFile;
        Scanner userInputFileName = new Scanner(System.in);
        int counter = 0;

        System.out.println("Enter output file name: ");
        outputFile = userInputFileName.nextLine();
        boolean validFileName = validateStringFilenameUsingContains(outputFile);
        if(validFileName){
        return outputFile;}
        else{
            counter++;
            System.out.println("bad file name");
            return "rules" + counter + ".txt";
        }
    }

        public static boolean validateStringFilenameUsingContains(String filename) {
            if (filename == null || filename.isEmpty() || filename.length() > 255) {
                return false;
            }
            return Arrays.stream(getInvalidCharsByOS()).noneMatch(ch -> filename.contains(ch.toString()));
        }

    public static Character[] getInvalidCharsByOS() {

        final Character[] INVALID_WINDOWS_SPECIFIC_CHARS = {'"', '*', '<', '>', '?', '|'};
        final Character[] INVALID_UNIX_SPECIFIC_CHARS = {'\000'};

        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return INVALID_WINDOWS_SPECIFIC_CHARS;
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return INVALID_UNIX_SPECIFIC_CHARS;
        } else {
            return new Character[]{};
        }
    }
}