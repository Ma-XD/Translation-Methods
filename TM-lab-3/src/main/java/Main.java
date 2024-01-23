import gen.*;
import org.antlr.v4.runtime.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    private static final String INPUT_PATH = "src/main/resources";
    private static final String PYTHON_PATH = "src/main/python";

    public static void main(String[] args) {
        Path fi = Path.of(INPUT_PATH, "long.txt");
        Path fo = Path.of(PYTHON_PATH, "main.py");

        try (InputStream is = Files.newInputStream(fi)) {
            PrefixExprLexer lexer = new PrefixExprLexer(CharStreams.fromStream(is));
            PrefixExprParser parser = new PrefixExprParser(new CommonTokenStream(lexer));
            String source = parser.run().value;

            try (BufferedWriter bw = Files.newBufferedWriter(fo)){
                bw.write(source);
                bw.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}