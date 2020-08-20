package de.fmantz.hannover.strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Even Java has bugs in its libraries:
 * https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4508058 (won't fix to not breaking existing applications!)
 */
public class JavaBomBug {

    public static void main(String args[]) throws Exception {
        String path = JavaBomBug.class.getResource("/").toURI().getPath();
        printFile(path + "/Test-UTF8.txt"); //Fälschlicherweise wird das UTF-8 Byte-Order-Mark in Java nicht richtig erkannt!
        printFile(path + "/Test-UTF8-Without-BOM.txt");
    }

    /**
     * Read a file and print its contents to the console
     */
    private static void printFile(String fileName) throws IOException {
        try (BufferedReader myReader = new BufferedReader(
                new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line = null;
            while ((line = myReader.readLine()) != null) {
                System.out.println("|" + line + "| length=" + line.length());
            }
        }
    }
}
