import gen.converterLexer;
import gen.converterParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Generator {
    public static void main(String [] args) throws Exception
    {
        for (int i = 1; i < 4; ++i) {
            CharStream input = CharStreams.fromFileName(String.format("/home/ukasz/IdeaProjects/javaToCpp/javaTestFile%d.java", (int) i));
            converterLexer lexer = new converterLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            converterParser parser = new converterParser(tokens);

            ParseTree tree = parser.startCompilation();
            ParseTreeWalker walker = new ParseTreeWalker();
            MyConverter listener = new MyConverter(String.format("testResult%d.cpp", (int)i));
            walker.walk(listener, tree);
            listener.close();
        }
    }
}