// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static cn.gsein.zjass.psi.JassTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class JassParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t instanceof IFileElementType) {
      r = parse_root_(t, b, 0);
    }
    else {
      r = false;
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return jassFile(b, l + 1);
  }

  /* ********************************************************** */
  // SET var_name EQ var_value
  public static boolean assign_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_statement")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET);
    r = r && var_name(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && var_value(b, l + 1);
    exit_section_(b, m, ASSIGN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // number_expr (GT | DOUBLE_EQ | LT | LE | GE) number_expr | string_expr DOUBLE_EQ string_expr | var_name | func_call | NOT bool_expr
  public static boolean bool_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_EXPR, "<bool expr>");
    r = bool_expr_0(b, l + 1);
    if (!r) r = bool_expr_1(b, l + 1);
    if (!r) r = var_name(b, l + 1);
    if (!r) r = func_call(b, l + 1);
    if (!r) r = bool_expr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // number_expr (GT | DOUBLE_EQ | LT | LE | GE) number_expr
  private static boolean bool_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_expr(b, l + 1);
    r = r && bool_expr_0_1(b, l + 1);
    r = r && number_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GT | DOUBLE_EQ | LT | LE | GE
  private static boolean bool_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_0_1")) return false;
    boolean r;
    r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, DOUBLE_EQ);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GE);
    return r;
  }

  // string_expr DOUBLE_EQ string_expr
  private static boolean bool_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_expr(b, l + 1);
    r = r && consumeToken(b, DOUBLE_EQ);
    r = r && string_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT bool_expr
  private static boolean bool_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && bool_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CALL func_call
  public static boolean call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_statement")) return false;
    if (!nextTokenIs(b, CALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL);
    r = r && func_call(b, l + 1);
    exit_section_(b, m, CALL_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // EOL_COMMENT | MUL_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "<comment>", EOL_COMMENT, MUL_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, EOL_COMMENT);
    if (!r) r = consumeToken(b, MUL_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (comment|call_statement|assign_statement|condition_statement|loop_statement)* return_statement?
  public static boolean compound_statment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_statment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOUND_STATMENT, "<compound statment>");
    r = compound_statment_0(b, l + 1);
    r = r && compound_statment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (comment|call_statement|assign_statement|condition_statement|loop_statement)*
  private static boolean compound_statment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_statment_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!compound_statment_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compound_statment_0", c)) break;
    }
    return true;
  }

  // comment|call_statement|assign_statement|condition_statement|loop_statement
  private static boolean compound_statment_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_statment_0_0")) return false;
    boolean r;
    r = comment(b, l + 1);
    if (!r) r = call_statement(b, l + 1);
    if (!r) r = assign_statement(b, l + 1);
    if (!r) r = condition_statement(b, l + 1);
    if (!r) r = loop_statement(b, l + 1);
    return r;
  }

  // return_statement?
  private static boolean compound_statment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_statment_1")) return false;
    return_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IF bool_expr THEN compound_statment ((ELSEIF compound_statment)* ELSE compound_statment)? ENDIF
  public static boolean condition_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && bool_expr(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && compound_statment(b, l + 1);
    r = r && condition_statement_4(b, l + 1);
    r = r && consumeToken(b, ENDIF);
    exit_section_(b, m, CONDITION_STATEMENT, r);
    return r;
  }

  // ((ELSEIF compound_statment)* ELSE compound_statment)?
  private static boolean condition_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement_4")) return false;
    condition_statement_4_0(b, l + 1);
    return true;
  }

  // (ELSEIF compound_statment)* ELSE compound_statment
  private static boolean condition_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condition_statement_4_0_0(b, l + 1);
    r = r && consumeToken(b, ELSE);
    r = r && compound_statment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSEIF compound_statment)*
  private static boolean condition_statement_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement_4_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!condition_statement_4_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "condition_statement_4_0_0", c)) break;
    }
    return true;
  }

  // ELSEIF compound_statment
  private static boolean condition_statement_4_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement_4_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && compound_statment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  public static boolean empty(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, EMPTY, true);
    return true;
  }

  /* ********************************************************** */
  // func_call|MINUS factor| PLUS factor|LPAREN expr RPAREN|var_name|INTEGER_LITERAL|REAL_LITERAL
  public static boolean factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FACTOR, "<factor>");
    r = func_call(b, l + 1);
    if (!r) r = factor_1(b, l + 1);
    if (!r) r = factor_2(b, l + 1);
    if (!r) r = parseTokens(b, 0, LPAREN, EXPR, RPAREN);
    if (!r) r = var_name(b, l + 1);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, REAL_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MINUS factor
  private static boolean factor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS factor
  private static boolean factor_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // func_def comment* local_def* compound_statment ENDFUNCTION
  public static boolean func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_def(b, l + 1);
    r = r && func_1(b, l + 1);
    r = r && func_2(b, l + 1);
    r = r && compound_statment(b, l + 1);
    r = r && consumeToken(b, ENDFUNCTION);
    exit_section_(b, m, FUNC, r);
    return r;
  }

  // comment*
  private static boolean func_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_1", c)) break;
    }
    return true;
  }

  // local_def*
  private static boolean func_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!local_def(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // func_name LPAREN ( (var_name|var_value)(COLON (var_name|var_value))*|empty) RPAREN
  public static boolean func_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_name(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && func_call_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FUNC_CALL, r);
    return r;
  }

  // (var_name|var_value)(COLON (var_name|var_value))*|empty
  private static boolean func_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_call_2_0(b, l + 1);
    if (!r) r = empty(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (var_name|var_value)(COLON (var_name|var_value))*
  private static boolean func_call_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_call_2_0_0(b, l + 1);
    r = r && func_call_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // var_name|var_value
  private static boolean func_call_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_2_0_0")) return false;
    boolean r;
    r = var_name(b, l + 1);
    if (!r) r = var_value(b, l + 1);
    return r;
  }

  // (COLON (var_name|var_value))*
  private static boolean func_call_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_call_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_call_2_0_1", c)) break;
    }
    return true;
  }

  // COLON (var_name|var_value)
  private static boolean func_call_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && func_call_2_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // var_name|var_value
  private static boolean func_call_2_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_2_0_1_0_1")) return false;
    boolean r;
    r = var_name(b, l + 1);
    if (!r) r = var_value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION func_name TAKES (NOTHING | var_type var_name (COLON var_type var_name)*)
  //     RETURNS (NOTHING | var_type)
  public static boolean func_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && func_name(b, l + 1);
    r = r && consumeToken(b, TAKES);
    r = r && func_def_3(b, l + 1);
    r = r && consumeToken(b, RETURNS);
    r = r && func_def_5(b, l + 1);
    exit_section_(b, m, FUNC_DEF, r);
    return r;
  }

  // NOTHING | var_type var_name (COLON var_type var_name)*
  private static boolean func_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOTHING);
    if (!r) r = func_def_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // var_type var_name (COLON var_type var_name)*
  private static boolean func_def_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_type(b, l + 1);
    r = r && var_name(b, l + 1);
    r = r && func_def_3_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON var_type var_name)*
  private static boolean func_def_3_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def_3_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_def_3_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_def_3_1_2", c)) break;
    }
    return true;
  }

  // COLON var_type var_name
  private static boolean func_def_3_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def_3_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && var_type(b, l + 1);
    r = r && var_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOTHING | var_type
  private static boolean func_def_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_def_5")) return false;
    boolean r;
    r = consumeToken(b, NOTHING);
    if (!r) r = var_type(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean func_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, FUNC_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // GLOBALS (global_decl|comment)* ENDGLOBALS
  public static boolean global_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_block")) return false;
    if (!nextTokenIs(b, GLOBALS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBALS);
    r = r && global_block_1(b, l + 1);
    r = r && consumeToken(b, ENDGLOBALS);
    exit_section_(b, m, GLOBAL_BLOCK, r);
    return r;
  }

  // (global_decl|comment)*
  private static boolean global_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!global_block_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "global_block_1", c)) break;
    }
    return true;
  }

  // global_decl|comment
  private static boolean global_block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_block_1_0")) return false;
    boolean r;
    r = global_decl(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // var_type ARRAY var_name  | CONSTANT? var_type var_name (EQ var_value)?
  public static boolean global_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl")) return false;
    if (!nextTokenIs(b, "<global decl>", CONSTANT, TYPE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_DECL, "<global decl>");
    r = global_decl_0(b, l + 1);
    if (!r) r = global_decl_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // var_type ARRAY var_name
  private static boolean global_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_type(b, l + 1);
    r = r && consumeToken(b, ARRAY);
    r = r && var_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CONSTANT? var_type var_name (EQ var_value)?
  private static boolean global_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = global_decl_1_0(b, l + 1);
    r = r && var_type(b, l + 1);
    r = r && var_name(b, l + 1);
    r = r && global_decl_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CONSTANT?
  private static boolean global_decl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_1_0")) return false;
    consumeToken(b, CONSTANT);
    return true;
  }

  // (EQ var_value)?
  private static boolean global_decl_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_1_3")) return false;
    global_decl_1_3_0(b, l + 1);
    return true;
  }

  // EQ var_value
  private static boolean global_decl_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && var_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER_SIGN INCLUDE DOUBLE_QUOTE STRING_LITERAL? DOUBLE_QUOTE
  public static boolean include_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement")) return false;
    if (!nextTokenIs(b, NUMBER_SIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NUMBER_SIGN, INCLUDE, DOUBLE_QUOTE);
    r = r && include_statement_3(b, l + 1);
    r = r && consumeToken(b, DOUBLE_QUOTE);
    exit_section_(b, m, INCLUDE_STATEMENT, r);
    return r;
  }

  // STRING_LITERAL?
  private static boolean include_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement_3")) return false;
    consumeToken(b, STRING_LITERAL);
    return true;
  }

  /* ********************************************************** */
  // include_statement|global_block|type_def|native_def|func|comment
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = include_statement(b, l + 1);
    if (!r) r = global_block(b, l + 1);
    if (!r) r = type_def(b, l + 1);
    if (!r) r = native_def(b, l + 1);
    if (!r) r = func(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean jassFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jassFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jassFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LOCAL var_type ( ARRAY var_name | var_name (EQ var_value)?)
  public static boolean local_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_def")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && var_type(b, l + 1);
    r = r && local_def_2(b, l + 1);
    exit_section_(b, m, LOCAL_DEF, r);
    return r;
  }

  // ARRAY var_name | var_name (EQ var_value)?
  private static boolean local_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_def_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = local_def_2_0(b, l + 1);
    if (!r) r = local_def_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ARRAY var_name
  private static boolean local_def_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_def_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARRAY);
    r = r && var_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // var_name (EQ var_value)?
  private static boolean local_def_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_def_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name(b, l + 1);
    r = r && local_def_2_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EQ var_value)?
  private static boolean local_def_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_def_2_1_1")) return false;
    local_def_2_1_1_0(b, l + 1);
    return true;
  }

  // EQ var_value
  private static boolean local_def_2_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_def_2_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && var_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LOOP ( EXITWHEN bool_expr|compound_statment)* ENDLOOP
  public static boolean loop_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement")) return false;
    if (!nextTokenIs(b, LOOP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOOP);
    r = r && loop_statement_1(b, l + 1);
    r = r && consumeToken(b, ENDLOOP);
    exit_section_(b, m, LOOP_STATEMENT, r);
    return r;
  }

  // ( EXITWHEN bool_expr|compound_statment)*
  private static boolean loop_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!loop_statement_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "loop_statement_1", c)) break;
    }
    return true;
  }

  // EXITWHEN bool_expr|compound_statment
  private static boolean loop_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = loop_statement_1_0_0(b, l + 1);
    if (!r) r = compound_statment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EXITWHEN bool_expr
  private static boolean loop_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXITWHEN);
    r = r && bool_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONSTANT? NATIVE func_name TAKES (NOTHING | var_type var_name (COLON var_type var_name)*) RETURNS (NOTHING | var_type)
  public static boolean native_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_def")) return false;
    if (!nextTokenIs(b, "<native def>", CONSTANT, NATIVE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NATIVE_DEF, "<native def>");
    r = native_def_0(b, l + 1);
    r = r && consumeToken(b, NATIVE);
    r = r && func_name(b, l + 1);
    r = r && consumeToken(b, TAKES);
    r = r && native_def_4(b, l + 1);
    r = r && consumeToken(b, RETURNS);
    r = r && native_def_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CONSTANT?
  private static boolean native_def_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_def_0")) return false;
    consumeToken(b, CONSTANT);
    return true;
  }

  // NOTHING | var_type var_name (COLON var_type var_name)*
  private static boolean native_def_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_def_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOTHING);
    if (!r) r = native_def_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // var_type var_name (COLON var_type var_name)*
  private static boolean native_def_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_def_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_type(b, l + 1);
    r = r && var_name(b, l + 1);
    r = r && native_def_4_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON var_type var_name)*
  private static boolean native_def_4_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_def_4_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!native_def_4_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "native_def_4_1_2", c)) break;
    }
    return true;
  }

  // COLON var_type var_name
  private static boolean native_def_4_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_def_4_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && var_type(b, l + 1);
    r = r && var_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOTHING | var_type
  private static boolean native_def_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_def_6")) return false;
    boolean r;
    r = consumeToken(b, NOTHING);
    if (!r) r = var_type(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // term (MINUS|PLUS term)*
  public static boolean number_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_EXPR, "<number expr>");
    r = term(b, l + 1);
    r = r && number_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MINUS|PLUS term)*
  private static boolean number_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!number_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "number_expr_1", c)) break;
    }
    return true;
  }

  // MINUS|PLUS term
  private static boolean number_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    if (!r) r = number_expr_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS term
  private static boolean number_expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_expr_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN var_value
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && var_value(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE STRING_LITERAL? DOUBLE_QUOTE | func_call
  public static boolean string_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_expr")) return false;
    if (!nextTokenIs(b, "<string expr>", DOUBLE_QUOTE, ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_EXPR, "<string expr>");
    r = string_expr_0(b, l + 1);
    if (!r) r = func_call(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE STRING_LITERAL? DOUBLE_QUOTE
  private static boolean string_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOUBLE_QUOTE);
    r = r && string_expr_0_1(b, l + 1);
    r = r && consumeToken(b, DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_LITERAL?
  private static boolean string_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_expr_0_1")) return false;
    consumeToken(b, STRING_LITERAL);
    return true;
  }

  /* ********************************************************** */
  // factor (MUL|DIV factor) *
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = factor(b, l + 1);
    r = r && term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MUL|DIV factor) *
  private static boolean term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!term_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_1", c)) break;
    }
    return true;
  }

  // MUL|DIV factor
  private static boolean term_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    if (!r) r = term_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DIV factor
  private static boolean term_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DIV);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE var_type EXTENDS var_type
  public static boolean type_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_def")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && var_type(b, l + 1);
    r = r && consumeToken(b, EXTENDS);
    r = r && var_type(b, l + 1);
    exit_section_(b, m, TYPE_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean var_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, VAR_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE_ID
  public static boolean var_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_type")) return false;
    if (!nextTokenIs(b, TYPE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_ID);
    exit_section_(b, m, VAR_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // string_expr (PLUS string_expr)*|number_expr|NULL
  public static boolean var_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_VALUE, "<var value>");
    r = var_value_0(b, l + 1);
    if (!r) r = number_expr(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // string_expr (PLUS string_expr)*
  private static boolean var_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_expr(b, l + 1);
    r = r && var_value_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PLUS string_expr)*
  private static boolean var_value_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_value_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!var_value_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "var_value_0_1", c)) break;
    }
    return true;
  }

  // PLUS string_expr
  private static boolean var_value_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_value_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && string_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
