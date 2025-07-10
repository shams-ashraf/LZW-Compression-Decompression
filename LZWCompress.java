import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class LZWCompress {
    public static void compress(String inputFile, String outputFile, String dictionaryFile) throws IOException {
        FileReader inputReader = new FileReader(inputFile);
        FileWriter outputWriter = new FileWriter(outputFile);
        FileWriter dictWriter = new FileWriter(dictionaryFile);

        Map<String, Integer> dictionary = new HashMap<>();
        Map<Integer, String> NewD = new TreeMap<>();

        for (int i = 0; i < 128; i++) {
            dictionary.put(String.valueOf((char) i), i);
        }

        int next = 128;
        String CurrentStr = "";
        int character;

        while ((character = inputReader.read()) != -1) {
            char currentChar = (char) character;
            NewD.put((int) currentChar, String.valueOf(currentChar));
            String nextString = CurrentStr + currentChar;

            if (dictionary.containsKey(nextString)) {
                CurrentStr = nextString;
            }
            else {
                outputWriter.write(dictionary.get(CurrentStr) + "\n");
                dictionary.put(nextString, next);
                NewD.put(next, nextString);
                next++;
                CurrentStr = String.valueOf(currentChar);
            }
        }

        if (!CurrentStr.isEmpty()) {
            outputWriter.write(dictionary.get(CurrentStr) + "\n");
        }

        for (Map.Entry<Integer, String> entry : NewD.entrySet()) {
            dictWriter.write(entry.getKey() + " : " + entry.getValue() + "\n");
        }

        inputReader.close();
        outputWriter.close();
        dictWriter.close();
    }
}
