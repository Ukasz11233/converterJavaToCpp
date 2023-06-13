package gen;// Generated from /home/ukasz/IdeaProjects/javaToCpp/converter.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link converterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface converterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link converterParser#startCompilation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartCompilation(converterParser.StartCompilationContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(converterParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(converterParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(converterParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(converterParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#accessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessModifier(converterParser.AccessModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(converterParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(converterParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(converterParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(converterParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(converterParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(converterParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(converterParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(converterParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(converterParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(converterParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(converterParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(converterParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(converterParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(converterParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(converterParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(converterParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(converterParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(converterParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(converterParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(converterParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(converterParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link converterParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(converterParser.LiteralContext ctx);
}