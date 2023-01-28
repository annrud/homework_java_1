package homework2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;

public class FileAndLog {
    public static void main(String[] args) throws IOException{
        Logger logger = Logger.getLogger(FileAndLog.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info("Тестовое логирование 2");
        writeToFile(getString());
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
