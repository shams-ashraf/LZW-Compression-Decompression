# LZW Compression and Decompression

This project implements the LZW compression and decompression algorithms in Java.

## Overview

- The `LZWCompress` class reads an input file, compresses its content using the LZW algorithm, and writes the compressed codes to an output file. It also saves the generated dictionary to a separate file.
- The `LZWDecompress` class reads the compressed codes from a file and reconstructs the original content, writing it to a decompressed output file.
- The `Main` class demonstrates a simple usage example that compresses and then decompresses a file.

## Files

- `LZWCompress.java`: Contains the compression logic.
- `LZWDecompress.java`: Contains the decompression logic.
- `Main.java`: Runs compression and decompression in sequence.
- `input.txt`: The file to be compressed.
- `compressed.txt`: The output file for compressed data.
- `decompressed.txt`: The output file for decompressed data.
- `dictionary.txt`: Stores the dictionary built during compression.
