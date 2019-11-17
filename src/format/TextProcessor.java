package format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextProcessor {

    public static ArrayList<String> processInputFile(File file) throws IOException
    {
        ArrayList<String> outputDoc = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bfreader = new BufferedReader(fileReader);
        String line;

        while((line = bfreader.readLine()) != null) {
            outputDoc.add(line + "\n");
        }
        return outputDoc;
    }
}
