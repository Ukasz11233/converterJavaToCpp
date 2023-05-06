import org.antlr.v4.runtime.ParserRuleContext;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MyConverter extends converterBaseListener {
    private PrintWriter file;
    private Map<String, Integer> accessIndex;
    private ArrayList<String> privateFields;

    private ArrayList<String> publicFields;
    private ArrayList<String> protectedFields;
    private String currentField;
    public MyConverter(String outputFilePath) throws IOException
    {
        file = new PrintWriter(new FileWriter(outputFilePath));
        accessIndex = new HashMap<String, Integer>();
        accessIndex.put("private", 0);
        accessIndex.put("protected", 0);
        accessIndex.put("public", 0);
        privateFields = new ArrayList<String>();
        publicFields = new ArrayList<String>();
        protectedFields = new ArrayList<String>();
    }
    protected void close()
    {
        file.close();
    }

    private String getOriginalString(int currIdx)
    {
        String result = "";
        if(currentField.equals("private"))
        {
            result = privateFields.get(currIdx);
        }
        else if(currentField.equals("public"))
        {
            result = publicFields.get(currIdx);
        } else if (currentField.equals("protected"))
        {
            result = protectedFields.get(currIdx);
        }
        return result;
    }

    private void modifyFiled(int currIdx, String originalString)
    {
        if(currentField.equals("private"))
        {
            privateFields.set(currIdx, originalString);
        }
        else if(currentField.equals("public"))
        {
            publicFields.set(currIdx, originalString);
        }
        else if(currentField.equals("protected"))
        {
            protectedFields.set(currIdx, originalString);
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("Entering " + ctx.getClass().getSimpleName() + ": " + ctx.getText());
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        System.out.println("Exiting " + ctx.getClass().getSimpleName() + ": " + ctx.getText());
    }

    @Override
    public void enterClassDeclaration(converterParser.ClassDeclarationContext ctx) {
        String className = ctx.Identifier().getText();
        file.println("class " + className + " {");
    }

    @Override
    public void exitClassDeclaration(converterParser.ClassDeclarationContext ctx) {
        file.println("private:");
        for(String el : privateFields)
        {
            file.println("  " + el);
        }
        file.println("protected:");
        for(String el : protectedFields)
        {
            file.println("  " + el);
        }
        file.println("public:");
        for(String el : publicFields)
        {
            file.println("  " + el);
        }
        file.println("}");
    }

    @Override
    public void enterFieldDeclaration(converterParser.FieldDeclarationContext ctx) {
        currentField = ctx.accessModifier().getText();
    }

    @Override
    public void enterMethodDeclaration(converterParser.MethodDeclarationContext ctx) {
        currentField = ctx.accessModifier().getText();
    }

    @Override
    public void exitFieldDeclaration(converterParser.FieldDeclarationContext ctx) {
        int value = accessIndex.get(currentField);
        accessIndex.put(currentField, ++value);
    }

    @Override
    public void enterAccessModifier(converterParser.AccessModifierContext ctx) {
        if(currentField.equals("private")) {
            privateFields.add("");
        }
        else if(currentField.equals("public"))
        {
            publicFields.add("");
        }
        else if(currentField.equals("protected"))
        {
            protectedFields.add("");
        }
    }

    @Override
    public void enterType(converterParser.TypeContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        if(ctx.getText().equals("boolean"))
        {
            originalString += "bool ";
        }
        else
        {
            originalString += ctx.getText().toLowerCase() + " ";
        }
        modifyFiled(currentIndex, originalString);
    }

    @Override
    public void enterVariableDeclarator(converterParser.VariableDeclaratorContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += ctx.Identifier().toString();
        modifyFiled(currentIndex, originalString);
    }

    @Override
    public void enterExpression(converterParser.ExpressionContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += "=";
        modifyFiled(currentIndex, originalString);
    }

    @Override
    public void enterLiteral(converterParser.LiteralContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += ctx.getText();
        modifyFiled(currentIndex, originalString);
    }

    @Override
    public void exitLocalVariableDeclarationStatement(converterParser.LocalVariableDeclarationStatementContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += ";";
        modifyFiled(currentIndex, originalString);
    }
}