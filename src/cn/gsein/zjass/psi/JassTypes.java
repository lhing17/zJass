// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import cn.gsein.zjass.grammer.JassElementType;
import cn.gsein.zjass.grammer.JassTokenType;
import cn.gsein.zjass.psi.impl.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface JassTypes {

  IElementType ASSIGN_STATEMENT = new JassElementType("ASSIGN_STATEMENT");
  IElementType BOOL_EXPR = new JassElementType("BOOL_EXPR");
  IElementType CALL_STATEMENT = new JassElementType("CALL_STATEMENT");
  IElementType COMMENT = new JassElementType("COMMENT");
  IElementType COMPOUND_STATMENT = new JassElementType("COMPOUND_STATMENT");
  IElementType CONDITION_STATEMENT = new JassElementType("CONDITION_STATEMENT");
  IElementType EMPTY = new JassElementType("EMPTY");
  IElementType FACTOR = new JassElementType("FACTOR");
  IElementType FUNC = new JassElementType("FUNC");
  IElementType FUNC_CALL = new JassElementType("FUNC_CALL");
  IElementType FUNC_DEF = new JassElementType("FUNC_DEF");
  IElementType FUNC_NAME = new JassElementType("FUNC_NAME");
  IElementType GLOBAL_BLOCK = new JassElementType("GLOBAL_BLOCK");
  IElementType GLOBAL_DECL = new JassElementType("GLOBAL_DECL");
  IElementType LOCAL_DEF = new JassElementType("LOCAL_DEF");
  IElementType LOOP_STATEMENT = new JassElementType("LOOP_STATEMENT");
  IElementType NATIVE_DEF = new JassElementType("NATIVE_DEF");
  IElementType NUMBER_EXPR = new JassElementType("NUMBER_EXPR");
  IElementType RETURN_STATEMENT = new JassElementType("RETURN_STATEMENT");
  IElementType STRING_EXPR = new JassElementType("STRING_EXPR");
  IElementType TERM = new JassElementType("TERM");
  IElementType TYPE_DEF = new JassElementType("TYPE_DEF");
  IElementType VAR_NAME = new JassElementType("VAR_NAME");
  IElementType VAR_TYPE = new JassElementType("VAR_TYPE");
  IElementType VAR_VALUE = new JassElementType("VAR_VALUE");

  IElementType ARRAY = new JassTokenType("ARRAY");
  IElementType CALL = new JassTokenType("CALL");
  IElementType COLON = new JassTokenType("COLON");
  IElementType CONSTANT = new JassTokenType("CONSTANT");
  IElementType DIV = new JassTokenType("DIV");
  IElementType DOUBLE_EQ = new JassTokenType("DOUBLE_EQ");
  IElementType DOUBLE_QUOTE = new JassTokenType("DOUBLE_QUOTE");
  IElementType ELSE = new JassTokenType("ELSE");
  IElementType ELSEIF = new JassTokenType("ELSEIF");
  IElementType ENDFUNCTION = new JassTokenType("ENDFUNCTION");
  IElementType ENDGLOBALS = new JassTokenType("ENDGLOBALS");
  IElementType ENDIF = new JassTokenType("ENDIF");
  IElementType ENDLOOP = new JassTokenType("ENDLOOP");
  IElementType EOL_COMMENT = new JassTokenType("EOL_COMMENT");
  IElementType EQ = new JassTokenType("EQ");
  IElementType EXITWHEN = new JassTokenType("EXITWHEN");
  IElementType EXPR = new JassTokenType("expr");
  IElementType EXTENDS = new JassTokenType("EXTENDS");
  IElementType FUNCTION = new JassTokenType("FUNCTION");
  IElementType GE = new JassTokenType("GE");
  IElementType GLOBALS = new JassTokenType("GLOBALS");
  IElementType GT = new JassTokenType("GT");
  IElementType ID = new JassTokenType("ID");
  IElementType IF = new JassTokenType("IF");
  IElementType INTEGER_LITERAL = new JassTokenType("INTEGER_LITERAL");
  IElementType LE = new JassTokenType("LE");
  IElementType LOCAL = new JassTokenType("LOCAL");
  IElementType LOOP = new JassTokenType("LOOP");
  IElementType LPAREN = new JassTokenType("LPAREN");
  IElementType LT = new JassTokenType("LT");
  IElementType MINUS = new JassTokenType("MINUS");
  IElementType MUL = new JassTokenType("MUL");
  IElementType MUL_COMMENT = new JassTokenType("MUL_COMMENT");
  IElementType NATIVE = new JassTokenType("NATIVE");
  IElementType NOT = new JassTokenType("NOT");
  IElementType NOTHING = new JassTokenType("NOTHING");
  IElementType NULL = new JassTokenType("NULL");
  IElementType PLUS = new JassTokenType("PLUS");
  IElementType REAL_LITERAL = new JassTokenType("REAL_LITERAL");
  IElementType RETURN = new JassTokenType("RETURN");
  IElementType RETURNS = new JassTokenType("RETURNS");
  IElementType RPAREN = new JassTokenType("RPAREN");
  IElementType SET = new JassTokenType("SET");
  IElementType STRING_CONST = new JassTokenType("STRING_CONST");
  IElementType TAKES = new JassTokenType("TAKES");
  IElementType THEN = new JassTokenType("THEN");
  IElementType TYPE = new JassTokenType("TYPE");
  IElementType TYPE_ID = new JassTokenType("TYPE_ID");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGN_STATEMENT) {
        return new JassAssignStatementImpl(node);
      }
      else if (type == BOOL_EXPR) {
        return new JassBoolExprImpl(node);
      }
      else if (type == CALL_STATEMENT) {
        return new JassCallStatementImpl(node);
      }
      else if (type == COMMENT) {
        return new JassCommentImpl(node);
      }
      else if (type == COMPOUND_STATMENT) {
        return new JassCompoundStatmentImpl(node);
      }
      else if (type == CONDITION_STATEMENT) {
        return new JassConditionStatementImpl(node);
      }
      else if (type == EMPTY) {
        return new JassEmptyImpl(node);
      }
      else if (type == FACTOR) {
        return new JassFactorImpl(node);
      }
      else if (type == FUNC) {
        return new JassFuncImpl(node);
      }
      else if (type == FUNC_CALL) {
        return new JassFuncCallImpl(node);
      }
      else if (type == FUNC_DEF) {
        return new JassFuncDefImpl(node);
      }
      else if (type == FUNC_NAME) {
        return new JassFuncNameImpl(node);
      }
      else if (type == GLOBAL_BLOCK) {
        return new JassGlobalBlockImpl(node);
      }
      else if (type == GLOBAL_DECL) {
        return new JassGlobalDeclImpl(node);
      }
      else if (type == LOCAL_DEF) {
        return new JassLocalDefImpl(node);
      }
      else if (type == LOOP_STATEMENT) {
        return new JassLoopStatementImpl(node);
      }
      else if (type == NATIVE_DEF) {
        return new JassNativeDefImpl(node);
      }
      else if (type == NUMBER_EXPR) {
        return new JassNumberExprImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new JassReturnStatementImpl(node);
      }
      else if (type == STRING_EXPR) {
        return new JassStringExprImpl(node);
      }
      else if (type == TERM) {
        return new JassTermImpl(node);
      }
      else if (type == TYPE_DEF) {
        return new JassTypeDefImpl(node);
      }
      else if (type == VAR_NAME) {
        return new JassVarNameImpl(node);
      }
      else if (type == VAR_TYPE) {
        return new JassVarTypeImpl(node);
      }
      else if (type == VAR_VALUE) {
        return new JassVarValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
