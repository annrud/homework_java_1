package homework2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAndLog {
    public static void main(String[] args){
        try {
                writeToFile(getString());
            } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String getString() {
        String str = "TEST";
        return str.repeat(100);
    }
    public static void writeToFile(String str) throws IOException {
        File f = new File("file.txt");
        FileWriter writer = new FileWriter(f, false);
        writer.write(str);
        writer.close();
    }
}
