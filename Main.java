import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        String inputFile = "input.txt";
        String compressedFile = "compressed.txt";
        String decompressedFile = "decompressed.txt";
        String dictionaryFile = "dictionary.txt";

        // Compression
        LZWCompress.compress(inputFile, compressedFile, dictionaryFile);

        // Decompression
        LZWDecompress.decompress(compressedFile, decompressedFile);
    }
}
