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

WHITE_SPACE=\s+
REAL_LITERAL=\d+(\.\d*) | \.\d+
ID_INT_LITERAL = \'([\u0000-\u0026\u0028-\u00FF]+)\'
DEC_INT_LITERAL = [1-9]\d* | \d
OCT_INT_LITERAL = 0[0-7]*
HEX_INT_LITERAL = (0[xX] | \$)[0-9a-fA-F]+
STRING_LITERAL= \"(\\[abfnrtvz\"'\\] | [^\\\"\r\n])*\"
BOOL_LITERAL=true|false
EOL_COMMENT=\/\/.*
MUL_COMMENT="/*" [^*] ~"*/" | "/*" "*"+ "/"
ID=[a-zA-Z_]\w*

%state WAITING_STRING

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "globals"          { return GLOBALS; }
  "endglobals"       { return ENDGLOBALS; }
  "constant"         { return CONSTANT; }
  "array"            { return ARRAY; }
  "="               { return ASSIGN_OP; }

  {ID_INT_LITERAL}    { return ID_INT_LITERAL; }
  {DEC_INT_LITERAL}    { return DEC_INT_LITERAL; }
  {OCT_INT_LITERAL}    { return OCT_INT_LITERAL; }
  {HEX_INT_LITERAL}    { return HEX_INT_LITERAL; }
  {REAL_LITERAL}       { return REAL_LITERAL; }
  {BOOL_LITERAL}       { return BOOL_LITERAL; }
  {STRING_LITERAL}       { return STRING_LITERAL; }
  "+"             { return PLUS; }
  "null"             { return NULL; }
  //"\""     { yybegin(WAITING_STRING); return DOUBLE_QUOTE; }
  "-"            { return MINUS; }
  "*"              { return MUL; }
  "/"              { return DIV; }
  "%"              { return MOD; }
  "("           { return LPAREN; }
  ")"           { return RPAREN; }
  ","            { return COMMA; }
  "["            { return LBRACKET; }
  "]"            { return RBRACKET; }
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
  "and"            { return AND; }
  "or"            { return OR; }
  ">"               { return GREATER; }
  "=="        { return EQUAL; }

  "!="        { return UNEQUAL; }
  "<"               { return LESS; }
  "<="               { return LESS_EQUAL; }
  ">="               { return GREATER_EQUAL; }
  "loop"             { return LOOP; }
  "exitwhen"         { return EXITWHEN; }
  "endloop"          { return ENDLOOP; }
  "return"           { return RETURN; }
  "debug"           { return DEBUG; }
  {EOL_COMMENT}      { return EOL_COMMENT; }
  {MUL_COMMENT}      { return MUL_COMMENT; }
    {ID}               { return ID; }
}
/*<WAITING_STRING> {
  "\""     { yybegin(YYINITIAL); return DOUBLE_QUOTE; }
  {STRING_LITERAL}     { return STRING_LITERAL; }
}*/

[^] { return BAD_CHARACTER; }
