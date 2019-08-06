// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import cn.gsein.zjass.grammer.JassElementType;
import cn.gsein.zjass.grammer.JassTokenType;
import cn.gsein.zjass.psi.impl.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface JassTypes {

  IElementType ANY_EXPR_ATOM = new JassElementType("ANY_EXPR_ATOM");
  IElementType ARG_LIST = new JassElementType("ARG_LIST");
  IElementType ARRAY_READ = new JassElementType("ARRAY_READ");
  IElementType BOOL_ATOM = new JassElementType("BOOL_ATOM");
  IElementType BOOL_BOOL_RELATION = new JassElementType("BOOL_BOOL_RELATION");
  IElementType BOOL_CODE_RELATION = new JassElementType("BOOL_CODE_RELATION");
  IElementType BOOL_EXPR = new JassElementType("BOOL_EXPR");
  IElementType BOOL_FULL_RELATION = new JassElementType("BOOL_FULL_RELATION");
  IElementType BOOL_HANDLE_RELATION = new JassElementType("BOOL_HANDLE_RELATION");
  IElementType BOOL_MAYBE_CONJUNCT = new JassElementType("BOOL_MAYBE_CONJUNCT");
  IElementType BOOL_MAYBE_DISJUNCT = new JassElementType("BOOL_MAYBE_DISJUNCT");
  IElementType BOOL_MAYBE_FULL_RELATION = new JassElementType("BOOL_MAYBE_FULL_RELATION");
  IElementType BOOL_MAYBE_NUM_ORDER_RELATION = new JassElementType("BOOL_MAYBE_NUM_ORDER_RELATION");
  IElementType BOOL_MAYBE_UNARY = new JassElementType("BOOL_MAYBE_UNARY");
  IElementType BOOL_NULL_RELATION = new JassElementType("BOOL_NULL_RELATION");
  IElementType BOOL_NUM_ORDER_RELATION = new JassElementType("BOOL_NUM_ORDER_RELATION");
  IElementType BOOL_NUM_ORDER_RELATION_OP = new JassElementType("BOOL_NUM_ORDER_RELATION_OP");
  IElementType BOOL_NUM_RELATION = new JassElementType("BOOL_NUM_RELATION");
  IElementType BOOL_PARENS = new JassElementType("BOOL_PARENS");
  IElementType BOOL_RELATION_OP = new JassElementType("BOOL_RELATION_OP");
  IElementType BOOL_STRING_RELATION = new JassElementType("BOOL_STRING_RELATION");
  IElementType CALL_STATEMENT = new JassElementType("CALL_STATEMENT");
  IElementType CODE_EXPR = new JassElementType("CODE_EXPR");
  IElementType CODE_LITERAL = new JassElementType("CODE_LITERAL");
  IElementType CODE_PARENS = new JassElementType("CODE_PARENS");
  IElementType COMMENT = new JassElementType("COMMENT");
  IElementType CONDITION = new JassElementType("CONDITION");
  IElementType CONDITION_STATEMENT = new JassElementType("CONDITION_STATEMENT");
  IElementType DEBUG_STATEMENT = new JassElementType("DEBUG_STATEMENT");
  IElementType EXITWHEN_STATEMENT = new JassElementType("EXITWHEN_STATEMENT");
  IElementType EXPR = new JassElementType("EXPR");
  IElementType FUNC = new JassElementType("FUNC");
  IElementType FUNC_BODY = new JassElementType("FUNC_BODY");
  IElementType FUNC_CALL = new JassElementType("FUNC_CALL");
  IElementType FUNC_DECL = new JassElementType("FUNC_DECL");
  IElementType FUNC_NAME = new JassElementType("FUNC_NAME");
  IElementType FUNC_PARAM = new JassElementType("FUNC_PARAM");
  IElementType FUNC_PARM_LIST = new JassElementType("FUNC_PARM_LIST");
  IElementType FUNC_REF = new JassElementType("FUNC_REF");
  IElementType FUNC_RETURN_TYPE = new JassElementType("FUNC_RETURN_TYPE");
  IElementType GLOBAL_BLOCK = new JassElementType("GLOBAL_BLOCK");
  IElementType GLOBAL_DECL = new JassElementType("GLOBAL_DECL");
  IElementType HANDLE_EXPR = new JassElementType("HANDLE_EXPR");
  IElementType HANDLE_LITERAL = new JassElementType("HANDLE_LITERAL");
  IElementType HANDLE_PARENS = new JassElementType("HANDLE_PARENS");
  IElementType INCLUDE_STATEMENT = new JassElementType("INCLUDE_STATEMENT");
  IElementType INT_ATOM = new JassElementType("INT_ATOM");
  IElementType INT_EXPR = new JassElementType("INT_EXPR");
  IElementType INT_LITERAL = new JassElementType("INT_LITERAL");
  IElementType INT_MAYBE_PROD = new JassElementType("INT_MAYBE_PROD");
  IElementType INT_MAYBE_SUM = new JassElementType("INT_MAYBE_SUM");
  IElementType INT_MAYBE_UNARY = new JassElementType("INT_MAYBE_UNARY");
  IElementType INT_PARENS = new JassElementType("INT_PARENS");
  IElementType LOCAL_VAR_DECL = new JassElementType("LOCAL_VAR_DECL");
  IElementType LOCAL_VAR_DECL_LIST = new JassElementType("LOCAL_VAR_DECL_LIST");
  IElementType LOOP_BODY = new JassElementType("LOOP_BODY");
  IElementType LOOP_STATEMENT = new JassElementType("LOOP_STATEMENT");
  IElementType NATIVE_DECL = new JassElementType("NATIVE_DECL");
  IElementType NULL_EXPR = new JassElementType("NULL_EXPR");
  IElementType NULL_LITERAL = new JassElementType("NULL_LITERAL");
  IElementType NULL_PARENS = new JassElementType("NULL_PARENS");
  IElementType NUMBER_EXPR = new JassElementType("NUMBER_EXPR");
  IElementType NUM_PROD_OP = new JassElementType("NUM_PROD_OP");
  IElementType NUM_SUM_OP = new JassElementType("NUM_SUM_OP");
  IElementType NUM_UNARY_OP = new JassElementType("NUM_UNARY_OP");
  IElementType REAL_ATOM = new JassElementType("REAL_ATOM");
  IElementType REAL_EXPR = new JassElementType("REAL_EXPR");
  IElementType REAL_MAYBE_PROD = new JassElementType("REAL_MAYBE_PROD");
  IElementType REAL_MAYBE_SUM = new JassElementType("REAL_MAYBE_SUM");
  IElementType REAL_MAYBE_UNARY = new JassElementType("REAL_MAYBE_UNARY");
  IElementType REAL_PARENS = new JassElementType("REAL_PARENS");
  IElementType RULE_RETURN = new JassElementType("RULE_RETURN");
  IElementType SELECTION_ELSEIF_BRANCH = new JassElementType("SELECTION_ELSEIF_BRANCH");
  IElementType SELECTION_ELSE_BRANCH = new JassElementType("SELECTION_ELSE_BRANCH");
  IElementType SET_VAR = new JassElementType("SET_VAR");
  IElementType STATEMENT = new JassElementType("STATEMENT");
  IElementType STATEMENT_LIST = new JassElementType("STATEMENT_LIST");
  IElementType STRING_ATOM = new JassElementType("STRING_ATOM");
  IElementType STRING_CONCAT_OP = new JassElementType("STRING_CONCAT_OP");
  IElementType STRING_EXPR = new JassElementType("STRING_EXPR");
  IElementType STRING_LITERALS = new JassElementType("STRING_LITERALS");
  IElementType STRING_MAYBE_CONCAT = new JassElementType("STRING_MAYBE_CONCAT");
  IElementType STRING_PARENS = new JassElementType("STRING_PARENS");
  IElementType TYPE_DECL = new JassElementType("TYPE_DECL");
  IElementType TYPE_REF = new JassElementType("TYPE_REF");
  IElementType VAR_NAME = new JassElementType("VAR_NAME");
  IElementType VAR_REF = new JassElementType("VAR_REF");
  IElementType VAR_TYPE = new JassElementType("VAR_TYPE");

  IElementType AND = new JassTokenType("AND");
  IElementType ARRAY = new JassTokenType("ARRAY");
  IElementType ASSIGN_OP = new JassTokenType("ASSIGN_OP");
  IElementType BOOL_LITERAL = new JassTokenType("BOOL_LITERAL");
  IElementType CALL = new JassTokenType("CALL");
  IElementType COMMA = new JassTokenType("COMMA");
  IElementType CONSTANT = new JassTokenType("CONSTANT");
  IElementType DEBUG = new JassTokenType("DEBUG");
  IElementType DEC_INT_LITERAL = new JassTokenType("DEC_INT_LITERAL");
  IElementType DIV = new JassTokenType("DIV");
  IElementType DOUBLE_QUOTE = new JassTokenType("DOUBLE_QUOTE");
  IElementType ELSE = new JassTokenType("ELSE");
  IElementType ELSEIF = new JassTokenType("ELSEIF");
  IElementType ENDFUNCTION = new JassTokenType("ENDFUNCTION");
  IElementType ENDGLOBALS = new JassTokenType("ENDGLOBALS");
  IElementType ENDIF = new JassTokenType("ENDIF");
  IElementType ENDLOOP = new JassTokenType("ENDLOOP");
  IElementType EOL_COMMENT = new JassTokenType("EOL_COMMENT");
  IElementType EQUAL = new JassTokenType("EQUAL");
  IElementType EXITWHEN = new JassTokenType("EXITWHEN");
  IElementType EXTENDS = new JassTokenType("EXTENDS");
  IElementType FUNCTION = new JassTokenType("FUNCTION");
  IElementType GLOBALS = new JassTokenType("GLOBALS");
  IElementType GREATER = new JassTokenType("GREATER");
  IElementType GREATER_EQUAL = new JassTokenType("GREATER_EQUAL");
  IElementType HEX_INT_LITERAL = new JassTokenType("HEX_INT_LITERAL");
  IElementType ID = new JassTokenType("ID");
  IElementType ID_INT_LITERAL = new JassTokenType("ID_INT_LITERAL");
  IElementType IF = new JassTokenType("IF");
  IElementType INCLUDE = new JassTokenType("INCLUDE");
  IElementType LBRACKET = new JassTokenType("LBRACKET");
  IElementType LESS = new JassTokenType("LESS");
  IElementType LESS_EQUAL = new JassTokenType("LESS_EQUAL");
  IElementType LOCAL = new JassTokenType("LOCAL");
  IElementType LOOP = new JassTokenType("LOOP");
  IElementType LPAREN = new JassTokenType("LPAREN");
  IElementType MINUS = new JassTokenType("MINUS");
  IElementType MOD = new JassTokenType("MOD");
  IElementType MUL = new JassTokenType("MUL");
  IElementType MUL_COMMENT = new JassTokenType("MUL_COMMENT");
  IElementType NATIVE = new JassTokenType("NATIVE");
  IElementType NOT = new JassTokenType("NOT");
  IElementType NOTHING = new JassTokenType("NOTHING");
  IElementType NULL = new JassTokenType("NULL");
  IElementType NUMBER_SIGN = new JassTokenType("NUMBER_SIGN");
  IElementType OCT_INT_LITERAL = new JassTokenType("OCT_INT_LITERAL");
  IElementType OR = new JassTokenType("OR");
  IElementType PLUS = new JassTokenType("PLUS");
  IElementType RBRACKET = new JassTokenType("RBRACKET");
  IElementType REAL_LITERAL = new JassTokenType("REAL_LITERAL");
  IElementType RETURN = new JassTokenType("RETURN");
  IElementType RETURNS = new JassTokenType("RETURNS");
  IElementType RPAREN = new JassTokenType("RPAREN");
  IElementType SET = new JassTokenType("SET");
  IElementType STRING_LITERAL = new JassTokenType("STRING_LITERAL");
  IElementType TAKES = new JassTokenType("TAKES");
  IElementType THEN = new JassTokenType("THEN");
  IElementType TYPE = new JassTokenType("TYPE");
  IElementType UNEQUAL = new JassTokenType("UNEQUAL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANY_EXPR_ATOM) {
        return new JassAnyExprAtomImpl(node);
      }
      else if (type == ARG_LIST) {
        return new JassArgListImpl(node);
      }
      else if (type == ARRAY_READ) {
        return new JassArrayReadImpl(node);
      }
      else if (type == BOOL_ATOM) {
        return new JassBoolAtomImpl(node);
      }
      else if (type == BOOL_BOOL_RELATION) {
        return new JassBoolBoolRelationImpl(node);
      }
      else if (type == BOOL_CODE_RELATION) {
        return new JassBoolCodeRelationImpl(node);
      }
      else if (type == BOOL_EXPR) {
        return new JassBoolExprImpl(node);
      }
      else if (type == BOOL_FULL_RELATION) {
        return new JassBoolFullRelationImpl(node);
      }
      else if (type == BOOL_HANDLE_RELATION) {
        return new JassBoolHandleRelationImpl(node);
      }
      else if (type == BOOL_MAYBE_CONJUNCT) {
        return new JassBoolMaybeConjunctImpl(node);
      }
      else if (type == BOOL_MAYBE_DISJUNCT) {
        return new JassBoolMaybeDisjunctImpl(node);
      }
      else if (type == BOOL_MAYBE_FULL_RELATION) {
        return new JassBoolMaybeFullRelationImpl(node);
      }
      else if (type == BOOL_MAYBE_NUM_ORDER_RELATION) {
        return new JassBoolMaybeNumOrderRelationImpl(node);
      }
      else if (type == BOOL_MAYBE_UNARY) {
        return new JassBoolMaybeUnaryImpl(node);
      }
      else if (type == BOOL_NULL_RELATION) {
        return new JassBoolNullRelationImpl(node);
      }
      else if (type == BOOL_NUM_ORDER_RELATION) {
        return new JassBoolNumOrderRelationImpl(node);
      }
      else if (type == BOOL_NUM_ORDER_RELATION_OP) {
        return new JassBoolNumOrderRelationOpImpl(node);
      }
      else if (type == BOOL_NUM_RELATION) {
        return new JassBoolNumRelationImpl(node);
      }
      else if (type == BOOL_PARENS) {
        return new JassBoolParensImpl(node);
      }
      else if (type == BOOL_RELATION_OP) {
        return new JassBoolRelationOpImpl(node);
      }
      else if (type == BOOL_STRING_RELATION) {
        return new JassBoolStringRelationImpl(node);
      }
      else if (type == CALL_STATEMENT) {
        return new JassCallStatementImpl(node);
      }
      else if (type == CODE_EXPR) {
        return new JassCodeExprImpl(node);
      }
      else if (type == CODE_LITERAL) {
        return new JassCodeLiteralImpl(node);
      }
      else if (type == CODE_PARENS) {
        return new JassCodeParensImpl(node);
      }
      else if (type == COMMENT) {
        return new JassCommentImpl(node);
      }
      else if (type == CONDITION) {
        return new JassConditionImpl(node);
      }
      else if (type == CONDITION_STATEMENT) {
        return new JassConditionStatementImpl(node);
      }
      else if (type == DEBUG_STATEMENT) {
        return new JassDebugStatementImpl(node);
      }
      else if (type == EXITWHEN_STATEMENT) {
        return new JassExitwhenStatementImpl(node);
      }
      else if (type == EXPR) {
        return new JassExprImpl(node);
      }
      else if (type == FUNC) {
        return new JassFuncImpl(node);
      }
      else if (type == FUNC_BODY) {
        return new JassFuncBodyImpl(node);
      }
      else if (type == FUNC_CALL) {
        return new JassFuncCallImpl(node);
      }
      else if (type == FUNC_DECL) {
        return new JassFuncDeclImpl(node);
      }
      else if (type == FUNC_NAME) {
        return new JassFuncNameImpl(node);
      }
      else if (type == FUNC_PARAM) {
        return new JassFuncParamImpl(node);
      }
      else if (type == FUNC_PARM_LIST) {
        return new JassFuncParmListImpl(node);
      }
      else if (type == FUNC_REF) {
        return new JassFuncRefImpl(node);
      }
      else if (type == FUNC_RETURN_TYPE) {
        return new JassFuncReturnTypeImpl(node);
      }
      else if (type == GLOBAL_BLOCK) {
        return new JassGlobalBlockImpl(node);
      }
      else if (type == GLOBAL_DECL) {
        return new JassGlobalDeclImpl(node);
      }
      else if (type == HANDLE_EXPR) {
        return new JassHandleExprImpl(node);
      }
      else if (type == HANDLE_LITERAL) {
        return new JassHandleLiteralImpl(node);
      }
      else if (type == HANDLE_PARENS) {
        return new JassHandleParensImpl(node);
      }
      else if (type == INCLUDE_STATEMENT) {
        return new JassIncludeStatementImpl(node);
      }
      else if (type == INT_ATOM) {
        return new JassIntAtomImpl(node);
      }
      else if (type == INT_EXPR) {
        return new JassIntExprImpl(node);
      }
      else if (type == INT_LITERAL) {
        return new JassIntLiteralImpl(node);
      }
      else if (type == INT_MAYBE_PROD) {
        return new JassIntMaybeProdImpl(node);
      }
      else if (type == INT_MAYBE_SUM) {
        return new JassIntMaybeSumImpl(node);
      }
      else if (type == INT_MAYBE_UNARY) {
        return new JassIntMaybeUnaryImpl(node);
      }
      else if (type == INT_PARENS) {
        return new JassIntParensImpl(node);
      }
      else if (type == LOCAL_VAR_DECL) {
        return new JassLocalVarDeclImpl(node);
      }
      else if (type == LOCAL_VAR_DECL_LIST) {
        return new JassLocalVarDeclListImpl(node);
      }
      else if (type == LOOP_BODY) {
        return new JassLoopBodyImpl(node);
      }
      else if (type == LOOP_STATEMENT) {
        return new JassLoopStatementImpl(node);
      }
      else if (type == NATIVE_DECL) {
        return new JassNativeDeclImpl(node);
      }
      else if (type == NULL_EXPR) {
        return new JassNullExprImpl(node);
      }
      else if (type == NULL_LITERAL) {
        return new JassNullLiteralImpl(node);
      }
      else if (type == NULL_PARENS) {
        return new JassNullParensImpl(node);
      }
      else if (type == NUMBER_EXPR) {
        return new JassNumberExprImpl(node);
      }
      else if (type == NUM_PROD_OP) {
        return new JassNumProdOpImpl(node);
      }
      else if (type == NUM_SUM_OP) {
        return new JassNumSumOpImpl(node);
      }
      else if (type == NUM_UNARY_OP) {
        return new JassNumUnaryOpImpl(node);
      }
      else if (type == REAL_ATOM) {
        return new JassRealAtomImpl(node);
      }
      else if (type == REAL_EXPR) {
        return new JassRealExprImpl(node);
      }
      else if (type == REAL_MAYBE_PROD) {
        return new JassRealMaybeProdImpl(node);
      }
      else if (type == REAL_MAYBE_SUM) {
        return new JassRealMaybeSumImpl(node);
      }
      else if (type == REAL_MAYBE_UNARY) {
        return new JassRealMaybeUnaryImpl(node);
      }
      else if (type == REAL_PARENS) {
        return new JassRealParensImpl(node);
      }
      else if (type == RULE_RETURN) {
        return new JassRuleReturnImpl(node);
      }
      else if (type == SELECTION_ELSEIF_BRANCH) {
        return new JassSelectionElseifBranchImpl(node);
      }
      else if (type == SELECTION_ELSE_BRANCH) {
        return new JassSelectionElseBranchImpl(node);
      }
      else if (type == SET_VAR) {
        return new JassSetVarImpl(node);
      }
      else if (type == STATEMENT) {
        return new JassStatementImpl(node);
      }
      else if (type == STATEMENT_LIST) {
        return new JassStatementListImpl(node);
      }
      else if (type == STRING_ATOM) {
        return new JassStringAtomImpl(node);
      }
      else if (type == STRING_CONCAT_OP) {
        return new JassStringConcatOpImpl(node);
      }
      else if (type == STRING_EXPR) {
        return new JassStringExprImpl(node);
      }
      else if (type == STRING_LITERALS) {
        return new JassStringLiteralsImpl(node);
      }
      else if (type == STRING_MAYBE_CONCAT) {
        return new JassStringMaybeConcatImpl(node);
      }
      else if (type == STRING_PARENS) {
        return new JassStringParensImpl(node);
      }
      else if (type == TYPE_DECL) {
        return new JassTypeDeclImpl(node);
      }
      else if (type == TYPE_REF) {
        return new JassTypeRefImpl(node);
      }
      else if (type == VAR_NAME) {
        return new JassVarNameImpl(node);
      }
      else if (type == VAR_REF) {
        return new JassVarRefImpl(node);
      }
      else if (type == VAR_TYPE) {
        return new JassVarTypeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
