import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Generator {
    public static void main(String [] args) throws Exception
    {
        CharStream input = CharStreams.fromFileName("/home/ukasz/IdeaProjects/javaToCpp/src/main/java/test.java");
        converterLexer lexer = new converterLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        converterParser parser = new converterParser(tokens);

        ParseTree tree = parser.startCompilation();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyConverter listener = new MyConverter("test.cpp");
        walker.walk(listener, tree);
        listener.close();
    }
}