import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LZWDecompress {
    public static void decompress(String inputFile, String outputFile) throws IOException {
        BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
        FileWriter outputWriter = new FileWriter(outputFile);

        Map<Integer, String> dictionary = new HashMap<>();

        for (int i = 0; i < 128; i++) {
            dictionary.put(i, String.valueOf((char) i));
        }

        int next = 128;
        String prevString = "";
        String currentString;

        String line;
        while ((line = inputReader.readLine()) != null) {
            int codeValue = Integer.parseInt(line);

            if (dictionary.containsKey(codeValue)) {
                currentString = dictionary.get(codeValue);
            }

            else {
                currentString = prevString + prevString.charAt(0);
            }

            outputWriter.write(currentString);

            if (!prevString.isEmpty()) {
                dictionary.put(next, prevString + currentString.charAt(0));
                next++;
            }

            prevString = currentString;

        }

        inputReader.close();
        outputWriter.close();
    }
}
