grammar converter;

// Pliki programu
startCompilation : classDeclaration+;

// Deklaracje klasy
classDeclaration : 'class' Identifier classBody;
classBody : '{' classBodyDeclaration* '}';

// Deklaracje zmiennych
classBodyDeclaration : fieldDeclaration | methodDeclaration;
fieldDeclaration : (accessModifier)? statement;
accessModifier : 'public' | 'private' | 'protected';

// Deklaracje metod
methodDeclaration : (accessModifier)? ('static')? type Identifier '(' (formalParameter (',' formalParameter)*)? ')' methodBody;
formalParameter : type Identifier;
methodBody : '{' statement* ('return' expression ';')? '}';

// Typy danych
type : ('int' | 'float' | 'boolean' | 'String') arrayType?;
arrayType : '[' ']';
arrayInitializer : '{' (expression (',' expression)*)? '}';

// Instrukcje warunkowe i pętle
statement : block | ifStatement | whileStatement | forStatement | expressionStatement | localVariableDeclarationStatement;
block : '{' statement* '}';
ifStatement : 'if' '(' expression ')' statement ('else' statement)?;
whileStatement : 'while' '(' expression ')' statement;
forStatement : 'for' '(' forControl ')' statement;
forControl : (forInit)? ';' expression? ';' expressionList?;
forInit : localVariableDeclarationStatement | expressionList;
localVariableDeclarationStatement : type variableDeclarators ';';
variableDeclarators : variableDeclarator (',' variableDeclarator)*;
variableDeclarator : Identifier arrayType? ('=' expression | arrayInitializer)?;
expressionStatement
    : expression ';'
    ;
expressionList
    : expression (',' expression)*
    ;
// Wyrażenia i operatory
expression : primary | expression ('+'|'-'|'*'|'/'|'%'|'&&'|'||'|'=='|'!='|'<'|'>'|'<='|'>=' | '=') expression;
primary : literal | Identifier | '(' expression ')' | arrayAccess;
arrayAccess : Identifier '[' expression ']';
literal : IntegerLiteral | FloatingPointLiteral | BooleanLiteral | CharacterLiteral | StringLiteral | NullLiteral;

// Tokeny
IntegerLiteral : ('0' | [1-9][0-9]*);
FloatingPointLiteral : [0-9]* '.' [0-9]+;
BooleanLiteral : 'true' | 'false';
CharacterLiteral : '\'' ( EscapeSequence | ~['\\] ) '\'';
StringLiteral : '"' ( EscapeSequence | ~["\\] )* '"';
NullLiteral : 'null';
EscapeSequence
    : '\\' [btnfr"'\\]
    ;

// Tokeny pomocnicze
Identifier : JavaLetter JavaLetterOrDigit*;
JavaLetter : [a-zA-Z_$];
JavaLetterOrDigit : [a-zA-Z0-9_$];

// Ignorowanie białych znaków i komentarzy
WS : [ \t\r\n]+ -> skip;
COMMENT : '/*' .*? '*/' -> skip;
