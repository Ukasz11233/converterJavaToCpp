import org.antlr.v4.runtime.ParserRuleContext;

import java.awt.image.AreaAveragingScaleFilter;
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
    private ArrayList<String> formalParameters;

    private ArrayList<String> publicFields;
    private ArrayList<String> protectedFields;
    String methodBodyStatement;
    private String currentField;
    private Boolean isLocalVariableDeclarationInMethod;
    private Boolean isInFormalParameter;
    private Boolean doesFieldDeclarationContainStatic;
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
        formalParameters = new ArrayList<String>();
        isLocalVariableDeclarationInMethod = false;
        isInFormalParameter = false;
        doesFieldDeclarationContainStatic = false;
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
        if(ctx.getText().contains("static"))
        {
            doesFieldDeclarationContainStatic = true;
        }
    }

    @Override
    public void exitFieldDeclaration(converterParser.FieldDeclarationContext ctx) {
        int value = accessIndex.get(currentField);
        accessIndex.put(currentField, ++value);
        doesFieldDeclarationContainStatic = false;
    }

    private String getMethodType(String ctx)
    {
        String result = "";
        if (ctx.contains("void")) {
            result = "void";
        } else if (ctx.contains("int")) {
            result = "int";
        } else if (ctx.contains("float")) {
            result = "float";
        }
        else if(ctx.contains("boolean")) {
            result = "bool";
        } else if (ctx.contains("String")) {
            result = "string";
        }
        return result;
    }
    @Override
    public void enterMethodDeclaration(converterParser.MethodDeclarationContext ctx) {
        isLocalVariableDeclarationInMethod = true;
        currentField = ctx.accessModifier().getText();
        System.out.println(ctx.getText());
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
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        if(ctx.getText().contains("static"))
        {
            originalString += "static ";
        }
        originalString += getMethodType(ctx.getText()) + " ";
        originalString += ctx.Identifier().toString() + "(";
        System.out.println("shacoofdsfds  " + originalString);
        modifyFiled(currentIndex, originalString);
    }

    @Override
    public void enterFormalParameter(converterParser.FormalParameterContext ctx) {
        isInFormalParameter = true;
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        System.out.println("enterFormal " + originalString);
        if(! originalString.contains(")") && !(Character.compare(originalString.charAt(originalString.length()-1), '(') == 0))
        {
            originalString  += ", ";
            System.out.println("xXXXXXXXXXXXXXX " + originalString);
            System.out.println("xXXXXXXXXXXXXXX " + originalString.charAt(originalString.length()-1));

        }
        else
        {
//            originalString += "(";
        }
        modifyFiled(currentIndex, originalString);
    }

    @Override
    public void exitFormalParameter(converterParser.FormalParameterContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += ctx.Identifier().toString();
        modifyFiled(currentIndex, originalString);
        isInFormalParameter = false;
    }

    @Override
    public void exitMethodDeclaration(converterParser.MethodDeclarationContext ctx) {
        int value = accessIndex.get(currentField);
        accessIndex.put(currentField, ++value);
        isLocalVariableDeclarationInMethod = false;
    }

    @Override
    public void enterMethodBody(converterParser.MethodBodyContext ctx) {
        methodBodyStatement = "";

        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += ")";
        methodBodyStatement += "{\n\t";
        modifyFiled(currentIndex, originalString);

    }

    @Override
    public void exitMethodBody(converterParser.MethodBodyContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += methodBodyStatement;
        if(ctx.getText().contains("return"))
        {
            originalString += "return " + ctx.expression().getText() + ";\n\t";
        }
        originalString += "}";
        //System.out.println("############## " + ctx.expression().getText());
        //System.out.println("############## " + ctx.getText());
        modifyFiled(currentIndex, originalString);
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
        if (doesFieldDeclarationContainStatic) {
            originalString += "static ";
        }
        if(ctx.getText().equals("boolean"))
        {
            originalString += "bool ";
        }
        else
        {
            originalString += ctx.getText().toLowerCase() + " ";
        }
        if (!isLocalVariableDeclarationInMethod || isInFormalParameter) {
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override
    public void enterLocalVariableDeclarationStatement(converterParser.LocalVariableDeclarationStatementContext ctx) {
        if(isLocalVariableDeclarationInMethod) {
            methodBodyStatement += ctx.type().getText() + " ";
        }
    }
    @Override
    public void enterVariableDeclarator(converterParser.VariableDeclaratorContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        if (isLocalVariableDeclarationInMethod) {
            methodBodyStatement += ctx.getText() + ";\n\t";
        } else {
            originalString += ctx.Identifier().toString();
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override
    public void enterExpression(converterParser.ExpressionContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += "=";
        if (isLocalVariableDeclarationInMethod) {
                ;
        } else {
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override
    public void enterLiteral(converterParser.LiteralContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += ctx.getText();
        if (isLocalVariableDeclarationInMethod) {
            ;
        } else {
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override
    public void exitLocalVariableDeclarationStatement(converterParser.LocalVariableDeclarationStatementContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += ";\n\t";
        if (isLocalVariableDeclarationInMethod) {
                ;
        } else {
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override
    public void enterExpressionStatement(converterParser.ExpressionStatementContext ctx) {
        methodBodyStatement += ctx.getText() + "\n\t";

    }

    @Override public void enterIfStatement(converterParser.IfStatementContext ctx){
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        String exp = ctx.expression().getText();
        if (isLocalVariableDeclarationInMethod) {
            methodBodyStatement += "if (" + exp +")";
        } else {
            originalString += "if (";
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override public void enterBlock(converterParser.BlockContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += "{\n\t";
        if (isLocalVariableDeclarationInMethod) {
            methodBodyStatement += "{\n\t";
        } else {
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override public void exitBlock(converterParser.BlockContext ctx) {
        int currentIndex = accessIndex.get(currentField);
        String originalString = getOriginalString(currentIndex);
        originalString += "}";
        if (isLocalVariableDeclarationInMethod) {
            methodBodyStatement += "}";
        } else {
            modifyFiled(currentIndex, originalString);
        }
    }

    @Override
    public void enterWhileStatement(converterParser.WhileStatementContext ctx) {
        methodBodyStatement += "while (" + ctx.expression().getText() + ")";
    }

    @Override
    public void enterForStatement(converterParser.ForStatementContext ctx){
        methodBodyStatement += "for";
    }

    @Override
    public void enterForControl(converterParser.ForControlContext ctx){
        methodBodyStatement += "(";

    }
    public void exitForControl(converterParser.ForControlContext ctx){
        methodBodyStatement += ctx.expression().getText() +";"+ ctx.expressionList().getText()+")";
    }
}