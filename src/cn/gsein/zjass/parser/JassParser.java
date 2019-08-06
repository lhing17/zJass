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
  // func_call | array_read |var_ref
  public static boolean any_expr_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_expr_atom")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_call(b, l + 1);
    if (!r) r = array_read(b, l + 1);
    if (!r) r = var_ref(b, l + 1);
    exit_section_(b, m, ANY_EXPR_ATOM, r);
    return r;
  }

  /* ********************************************************** */
  // (expr (COMMA expr)*)?
  public static boolean arg_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, ARG_LIST, "<arg list>");
    arg_list_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // expr (COMMA expr)*
  private static boolean arg_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && arg_list_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expr)*
  private static boolean arg_list_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_list_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_list_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_list_0_1", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean arg_list_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_list_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var_ref LBRACKET int_expr RBRACKET
  public static boolean array_read(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_read")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_ref(b, l + 1);
    r = r && consumeToken(b, LBRACKET);
    r = r && int_expr(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, ARRAY_READ, r);
    return r;
  }

  /* ********************************************************** */
  // BOOL_LITERAL | bool_parens | any_expr_atom
  public static boolean bool_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_ATOM, "<bool atom>");
    r = consumeToken(b, BOOL_LITERAL);
    if (!r) r = bool_parens(b, l + 1);
    if (!r) r = any_expr_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bool_maybe_num_order_relation bool_relation_op bool_maybe_num_order_relation
  public static boolean bool_bool_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_bool_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_BOOL_RELATION, "<bool bool relation>");
    r = bool_maybe_num_order_relation(b, l + 1);
    r = r && bool_relation_op(b, l + 1);
    r = r && bool_maybe_num_order_relation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // code_expr bool_relation_op code_expr
  public static boolean bool_code_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_code_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_CODE_RELATION, "<bool code relation>");
    r = code_expr(b, l + 1);
    r = r && bool_relation_op(b, l + 1);
    r = r && code_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bool_maybe_disjunct
  public static boolean bool_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_EXPR, "<bool expr>");
    r = bool_maybe_disjunct(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bool_null_relation |  bool_handle_relation | bool_code_relation | bool_bool_relation | bool_num_relation | bool_string_relation
  public static boolean bool_full_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_full_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_FULL_RELATION, "<bool full relation>");
    r = bool_null_relation(b, l + 1);
    if (!r) r = bool_handle_relation(b, l + 1);
    if (!r) r = bool_code_relation(b, l + 1);
    if (!r) r = bool_bool_relation(b, l + 1);
    if (!r) r = bool_num_relation(b, l + 1);
    if (!r) r = bool_string_relation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // handle_expr bool_relation_op handle_expr
  public static boolean bool_handle_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_handle_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_HANDLE_RELATION, "<bool handle relation>");
    r = handle_expr(b, l + 1);
    r = r && bool_relation_op(b, l + 1);
    r = r && handle_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bool_maybe_full_relation (AND bool_maybe_full_relation)*
  public static boolean bool_maybe_conjunct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_conjunct")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_MAYBE_CONJUNCT, "<bool maybe conjunct>");
    r = bool_maybe_full_relation(b, l + 1);
    r = r && bool_maybe_conjunct_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AND bool_maybe_full_relation)*
  private static boolean bool_maybe_conjunct_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_conjunct_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bool_maybe_conjunct_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bool_maybe_conjunct_1", c)) break;
    }
    return true;
  }

  // AND bool_maybe_full_relation
  private static boolean bool_maybe_conjunct_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_conjunct_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && bool_maybe_full_relation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bool_maybe_conjunct (OR bool_maybe_conjunct)*
  public static boolean bool_maybe_disjunct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_disjunct")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_MAYBE_DISJUNCT, "<bool maybe disjunct>");
    r = bool_maybe_conjunct(b, l + 1);
    r = r && bool_maybe_disjunct_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OR bool_maybe_conjunct)*
  private static boolean bool_maybe_disjunct_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_disjunct_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bool_maybe_disjunct_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bool_maybe_disjunct_1", c)) break;
    }
    return true;
  }

  // OR bool_maybe_conjunct
  private static boolean bool_maybe_disjunct_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_disjunct_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && bool_maybe_conjunct(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bool_full_relation | bool_maybe_num_order_relation
  public static boolean bool_maybe_full_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_full_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_MAYBE_FULL_RELATION, "<bool maybe full relation>");
    r = bool_full_relation(b, l + 1);
    if (!r) r = bool_maybe_num_order_relation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bool_num_order_relation | bool_maybe_unary
  public static boolean bool_maybe_num_order_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_num_order_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_MAYBE_NUM_ORDER_RELATION, "<bool maybe num order relation>");
    r = bool_num_order_relation(b, l + 1);
    if (!r) r = bool_maybe_unary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT bool_maybe_unary | bool_atom
  public static boolean bool_maybe_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_unary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_MAYBE_UNARY, "<bool maybe unary>");
    r = bool_maybe_unary_0(b, l + 1);
    if (!r) r = bool_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NOT bool_maybe_unary
  private static boolean bool_maybe_unary_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_maybe_unary_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && bool_maybe_unary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // null_expr bool_relation_op null_expr
  public static boolean bool_null_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_null_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_NULL_RELATION, "<bool null relation>");
    r = null_expr(b, l + 1);
    r = r && bool_relation_op(b, l + 1);
    r = r && null_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // number_expr bool_num_order_relation_op number_expr
  public static boolean bool_num_order_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_num_order_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_NUM_ORDER_RELATION, "<bool num order relation>");
    r = number_expr(b, l + 1);
    r = r && bool_num_order_relation_op(b, l + 1);
    r = r && number_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LESS | LESS_EQUAL | GREATER |GREATER_EQUAL
  public static boolean bool_num_order_relation_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_num_order_relation_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_NUM_ORDER_RELATION_OP, "<bool num order relation op>");
    r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // number_expr bool_relation_op number_expr
  public static boolean bool_num_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_num_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_NUM_RELATION, "<bool num relation>");
    r = number_expr(b, l + 1);
    r = r && bool_relation_op(b, l + 1);
    r = r && number_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN bool_expr RPAREN
  public static boolean bool_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_parens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && bool_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, BOOL_PARENS, r);
    return r;
  }

  /* ********************************************************** */
  // EQUAL | UNEQUAL
  public static boolean bool_relation_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_relation_op")) return false;
    if (!nextTokenIs(b, "<bool relation op>", EQUAL, UNEQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_RELATION_OP, "<bool relation op>");
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, UNEQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string_expr bool_relation_op string_expr
  public static boolean bool_string_relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_string_relation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_STRING_RELATION, "<bool string relation>");
    r = string_expr(b, l + 1);
    r = r && bool_relation_op(b, l + 1);
    r = r && string_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // code_literal|code_parens|any_expr_atom
  public static boolean code_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE_EXPR, "<code expr>");
    r = code_literal(b, l + 1);
    if (!r) r = code_parens(b, l + 1);
    if (!r) r = any_expr_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION func_ref | null_literal
  public static boolean code_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_literal")) return false;
    if (!nextTokenIs(b, "<code literal>", FUNCTION, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE_LITERAL, "<code literal>");
    r = code_literal_0(b, l + 1);
    if (!r) r = null_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FUNCTION func_ref
  private static boolean code_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && func_ref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN code_expr RPAREN
  public static boolean code_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_parens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && code_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CODE_PARENS, r);
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
  // bool_expr
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = bool_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF condition THEN statement_list? selection_elseif_branch* selection_else_branch? ENDIF
  public static boolean condition_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && condition(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && condition_statement_3(b, l + 1);
    r = r && condition_statement_4(b, l + 1);
    r = r && condition_statement_5(b, l + 1);
    r = r && consumeToken(b, ENDIF);
    exit_section_(b, m, CONDITION_STATEMENT, r);
    return r;
  }

  // statement_list?
  private static boolean condition_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement_3")) return false;
    statement_list(b, l + 1);
    return true;
  }

  // selection_elseif_branch*
  private static boolean condition_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!selection_elseif_branch(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "condition_statement_4", c)) break;
    }
    return true;
  }

  // selection_else_branch?
  private static boolean condition_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_statement_5")) return false;
    selection_else_branch(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DEBUG (call_statement | set_var | condition_statement | loop_statement)
  public static boolean debug_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "debug_statement")) return false;
    if (!nextTokenIs(b, DEBUG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEBUG);
    r = r && debug_statement_1(b, l + 1);
    exit_section_(b, m, DEBUG_STATEMENT, r);
    return r;
  }

  // call_statement | set_var | condition_statement | loop_statement
  private static boolean debug_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "debug_statement_1")) return false;
    boolean r;
    r = call_statement(b, l + 1);
    if (!r) r = set_var(b, l + 1);
    if (!r) r = condition_statement(b, l + 1);
    if (!r) r = loop_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // EXITWHEN condition
  public static boolean exitwhen_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exitwhen_statement")) return false;
    if (!nextTokenIs(b, EXITWHEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXITWHEN);
    r = r && condition(b, l + 1);
    exit_section_(b, m, EXITWHEN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // number_expr|string_expr|handle_expr|null_expr|code_expr|bool_expr
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = number_expr(b, l + 1);
    if (!r) r = string_expr(b, l + 1);
    if (!r) r = handle_expr(b, l + 1);
    if (!r) r = null_expr(b, l + 1);
    if (!r) r = code_expr(b, l + 1);
    if (!r) r = bool_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // func_decl (func_body)? ENDFUNCTION
  public static boolean func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func")) return false;
    if (!nextTokenIs(b, "<func>", CONSTANT, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC, "<func>");
    r = func_decl(b, l + 1);
    r = r && func_1(b, l + 1);
    r = r && consumeToken(b, ENDFUNCTION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (func_body)?
  private static boolean func_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_1")) return false;
    func_1_0(b, l + 1);
    return true;
  }

  // (func_body)
  private static boolean func_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // local_var_decl_list statement_list
  public static boolean func_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_BODY, "<func body>");
    r = local_var_decl_list(b, l + 1);
    r = r && statement_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // func_ref LPAREN arg_list RPAREN
  public static boolean func_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_ref(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && arg_list(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FUNC_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // CONSTANT? FUNCTION func_name TAKES func_parm_list RETURNS func_return_type
  public static boolean func_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl")) return false;
    if (!nextTokenIs(b, "<func decl>", CONSTANT, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_DECL, "<func decl>");
    r = func_decl_0(b, l + 1);
    r = r && consumeToken(b, FUNCTION);
    r = r && func_name(b, l + 1);
    r = r && consumeToken(b, TAKES);
    r = r && func_parm_list(b, l + 1);
    r = r && consumeToken(b, RETURNS);
    r = r && func_return_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CONSTANT?
  private static boolean func_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_0")) return false;
    consumeToken(b, CONSTANT);
    return true;
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
  // type_ref var_name
  public static boolean func_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_param")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_ref(b, l + 1);
    r = r && var_name(b, l + 1);
    exit_section_(b, m, FUNC_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // NOTHING | func_param (COMMA func_param)*
  public static boolean func_parm_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_parm_list")) return false;
    if (!nextTokenIs(b, "<func parm list>", ID, NOTHING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_PARM_LIST, "<func parm list>");
    r = consumeToken(b, NOTHING);
    if (!r) r = func_parm_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // func_param (COMMA func_param)*
  private static boolean func_parm_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_parm_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_param(b, l + 1);
    r = r && func_parm_list_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA func_param)*
  private static boolean func_parm_list_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_parm_list_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_parm_list_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_parm_list_1_1", c)) break;
    }
    return true;
  }

  // COMMA func_param
  private static boolean func_parm_list_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_parm_list_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && func_param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean func_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_ref")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, FUNC_REF, r);
    return r;
  }

  /* ********************************************************** */
  // NOTHING | type_ref
  public static boolean func_return_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_return_type")) return false;
    if (!nextTokenIs(b, "<func return type>", ID, NOTHING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_RETURN_TYPE, "<func return type>");
    r = consumeToken(b, NOTHING);
    if (!r) r = type_ref(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // var_type ARRAY var_name | CONSTANT? var_type var_name (ASSIGN_OP expr)?
  public static boolean global_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl")) return false;
    if (!nextTokenIs(b, "<global decl>", CONSTANT, ID)) return false;
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

  // CONSTANT? var_type var_name (ASSIGN_OP expr)?
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

  // (ASSIGN_OP expr)?
  private static boolean global_decl_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_1_3")) return false;
    global_decl_1_3_0(b, l + 1);
    return true;
  }

  // ASSIGN_OP expr
  private static boolean global_decl_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_decl_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN_OP);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // handle_literal|handle_parens|any_expr_atom
  public static boolean handle_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handle_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HANDLE_EXPR, "<handle expr>");
    r = handle_literal(b, l + 1);
    if (!r) r = handle_parens(b, l + 1);
    if (!r) r = any_expr_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // null_literal
  public static boolean handle_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handle_literal")) return false;
    if (!nextTokenIs(b, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = null_literal(b, l + 1);
    exit_section_(b, m, HANDLE_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN handle_expr RPAREN
  public static boolean handle_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handle_parens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && handle_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, HANDLE_PARENS, r);
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
  // int_literal | int_parens | any_expr_atom
  public static boolean int_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_ATOM, "<int atom>");
    r = int_literal(b, l + 1);
    if (!r) r = int_parens(b, l + 1);
    if (!r) r = any_expr_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // int_maybe_sum
  public static boolean int_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_EXPR, "<int expr>");
    r = int_maybe_sum(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID_INT_LITERAL | DEC_INT_LITERAL | OCT_INT_LITERAL | HEX_INT_LITERAL
  public static boolean int_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_LITERAL, "<int literal>");
    r = consumeToken(b, ID_INT_LITERAL);
    if (!r) r = consumeToken(b, DEC_INT_LITERAL);
    if (!r) r = consumeToken(b, OCT_INT_LITERAL);
    if (!r) r = consumeToken(b, HEX_INT_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // int_maybe_unary (num_prod_op int_maybe_unary)*
  public static boolean int_maybe_prod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_prod")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_MAYBE_PROD, "<int maybe prod>");
    r = int_maybe_unary(b, l + 1);
    r = r && int_maybe_prod_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (num_prod_op int_maybe_unary)*
  private static boolean int_maybe_prod_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_prod_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!int_maybe_prod_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "int_maybe_prod_1", c)) break;
    }
    return true;
  }

  // num_prod_op int_maybe_unary
  private static boolean int_maybe_prod_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_prod_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_prod_op(b, l + 1);
    r = r && int_maybe_unary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // int_maybe_prod (num_sum_op int_maybe_prod)*
  public static boolean int_maybe_sum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_sum")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_MAYBE_SUM, "<int maybe sum>");
    r = int_maybe_prod(b, l + 1);
    r = r && int_maybe_sum_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (num_sum_op int_maybe_prod)*
  private static boolean int_maybe_sum_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_sum_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!int_maybe_sum_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "int_maybe_sum_1", c)) break;
    }
    return true;
  }

  // num_sum_op int_maybe_prod
  private static boolean int_maybe_sum_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_sum_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_sum_op(b, l + 1);
    r = r && int_maybe_prod(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // num_unary_op int_maybe_unary | int_atom
  public static boolean int_maybe_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_unary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_MAYBE_UNARY, "<int maybe unary>");
    r = int_maybe_unary_0(b, l + 1);
    if (!r) r = int_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // num_unary_op int_maybe_unary
  private static boolean int_maybe_unary_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_maybe_unary_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_unary_op(b, l + 1);
    r = r && int_maybe_unary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN int_expr RPAREN
  public static boolean int_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_parens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && int_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, INT_PARENS, r);
    return r;
  }

  /* ********************************************************** */
  // include_statement|global_block|type_decl|native_decl|func|comment
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = include_statement(b, l + 1);
    if (!r) r = global_block(b, l + 1);
    if (!r) r = type_decl(b, l + 1);
    if (!r) r = native_decl(b, l + 1);
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
  // LOCAL type_ref (ARRAY var_name | var_name (ASSIGN_OP expr)?)
  public static boolean local_var_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && type_ref(b, l + 1);
    r = r && local_var_decl_2(b, l + 1);
    exit_section_(b, m, LOCAL_VAR_DECL, r);
    return r;
  }

  // ARRAY var_name | var_name (ASSIGN_OP expr)?
  private static boolean local_var_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = local_var_decl_2_0(b, l + 1);
    if (!r) r = local_var_decl_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ARRAY var_name
  private static boolean local_var_decl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARRAY);
    r = r && var_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // var_name (ASSIGN_OP expr)?
  private static boolean local_var_decl_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_name(b, l + 1);
    r = r && local_var_decl_2_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGN_OP expr)?
  private static boolean local_var_decl_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl_2_1_1")) return false;
    local_var_decl_2_1_1_0(b, l + 1);
    return true;
  }

  // ASSIGN_OP expr
  private static boolean local_var_decl_2_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl_2_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN_OP);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (comment |local_var_decl)*
  public static boolean local_var_decl_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, LOCAL_VAR_DECL_LIST, "<local var decl list>");
    while (true) {
      int c = current_position_(b);
      if (!local_var_decl_list_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "local_var_decl_list", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // comment |local_var_decl
  private static boolean local_var_decl_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "local_var_decl_list_0")) return false;
    boolean r;
    r = comment(b, l + 1);
    if (!r) r = local_var_decl(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // statement_list
  public static boolean loop_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOOP_BODY, "<loop body>");
    r = statement_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LOOP loop_body? ENDLOOP
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

  // loop_body?
  private static boolean loop_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loop_statement_1")) return false;
    loop_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CONSTANT? NATIVE func_name TAKES func_parm_list RETURNS func_return_type
  public static boolean native_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_decl")) return false;
    if (!nextTokenIs(b, "<native decl>", CONSTANT, NATIVE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NATIVE_DECL, "<native decl>");
    r = native_decl_0(b, l + 1);
    r = r && consumeToken(b, NATIVE);
    r = r && func_name(b, l + 1);
    r = r && consumeToken(b, TAKES);
    r = r && func_parm_list(b, l + 1);
    r = r && consumeToken(b, RETURNS);
    r = r && func_return_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CONSTANT?
  private static boolean native_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "native_decl_0")) return false;
    consumeToken(b, CONSTANT);
    return true;
  }

  /* ********************************************************** */
  // null_literal | null_parens | any_expr_atom
  public static boolean null_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "null_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NULL_EXPR, "<null expr>");
    r = null_literal(b, l + 1);
    if (!r) r = null_parens(b, l + 1);
    if (!r) r = any_expr_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NULL
  public static boolean null_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "null_literal")) return false;
    if (!nextTokenIs(b, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL);
    exit_section_(b, m, NULL_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN null_expr RPAREN
  public static boolean null_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "null_parens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && null_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, NULL_PARENS, r);
    return r;
  }

  /* ********************************************************** */
  // MUL | DIV | MOD
  public static boolean num_prod_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_prod_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_PROD_OP, "<num prod op>");
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, MOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS
  public static boolean num_sum_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_sum_op")) return false;
    if (!nextTokenIs(b, "<num sum op>", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_SUM_OP, "<num sum op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS
  public static boolean num_unary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_unary_op")) return false;
    if (!nextTokenIs(b, "<num unary op>", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_UNARY_OP, "<num unary op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // real_expr | int_expr
  public static boolean number_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_EXPR, "<number expr>");
    r = real_expr(b, l + 1);
    if (!r) r = int_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // int_atom | REAL_LITERAL | real_parens | any_expr_atom
  public static boolean real_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REAL_ATOM, "<real atom>");
    r = int_atom(b, l + 1);
    if (!r) r = consumeToken(b, REAL_LITERAL);
    if (!r) r = real_parens(b, l + 1);
    if (!r) r = any_expr_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // real_maybe_sum
  public static boolean real_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REAL_EXPR, "<real expr>");
    r = real_maybe_sum(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // real_maybe_unary (num_prod_op real_maybe_unary)*
  public static boolean real_maybe_prod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_prod")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REAL_MAYBE_PROD, "<real maybe prod>");
    r = real_maybe_unary(b, l + 1);
    r = r && real_maybe_prod_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (num_prod_op real_maybe_unary)*
  private static boolean real_maybe_prod_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_prod_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!real_maybe_prod_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "real_maybe_prod_1", c)) break;
    }
    return true;
  }

  // num_prod_op real_maybe_unary
  private static boolean real_maybe_prod_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_prod_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_prod_op(b, l + 1);
    r = r && real_maybe_unary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // real_maybe_prod (num_sum_op real_maybe_prod)*
  public static boolean real_maybe_sum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_sum")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REAL_MAYBE_SUM, "<real maybe sum>");
    r = real_maybe_prod(b, l + 1);
    r = r && real_maybe_sum_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (num_sum_op real_maybe_prod)*
  private static boolean real_maybe_sum_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_sum_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!real_maybe_sum_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "real_maybe_sum_1", c)) break;
    }
    return true;
  }

  // num_sum_op real_maybe_prod
  private static boolean real_maybe_sum_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_sum_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_sum_op(b, l + 1);
    r = r && real_maybe_prod(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // num_unary_op real_maybe_unary | real_atom
  public static boolean real_maybe_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_unary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REAL_MAYBE_UNARY, "<real maybe unary>");
    r = real_maybe_unary_0(b, l + 1);
    if (!r) r = real_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // num_unary_op real_maybe_unary
  private static boolean real_maybe_unary_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_maybe_unary_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = num_unary_op(b, l + 1);
    r = r && real_maybe_unary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN real_expr RPAREN
  public static boolean real_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "real_parens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && real_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, REAL_PARENS, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN expr
  public static boolean rule_return(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_return")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && expr(b, l + 1);
    exit_section_(b, m, RULE_RETURN, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE statement_list?
  public static boolean selection_else_branch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_else_branch")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && selection_else_branch_1(b, l + 1);
    exit_section_(b, m, SELECTION_ELSE_BRANCH, r);
    return r;
  }

  // statement_list?
  private static boolean selection_else_branch_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_else_branch_1")) return false;
    statement_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ELSEIF condition THEN statement_list?
  public static boolean selection_elseif_branch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_elseif_branch")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && condition(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && selection_elseif_branch_3(b, l + 1);
    exit_section_(b, m, SELECTION_ELSEIF_BRANCH, r);
    return r;
  }

  // statement_list?
  private static boolean selection_elseif_branch_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_elseif_branch_3")) return false;
    statement_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SET var_ref(LBRACKET int_expr RBRACKET)? ASSIGN_OP expr
  public static boolean set_var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_var")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET);
    r = r && var_ref(b, l + 1);
    r = r && set_var_2(b, l + 1);
    r = r && consumeToken(b, ASSIGN_OP);
    r = r && expr(b, l + 1);
    exit_section_(b, m, SET_VAR, r);
    return r;
  }

  // (LBRACKET int_expr RBRACKET)?
  private static boolean set_var_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_var_2")) return false;
    set_var_2_0(b, l + 1);
    return true;
  }

  // LBRACKET int_expr RBRACKET
  private static boolean set_var_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_var_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && int_expr(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // comment|call_statement | set_var | condition_statement | loop_statement | exitwhen_statement | rule_return | debug_statement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = comment(b, l + 1);
    if (!r) r = call_statement(b, l + 1);
    if (!r) r = set_var(b, l + 1);
    if (!r) r = condition_statement(b, l + 1);
    if (!r) r = loop_statement(b, l + 1);
    if (!r) r = exitwhen_statement(b, l + 1);
    if (!r) r = rule_return(b, l + 1);
    if (!r) r = debug_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement*
  public static boolean statement_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT_LIST, "<statement list>");
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_list", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // string_literals | string_parens | any_expr_atom
  public static boolean string_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_ATOM, "<string atom>");
    r = string_literals(b, l + 1);
    if (!r) r = string_parens(b, l + 1);
    if (!r) r = any_expr_atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLUS
  public static boolean string_concat_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_concat_op")) return false;
    if (!nextTokenIs(b, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    exit_section_(b, m, STRING_CONCAT_OP, r);
    return r;
  }

  /* ********************************************************** */
  // string_maybe_concat
  public static boolean string_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_EXPR, "<string expr>");
    r = string_maybe_concat(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL | null_literal
  public static boolean string_literals(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literals")) return false;
    if (!nextTokenIs(b, "<string literals>", NULL, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERALS, "<string literals>");
    r = consumeToken(b, STRING_LITERAL);
    if (!r) r = null_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string_atom (string_concat_op string_atom)*
  public static boolean string_maybe_concat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_maybe_concat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_MAYBE_CONCAT, "<string maybe concat>");
    r = string_atom(b, l + 1);
    r = r && string_maybe_concat_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (string_concat_op string_atom)*
  private static boolean string_maybe_concat_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_maybe_concat_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_maybe_concat_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_maybe_concat_1", c)) break;
    }
    return true;
  }

  // string_concat_op string_atom
  private static boolean string_maybe_concat_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_maybe_concat_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_concat_op(b, l + 1);
    r = r && string_atom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN string_expr RPAREN
  public static boolean string_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_parens")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && string_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, STRING_PARENS, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE var_type EXTENDS type_ref
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && var_type(b, l + 1);
    r = r && consumeToken(b, EXTENDS);
    r = r && type_ref(b, l + 1);
    exit_section_(b, m, TYPE_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean type_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, TYPE_REF, r);
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
  // ID
  public static boolean var_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_ref")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, VAR_REF, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean var_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_type")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, VAR_TYPE, r);
    return r;
  }

}
