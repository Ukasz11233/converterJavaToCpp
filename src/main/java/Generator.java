import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generator {
    public static void main(String [] args) throws Exception
    {
        CharStream input = CharStreams.fromFileName("/home/ukasz/IdeaProjects/javaToCpp/src/main/java/test.java");
        converterLexer lexer = new converterLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        converterParser parser = new converterParser(tokens);

        ParseTree tree = parser.startCompilation();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener listener = new MyListener("test.cpp");
        walker.walk(listener, tree);
    }
}

class MyListener extends converterBaseListener {
    private PrintWriter file;
    public MyListener(String outputFilePath) throws IOException
    {
        file = new PrintWriter(new FileWriter(outputFilePath));
    }
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("Entering " + ctx.getClass().getSimpleName() + ": " + ctx.getText());
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        System.out.println("Exiting " + ctx.getClass().getSimpleName() + ": " + ctx.getText());
    }
}