package gen;// Generated from /home/ukasz/IdeaProjects/javaToCpp/converter.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link converterParser}.
 */
public interface converterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link converterParser#startCompilation}.
	 * @param ctx the parse tree
	 */
	void enterStartCompilation(converterParser.StartCompilationContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#startCompilation}.
	 * @param ctx the parse tree
	 */
	void exitStartCompilation(converterParser.StartCompilationContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(converterParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(converterParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(converterParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(converterParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(converterParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(converterParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(converterParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(converterParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(converterParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(converterParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(converterParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(converterParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(converterParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(converterParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(converterParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(converterParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(converterParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(converterParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(converterParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(converterParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(converterParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(converterParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(converterParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(converterParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(converterParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(converterParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(converterParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(converterParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(converterParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(converterParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(converterParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(converterParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(converterParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(converterParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(converterParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(converterParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(converterParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(converterParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(converterParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(converterParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(converterParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(converterParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(converterParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(converterParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(converterParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(converterParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(converterParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(converterParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(converterParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(converterParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(converterParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(converterParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link converterParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(converterParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link converterParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(converterParser.LiteralContext ctx);
}