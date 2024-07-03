import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class TextFileHandler {
    public static void writeTextFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            writer.write("\nLuqman has created this\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readTextFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(filename)) {
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String textFilename = "example.txt";
        String textContent = "This is a sample text file.";

        writeTextFile(textFilename, textContent);
        System.out.println("Text file content:");
        System.out.println(readTextFile(textFilename));
    }
}
