package cn.gsein.zjass.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static cn.gsein.zjass.psi.JassTypes.*;

%%

%{
  public _JassLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class JassLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+
DIGITS=\$?[0-9A-F]+
REAL_LITERAL=\d+(\.\d*)?
STRING_LITERAL=[^\"]*s
EOL_COMMENT=\/\/.*
MUL_COMMENT="/*" [^*] ~"*/" | "/*" "*"+ "/"
ID=[a-zA-Z_]\w*
TYPEID=integer|real|string|timer|timerdialog|trigger|unit|location|player|event|boolean|texttag|item|group

%state WAITING_STRING

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

    {TYPEID}    {return TYPE_ID;}
  "globals"          { return GLOBALS; }
  "endglobals"       { return ENDGLOBALS; }
  "constant"         { return CONSTANT; }
  "array"            { return ARRAY; }
  "="               { return EQ; }

  {DIGITS}    { return INTEGER_LITERAL; }
  {REAL_LITERAL}       { return REAL_LITERAL; }
  "+"             { return PLUS; }
  "null"             { return NULL; }
  "\""     { yybegin(WAITING_STRING); return DOUBLE_QUOTE; }
  "-"            { return MINUS; }
  "*"              { return MUL; }
  "/"              { return DIV; }
  "("           { return LPAREN; }
  ")"           { return RPAREN; }
  ","            { return COLON; }
  "#"            { return NUMBER_SIGN; }
  "include"  {return INCLUDE;}
  "type"             { return TYPE; }
  "extends"          { return EXTENDS; }
  "native"           { return NATIVE; }
  "takes"            { return TAKES; }
  "nothing"          { return NOTHING; }
  "returns"          { return RETURNS; }
  "endfunction"      { return ENDFUNCTION; }
  "function"         { return FUNCTION; }
  "local"            { return LOCAL; }
  "call"             { return CALL; }
  "set"              { return SET; }
  "if"               { return IF; }
  "then"             { return THEN; }
  "elseif"           { return ELSEIF; }
  "else"             { return ELSE; }
  "endif"            { return ENDIF; }
  "not"            { return NOT; }
  ">"               { return GT; }
  "=="        { return DOUBLE_EQ; }
  "<"               { return LT; }
  "<="               { return LE; }
  ">="               { return GE; }
  "loop"             { return LOOP; }
  "exitwhen"         { return EXITWHEN; }
  "endloop"          { return ENDLOOP; }
  "return"           { return RETURN; }
  {EOL_COMMENT}      { return EOL_COMMENT; }
  {MUL_COMMENT}      { return MUL_COMMENT; }
    {ID}               { return ID; }
}
<WAITING_STRING> {
  "\""     { yybegin(YYINITIAL); return DOUBLE_QUOTE; }
  {STRING_LITERAL}     { return STRING_LITERAL; }
}

[^] { return BAD_CHARACTER; }
