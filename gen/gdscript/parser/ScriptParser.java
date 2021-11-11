// This is a generated file. Not intended for manual editing.
package gdscript.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static gdscript.psi.ScriptElementTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ScriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // (VAR? expression) | DOT_DOT | UNDERSCORE
  public static boolean array_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_ARGUMENT, "<array argument>");
    r = array_argument_0(b, l + 1);
    if (!r) r = consumeToken(b, DOT_DOT);
    if (!r) r = consumeToken(b, UNDERSCORE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VAR? expression
  private static boolean array_argument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_argument_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_argument_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VAR?
  private static boolean array_argument_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_argument_0_0")) return false;
    consumeToken(b, VAR);
    return true;
  }

  /* ********************************************************** */
  // id? L_BRACKET LINE_BREAK* array_argument? LINE_BREAK* (COMMA LINE_BREAK* array_argument LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACKET
  public static boolean array_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_EXPRESSION, "<array expression>");
    r = array_expression_0(b, l + 1);
    r = r && consumeToken(b, L_BRACKET);
    r = r && array_expression_2(b, l + 1);
    r = r && array_expression_3(b, l + 1);
    r = r && array_expression_4(b, l + 1);
    r = r && array_expression_5(b, l + 1);
    r = r && array_expression_6(b, l + 1);
    r = r && array_expression_7(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // id?
  private static boolean array_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_0")) return false;
    id(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "array_expression_2", c)) break;
    }
    return true;
  }

  // array_argument?
  private static boolean array_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_3")) return false;
    array_argument(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "array_expression_4", c)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* array_argument LINE_BREAK*)*
  private static boolean array_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_expression_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_expression_5", c)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* array_argument LINE_BREAK*
  private static boolean array_expression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && array_expression_5_0_1(b, l + 1);
    r = r && array_argument(b, l + 1);
    r = r && array_expression_5_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean array_expression_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "array_expression_5_0_1", c)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_5_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_5_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "array_expression_5_0_3", c)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean array_expression_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_6")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean array_expression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expression_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "array_expression_7", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ASSERT expression
  public static boolean assert_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_statement")) return false;
    if (!nextTokenIs(b, ASSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSERT);
    r = r && expression(b, l + 1);
    exit_section_(b, m, ASSERT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // EQUAL
  //     | PLUS_EQUAL
  //     | MINUS_EQUAL
  //     | STAR_EQUAL
  //     | SLASH_EQUAL
  //     | PERCENT_EQUAL
  //     | LESS_LESS_EQUAL
  //     | GREATER_GREATER_EQUAL
  //     | AMPERSAND_EQUAL
  //     | PIPE_EQUAL
  //     | CARET_EQUAL
  //     | INFER
  static boolean assign_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_operator")) return false;
    boolean r;
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, PLUS_EQUAL);
    if (!r) r = consumeToken(b, MINUS_EQUAL);
    if (!r) r = consumeToken(b, STAR_EQUAL);
    if (!r) r = consumeToken(b, SLASH_EQUAL);
    if (!r) r = consumeToken(b, PERCENT_EQUAL);
    if (!r) r = consumeToken(b, LESS_LESS_EQUAL);
    if (!r) r = consumeToken(b, GREATER_GREATER_EQUAL);
    if (!r) r = consumeToken(b, AMPERSAND_EQUAL);
    if (!r) r = consumeToken(b, PIPE_EQUAL);
    if (!r) r = consumeToken(b, CARET_EQUAL);
    if (!r) r = consumeToken(b, INFER);
    return r;
  }

  /* ********************************************************** */
  // expression assign_operator expression
  public static boolean assign_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_STATEMENT, "<assign statement>");
    r = expression(b, l + 1);
    r = r && assign_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AWAIT expression
  public static boolean await_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "await_statement")) return false;
    if (!nextTokenIs(b, AWAIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AWAIT);
    r = r && expression(b, l + 1);
    exit_section_(b, m, AWAIT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // INDENT statement DEDENT
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && statement(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS id (EXTENDS type)? COLON
  public static boolean class_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement")) return false;
    if (!nextTokenIs(b, CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    r = r && id(b, l + 1);
    r = r && class_statement_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, CLASS_STATEMENT, r);
    return r;
  }

  // (EXTENDS type)?
  private static boolean class_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_2")) return false;
    class_statement_2_0(b, l + 1);
    return true;
  }

  // EXTENDS type
  private static boolean class_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS_NAME id (COMMA string)?
  public static boolean classname_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classname_statement")) return false;
    if (!nextTokenIs(b, CLASS_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS_NAME);
    r = r && id(b, l + 1);
    r = r && classname_statement_2(b, l + 1);
    exit_section_(b, m, CLASSNAME_STATEMENT, r);
    return r;
  }

  // (COMMA string)?
  private static boolean classname_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classname_statement_2")) return false;
    classname_statement_2_0(b, l + 1);
    return true;
  }

  // COMMA string
  private static boolean classname_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classname_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // func_statement
  //     | if_statement
  //     | elif_statement
  //     | else_statement
  //     | for_statement
  //     | class_statement
  //     | while_statement
  //     | match_statement
  //     | match_label_statement
  static boolean colon_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colon_statement")) return false;
    boolean r;
    r = func_statement(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = elif_statement(b, l + 1);
    if (!r) r = else_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = class_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = match_statement(b, l + 1);
    if (!r) r = match_label_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // CONST id (COLON type)? (EQUAL expression)
  public static boolean const_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_statement")) return false;
    if (!nextTokenIs(b, CONST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONST);
    r = r && id(b, l + 1);
    r = r && const_statement_2(b, l + 1);
    r = r && const_statement_3(b, l + 1);
    exit_section_(b, m, CONST_STATEMENT, r);
    return r;
  }

  // (COLON type)?
  private static boolean const_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_statement_2")) return false;
    const_statement_2_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean const_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUAL expression
  private static boolean const_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (key LINE_BREAK* (COLON LINE_BREAK* VAR? expression)?) | DOT_DOT
  public static boolean dictionary_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICTIONARY_ENTRY, "<dictionary entry>");
    r = dictionary_entry_0(b, l + 1);
    if (!r) r = consumeToken(b, DOT_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // key LINE_BREAK* (COLON LINE_BREAK* VAR? expression)?
  private static boolean dictionary_entry_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && dictionary_entry_0_1(b, l + 1);
    r = r && dictionary_entry_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean dictionary_entry_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_entry_0_1", c)) break;
    }
    return true;
  }

  // (COLON LINE_BREAK* VAR? expression)?
  private static boolean dictionary_entry_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry_0_2")) return false;
    dictionary_entry_0_2_0(b, l + 1);
    return true;
  }

  // COLON LINE_BREAK* VAR? expression
  private static boolean dictionary_entry_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && dictionary_entry_0_2_0_1(b, l + 1);
    r = r && dictionary_entry_0_2_0_2(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean dictionary_entry_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry_0_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_entry_0_2_0_1", c)) break;
    }
    return true;
  }

  // VAR?
  private static boolean dictionary_entry_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry_0_2_0_2")) return false;
    consumeToken(b, VAR);
    return true;
  }

  /* ********************************************************** */
  // L_BRACE LINE_BREAK* dictionary_entry? LINE_BREAK* (COMMA LINE_BREAK* dictionary_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE
  public static boolean dictionary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression")) return false;
    if (!nextTokenIs(b, L_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACE);
    r = r && dictionary_expression_1(b, l + 1);
    r = r && dictionary_expression_2(b, l + 1);
    r = r && dictionary_expression_3(b, l + 1);
    r = r && dictionary_expression_4(b, l + 1);
    r = r && dictionary_expression_5(b, l + 1);
    r = r && dictionary_expression_6(b, l + 1);
    r = r && consumeToken(b, R_BRACE);
    exit_section_(b, m, DICTIONARY_EXPRESSION, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_expression_1", c)) break;
    }
    return true;
  }

  // dictionary_entry?
  private static boolean dictionary_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_2")) return false;
    dictionary_entry(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_expression_3", c)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* dictionary_entry LINE_BREAK*)*
  private static boolean dictionary_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dictionary_expression_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_expression_4", c)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* dictionary_entry LINE_BREAK*
  private static boolean dictionary_expression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && dictionary_expression_4_0_1(b, l + 1);
    r = r && dictionary_entry(b, l + 1);
    r = r && dictionary_expression_4_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_expression_4_0_1", c)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_4_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_expression_4_0_3", c)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean dictionary_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_5")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean dictionary_expression_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_expression_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ELIF expression COLON
  public static boolean elif_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elif_statement")) return false;
    if (!nextTokenIs(b, ELIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELIF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, ELIF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE COLON
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, COLON);
    exit_section_(b, m, ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // id (EQUAL expression)?
  public static boolean enum_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_ENTRY, "<enum entry>");
    r = id(b, l + 1);
    r = r && enum_entry_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (EQUAL expression)?
  private static boolean enum_entry_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_entry_1")) return false;
    enum_entry_1_0(b, l + 1);
    return true;
  }

  // EQUAL expression
  private static boolean enum_entry_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_entry_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ENUM id? (L_BRACE LINE_BREAK* enum_entry? LINE_BREAK* (COMMA LINE_BREAK* enum_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE)?
  public static boolean enum_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement")) return false;
    if (!nextTokenIs(b, ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    r = r && enum_statement_1(b, l + 1);
    r = r && enum_statement_2(b, l + 1);
    exit_section_(b, m, ENUM_STATEMENT, r);
    return r;
  }

  // id?
  private static boolean enum_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_1")) return false;
    id(b, l + 1);
    return true;
  }

  // (L_BRACE LINE_BREAK* enum_entry? LINE_BREAK* (COMMA LINE_BREAK* enum_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE)?
  private static boolean enum_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2")) return false;
    enum_statement_2_0(b, l + 1);
    return true;
  }

  // L_BRACE LINE_BREAK* enum_entry? LINE_BREAK* (COMMA LINE_BREAK* enum_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE
  private static boolean enum_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACE);
    r = r && enum_statement_2_0_1(b, l + 1);
    r = r && enum_statement_2_0_2(b, l + 1);
    r = r && enum_statement_2_0_3(b, l + 1);
    r = r && enum_statement_2_0_4(b, l + 1);
    r = r && enum_statement_2_0_5(b, l + 1);
    r = r && enum_statement_2_0_6(b, l + 1);
    r = r && consumeToken(b, R_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "enum_statement_2_0_1", c)) break;
    }
    return true;
  }

  // enum_entry?
  private static boolean enum_statement_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_2")) return false;
    enum_entry(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "enum_statement_2_0_3", c)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* enum_entry LINE_BREAK*)*
  private static boolean enum_statement_2_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_statement_2_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_statement_2_0_4", c)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* enum_entry LINE_BREAK*
  private static boolean enum_statement_2_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enum_statement_2_0_4_0_1(b, l + 1);
    r = r && enum_entry(b, l + 1);
    r = r && enum_statement_2_0_4_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "enum_statement_2_0_4_0_1", c)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_4_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "enum_statement_2_0_4_0_3", c)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean enum_statement_2_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_5")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean enum_statement_2_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_statement_2_0_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "enum_statement_2_0_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // AT_EXPORT
  //     | AT_EXPORT_ENUM
  //     | AT_EXPORT_FILE
  //     | AT_EXPORT_DIR
  //     | AT_EXPORT_GLOBAL_FILE
  //     | AT_EXPORT_GLOBAL_DIR
  //     | AT_EXPORT_MULTILINE
  //     | AT_EXPORT_PLACEHOLDER
  //     | AT_EXPORT_RANGE
  //     | AT_EXPORT_EXP_EASING
  //     | AT_EXPORT_COLOR_NO_ALPHA
  //     | AT_EXPORT_NODE_PATH
  //     | AT_EXPORT_FLAGS
  //     | AT_EXPORT_FLAGS_2D_RENDER
  //     | AT_EXPORT_FLAGS_2D_PHYSICS
  //     | AT_EXPORT_FLAGS_2D_NAVIGATION
  //     | AT_EXPORT_FLAGS_3D_RENDER
  //     | AT_EXPORT_FLAGS_3D_PHYSICS
  //     | AT_EXPORT_FLAGS_3D_NAVIGATION
  static boolean export_annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export_annotation")) return false;
    boolean r;
    r = consumeToken(b, AT_EXPORT);
    if (!r) r = consumeToken(b, AT_EXPORT_ENUM);
    if (!r) r = consumeToken(b, AT_EXPORT_FILE);
    if (!r) r = consumeToken(b, AT_EXPORT_DIR);
    if (!r) r = consumeToken(b, AT_EXPORT_GLOBAL_FILE);
    if (!r) r = consumeToken(b, AT_EXPORT_GLOBAL_DIR);
    if (!r) r = consumeToken(b, AT_EXPORT_MULTILINE);
    if (!r) r = consumeToken(b, AT_EXPORT_PLACEHOLDER);
    if (!r) r = consumeToken(b, AT_EXPORT_RANGE);
    if (!r) r = consumeToken(b, AT_EXPORT_EXP_EASING);
    if (!r) r = consumeToken(b, AT_EXPORT_COLOR_NO_ALPHA);
    if (!r) r = consumeToken(b, AT_EXPORT_NODE_PATH);
    if (!r) r = consumeToken(b, AT_EXPORT_FLAGS);
    if (!r) r = consumeToken(b, AT_EXPORT_FLAGS_2D_RENDER);
    if (!r) r = consumeToken(b, AT_EXPORT_FLAGS_2D_PHYSICS);
    if (!r) r = consumeToken(b, AT_EXPORT_FLAGS_2D_NAVIGATION);
    if (!r) r = consumeToken(b, AT_EXPORT_FLAGS_3D_RENDER);
    if (!r) r = consumeToken(b, AT_EXPORT_FLAGS_3D_PHYSICS);
    if (!r) r = consumeToken(b, AT_EXPORT_FLAGS_3D_NAVIGATION);
    return r;
  }

  /* ********************************************************** */
  // (operand | operator)+
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!expression_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // operand | operator
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    r = operand(b, l + 1);
    if (!r) r = operator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean expression_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EXTENDS (type | string) (DOT IDENTIFIER)*
  public static boolean extends_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement")) return false;
    if (!nextTokenIs(b, EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && extends_statement_1(b, l + 1);
    r = r && extends_statement_2(b, l + 1);
    exit_section_(b, m, EXTENDS_STATEMENT, r);
    return r;
  }

  // type | string
  private static boolean extends_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_1")) return false;
    boolean r;
    r = type(b, l + 1);
    if (!r) r = string(b, l + 1);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean extends_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!extends_statement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extends_statement_2", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean extends_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR id IN expression COLON
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // id (COLON type)? ((EQUAL | INFER) expression)?
  public static boolean func_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_ARGUMENT, "<func argument>");
    r = id(b, l + 1);
    r = r && func_argument_1(b, l + 1);
    r = r && func_argument_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COLON type)?
  private static boolean func_argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_argument_1")) return false;
    func_argument_1_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean func_argument_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_argument_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((EQUAL | INFER) expression)?
  private static boolean func_argument_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_argument_2")) return false;
    func_argument_2_0(b, l + 1);
    return true;
  }

  // (EQUAL | INFER) expression
  private static boolean func_argument_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_argument_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_argument_2_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUAL | INFER
  private static boolean func_argument_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_argument_2_0_0")) return false;
    boolean r;
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, INFER);
    return r;
  }

  /* ********************************************************** */
  // STATIC? network_modifier? FUNC id L_PAREN LINE_BREAK* func_argument? LINE_BREAK* (COMMA LINE_BREAK* func_argument LINE_BREAK*)* COMMA? LINE_BREAK* R_PAREN (ARROW type)? COLON block?
  public static boolean func_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_STATEMENT, "<func statement>");
    r = func_statement_0(b, l + 1);
    r = r && func_statement_1(b, l + 1);
    r = r && consumeToken(b, FUNC);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, L_PAREN);
    r = r && func_statement_5(b, l + 1);
    r = r && func_statement_6(b, l + 1);
    r = r && func_statement_7(b, l + 1);
    r = r && func_statement_8(b, l + 1);
    r = r && func_statement_9(b, l + 1);
    r = r && func_statement_10(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    r = r && func_statement_12(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && func_statement_14(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STATIC?
  private static boolean func_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_0")) return false;
    consumeToken(b, STATIC);
    return true;
  }

  // network_modifier?
  private static boolean func_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_1")) return false;
    network_modifier(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "func_statement_5", c)) break;
    }
    return true;
  }

  // func_argument?
  private static boolean func_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_6")) return false;
    func_argument(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "func_statement_7", c)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* func_argument LINE_BREAK*)*
  private static boolean func_statement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_8")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_statement_8_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_statement_8", c)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* func_argument LINE_BREAK*
  private static boolean func_statement_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && func_statement_8_0_1(b, l + 1);
    r = r && func_argument(b, l + 1);
    r = r && func_statement_8_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean func_statement_8_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_8_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "func_statement_8_0_1", c)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_8_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_8_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "func_statement_8_0_3", c)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean func_statement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_9")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean func_statement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_10")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "func_statement_10", c)) break;
    }
    return true;
  }

  // (ARROW type)?
  private static boolean func_statement_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_12")) return false;
    func_statement_12_0(b, l + 1);
    return true;
  }

  // ARROW type
  private static boolean func_statement_12_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_12_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // block?
  private static boolean func_statement_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_statement_14")) return false;
    block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // AT_ICON L_PAREN string R_PAREN
  public static boolean icon_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "icon_statement")) return false;
    if (!nextTokenIs(b, AT_ICON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT_ICON, L_PAREN);
    r = r && string(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, ICON_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | INT | FLOAT | BOOL | VOID | NODE_PATH
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID, "<id>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, VOID);
    if (!r) r = consumeToken(b, NODE_PATH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF expression COLON
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // id? L_PAREN LINE_BREAK* expression? LINE_BREAK* (COMMA LINE_BREAK* expression LINE_BREAK*)* R_PAREN
  public static boolean invocation_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INVOCATION_EXPRESSION, "<invocation expression>");
    r = invocation_expression_0(b, l + 1);
    r = r && consumeToken(b, L_PAREN);
    r = r && invocation_expression_2(b, l + 1);
    r = r && invocation_expression_3(b, l + 1);
    r = r && invocation_expression_4(b, l + 1);
    r = r && invocation_expression_5(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // id?
  private static boolean invocation_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_0")) return false;
    id(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "invocation_expression_2", c)) break;
    }
    return true;
  }

  // expression?
  private static boolean invocation_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_3")) return false;
    expression(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "invocation_expression_4", c)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* expression LINE_BREAK*)*
  private static boolean invocation_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!invocation_expression_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "invocation_expression_5", c)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* expression LINE_BREAK*
  private static boolean invocation_expression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && invocation_expression_5_0_1(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && invocation_expression_5_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "invocation_expression_5_0_1", c)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean invocation_expression_5_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invocation_expression_5_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "invocation_expression_5_0_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY, "<key>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FUNC id? L_PAREN id? (COMMA id)* R_PAREN COLON expression
  public static boolean lambda_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expression")) return false;
    if (!nextTokenIs(b, FUNC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNC);
    r = r && lambda_expression_1(b, l + 1);
    r = r && consumeToken(b, L_PAREN);
    r = r && lambda_expression_3(b, l + 1);
    r = r && lambda_expression_4(b, l + 1);
    r = r && consumeTokens(b, 0, R_PAREN, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, LAMBDA_EXPRESSION, r);
    return r;
  }

  // id?
  private static boolean lambda_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expression_1")) return false;
    id(b, l + 1);
    return true;
  }

  // id?
  private static boolean lambda_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expression_3")) return false;
    id(b, l + 1);
    return true;
  }

  // (COMMA id)*
  private static boolean lambda_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expression_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambda_expression_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambda_expression_4", c)) break;
    }
    return true;
  }

  // COMMA id
  private static boolean lambda_expression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (key EQUAL expression) | DOT_DOT
  public static boolean lua_dictionary_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LUA_DICTIONARY_ENTRY, "<lua dictionary entry>");
    r = lua_dictionary_entry_0(b, l + 1);
    if (!r) r = consumeToken(b, DOT_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // key EQUAL expression
  private static boolean lua_dictionary_entry_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_entry_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_BRACE LINE_BREAK* lua_dictionary_entry? LINE_BREAK* (COMMA LINE_BREAK* lua_dictionary_entry LINE_BREAK*)* COMMA? LINE_BREAK* R_BRACE
  public static boolean lua_dictionary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression")) return false;
    if (!nextTokenIs(b, L_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACE);
    r = r && lua_dictionary_expression_1(b, l + 1);
    r = r && lua_dictionary_expression_2(b, l + 1);
    r = r && lua_dictionary_expression_3(b, l + 1);
    r = r && lua_dictionary_expression_4(b, l + 1);
    r = r && lua_dictionary_expression_5(b, l + 1);
    r = r && lua_dictionary_expression_6(b, l + 1);
    r = r && consumeToken(b, R_BRACE);
    exit_section_(b, m, LUA_DICTIONARY_EXPRESSION, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "lua_dictionary_expression_1", c)) break;
    }
    return true;
  }

  // lua_dictionary_entry?
  private static boolean lua_dictionary_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_2")) return false;
    lua_dictionary_entry(b, l + 1);
    return true;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "lua_dictionary_expression_3", c)) break;
    }
    return true;
  }

  // (COMMA LINE_BREAK* lua_dictionary_entry LINE_BREAK*)*
  private static boolean lua_dictionary_expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lua_dictionary_expression_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lua_dictionary_expression_4", c)) break;
    }
    return true;
  }

  // COMMA LINE_BREAK* lua_dictionary_entry LINE_BREAK*
  private static boolean lua_dictionary_expression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && lua_dictionary_expression_4_0_1(b, l + 1);
    r = r && lua_dictionary_entry(b, l + 1);
    r = r && lua_dictionary_expression_4_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "lua_dictionary_expression_4_0_1", c)) break;
    }
    return true;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_4_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "lua_dictionary_expression_4_0_3", c)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean lua_dictionary_expression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_5")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // LINE_BREAK*
  private static boolean lua_dictionary_expression_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_dictionary_expression_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINE_BREAK)) break;
      if (!empty_element_parsed_guard_(b, "lua_dictionary_expression_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression | UNDERSCORE
  public static boolean match_label_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_label_argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_LABEL_ARGUMENT, "<match label argument>");
    r = expression(b, l + 1);
    if (!r) r = consumeToken(b, UNDERSCORE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // match_label_argument (COMMA match_label_argument)* COLON
  public static boolean match_label_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_label_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_LABEL_STATEMENT, "<match label statement>");
    r = match_label_argument(b, l + 1);
    r = r && match_label_statement_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA match_label_argument)*
  private static boolean match_label_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_label_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!match_label_statement_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_label_statement_1", c)) break;
    }
    return true;
  }

  // COMMA match_label_argument
  private static boolean match_label_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_label_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && match_label_argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MATCH expression COLON
  public static boolean match_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // MULTILINE_SINGLE_QUOTED_STRING | MULTILINE_DOUBLE_QUOTED_STRING
  static boolean multiline_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_string")) return false;
    if (!nextTokenIs(b, "", MULTILINE_DOUBLE_QUOTED_STRING, MULTILINE_SINGLE_QUOTED_STRING)) return false;
    boolean r;
    r = consumeToken(b, MULTILINE_SINGLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, MULTILINE_DOUBLE_QUOTED_STRING);
    return r;
  }

  /* ********************************************************** */
  // MASTER
  //     | SYNC
  //     | PUPPET
  //     | REMOTE
  //     | MASTERSYNC
  //     | PUPPETSYNC
  //     | REMOTESYNC
  //     | AT_MASTER
  //     | AT_PUPPET
  //     | AT_REMOTE
  //     | AT_MASTERSYNC
  //     | AT_PUPPETSYNC
  //     | AT_REMOTESYNC
  static boolean network_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "network_modifier")) return false;
    boolean r;
    r = consumeToken(b, MASTER);
    if (!r) r = consumeToken(b, SYNC);
    if (!r) r = consumeToken(b, PUPPET);
    if (!r) r = consumeToken(b, REMOTE);
    if (!r) r = consumeToken(b, MASTERSYNC);
    if (!r) r = consumeToken(b, PUPPETSYNC);
    if (!r) r = consumeToken(b, REMOTESYNC);
    if (!r) r = consumeToken(b, AT_MASTER);
    if (!r) r = consumeToken(b, AT_PUPPET);
    if (!r) r = consumeToken(b, AT_REMOTE);
    if (!r) r = consumeToken(b, AT_MASTERSYNC);
    if (!r) r = consumeToken(b, AT_PUPPETSYNC);
    if (!r) r = consumeToken(b, AT_REMOTESYNC);
    return r;
  }

  /* ********************************************************** */
  // var_statement
  //     | const_statement
  //     | extends_statement
  //     | enum_statement
  //     | tool_statement
  //     | icon_statement
  //     | return_statement
  //     | signal_statement
  //     | classname_statement
  //     | assert_statement
  //     | await_statement
  //     | yield_statement
  //     | assign_statement
  //     | expression_statement
  //     | PASS
  //     | BREAK
  //     | CONTINUE
  //     | BREAKPOINT
  static boolean non_colon_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_colon_statement")) return false;
    boolean r;
    r = var_statement(b, l + 1);
    if (!r) r = const_statement(b, l + 1);
    if (!r) r = extends_statement(b, l + 1);
    if (!r) r = enum_statement(b, l + 1);
    if (!r) r = tool_statement(b, l + 1);
    if (!r) r = icon_statement(b, l + 1);
    if (!r) r = return_statement(b, l + 1);
    if (!r) r = signal_statement(b, l + 1);
    if (!r) r = classname_statement(b, l + 1);
    if (!r) r = assert_statement(b, l + 1);
    if (!r) r = await_statement(b, l + 1);
    if (!r) r = yield_statement(b, l + 1);
    if (!r) r = assign_statement(b, l + 1);
    if (!r) r = expression_statement(b, l + 1);
    if (!r) r = consumeToken(b, PASS);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, BREAKPOINT);
    return r;
  }

  /* ********************************************************** */
  // array_expression
  //     | dictionary_expression
  //     | lua_dictionary_expression
  //     | invocation_expression
  //     | lambda_expression
  //     | string
  //     | multiline_string
  //     | id
  //     | REAL_NUMBER
  //     | BINARY_NUMBER
  //     | HEXADECIMAL_NUMBER
  //     | TRUE
  //     | FALSE
  //     | NULL
  //     | SELF
  static boolean operand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operand")) return false;
    boolean r;
    r = array_expression(b, l + 1);
    if (!r) r = dictionary_expression(b, l + 1);
    if (!r) r = lua_dictionary_expression(b, l + 1);
    if (!r) r = invocation_expression(b, l + 1);
    if (!r) r = lambda_expression(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = multiline_string(b, l + 1);
    if (!r) r = id(b, l + 1);
    if (!r) r = consumeToken(b, REAL_NUMBER);
    if (!r) r = consumeToken(b, BINARY_NUMBER);
    if (!r) r = consumeToken(b, HEXADECIMAL_NUMBER);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, SELF);
    return r;
  }

  /* ********************************************************** */
  // LESS
  //     | LESS_EQUAL
  //     | GREATER
  //     | GREATER_EQUAL
  //     | EQUAL_EQUAL
  //     | BANG_EQUAL
  //     | AMPERSAND_AMPERSAND
  //     | PIPE_PIPE
  //     | BANG
  //     | AMPERSAND
  //     | PIPE
  //     | TILDE
  //     | CARET
  //     | LESS_LESS
  //     | GREATER_GREATER
  //     | PLUS
  //     | MINUS
  //     | STAR
  //     | SLASH
  //     | PERCENT
  //     | DOT
  //     | DOT_DOT
  //     | IS
  //     | AS
  //     | IN
  //     | AND
  //     | OR
  //     | NOT
  //     | IF
  //     | ELSE
  static boolean operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator")) return false;
    boolean r;
    r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    if (!r) r = consumeToken(b, EQUAL_EQUAL);
    if (!r) r = consumeToken(b, BANG_EQUAL);
    if (!r) r = consumeToken(b, AMPERSAND_AMPERSAND);
    if (!r) r = consumeToken(b, PIPE_PIPE);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, LESS_LESS);
    if (!r) r = consumeToken(b, GREATER_GREATER);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, DOT_DOT);
    if (!r) r = consumeToken(b, IS);
    if (!r) r = consumeToken(b, AS);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, ELSE);
    return r;
  }

  /* ********************************************************** */
  // RETURN expression?
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && return_statement_1(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // expression?
  private static boolean return_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // statement*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SIGNAL id (L_PAREN id? (COMMA id)* R_PAREN)?
  public static boolean signal_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_statement")) return false;
    if (!nextTokenIs(b, SIGNAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SIGNAL);
    r = r && id(b, l + 1);
    r = r && signal_statement_2(b, l + 1);
    exit_section_(b, m, SIGNAL_STATEMENT, r);
    return r;
  }

  // (L_PAREN id? (COMMA id)* R_PAREN)?
  private static boolean signal_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_statement_2")) return false;
    signal_statement_2_0(b, l + 1);
    return true;
  }

  // L_PAREN id? (COMMA id)* R_PAREN
  private static boolean signal_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && signal_statement_2_0_1(b, l + 1);
    r = r && signal_statement_2_0_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // id?
  private static boolean signal_statement_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_statement_2_0_1")) return false;
    id(b, l + 1);
    return true;
  }

  // (COMMA id)*
  private static boolean signal_statement_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_statement_2_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!signal_statement_2_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "signal_statement_2_0_2", c)) break;
    }
    return true;
  }

  // COMMA id
  private static boolean signal_statement_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signal_statement_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (colon_statement LINE_BREAK?) | (non_colon_statement (LINE_BREAK | <<eof>> | SEMICOLON+)) | LINE_BREAK
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = consumeToken(b, LINE_BREAK);
    exit_section_(b, m, null, r);
    return r;
  }

  // colon_statement LINE_BREAK?
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = colon_statement(b, l + 1);
    r = r && statement_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK?
  private static boolean statement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_1")) return false;
    consumeToken(b, LINE_BREAK);
    return true;
  }

  // non_colon_statement (LINE_BREAK | <<eof>> | SEMICOLON+)
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = non_colon_statement(b, l + 1);
    r = r && statement_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LINE_BREAK | <<eof>> | SEMICOLON+
  private static boolean statement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_BREAK);
    if (!r) r = eof(b, l + 1);
    if (!r) r = statement_1_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON+
  private static boolean statement_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SEMICOLON)) break;
      if (!empty_element_parsed_guard_(b, "statement_1_1_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SINGLE_QUOTED_STRING | DOUBLE_QUOTED_STRING
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, "<string>", DOUBLE_QUOTED_STRING, SINGLE_QUOTED_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TOOL | AT_TOOL
  public static boolean tool_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tool_statement")) return false;
    if (!nextTokenIs(b, "<tool statement>", AT_TOOL, TOOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOOL_STATEMENT, "<tool statement>");
    r = consumeToken(b, TOOL);
    if (!r) r = consumeToken(b, AT_TOOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id (L_BRACKET id R_BRACKET)?
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = id(b, l + 1);
    r = r && type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (L_BRACKET id R_BRACKET)?
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    type_1_0(b, l + 1);
    return true;
  }

  // L_BRACKET id R_BRACKET
  private static boolean type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (EXPORT | export_annotation) (L_PAREN expression? (COMMA expression)* R_PAREN)?
  public static boolean var_export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_export")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_EXPORT, "<var export>");
    r = var_export_0(b, l + 1);
    r = r && var_export_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPORT | export_annotation
  private static boolean var_export_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_export_0")) return false;
    boolean r;
    r = consumeToken(b, EXPORT);
    if (!r) r = export_annotation(b, l + 1);
    return r;
  }

  // (L_PAREN expression? (COMMA expression)* R_PAREN)?
  private static boolean var_export_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_export_1")) return false;
    var_export_1_0(b, l + 1);
    return true;
  }

  // L_PAREN expression? (COMMA expression)* R_PAREN
  private static boolean var_export_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_export_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && var_export_1_0_1(b, l + 1);
    r = r && var_export_1_0_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression?
  private static boolean var_export_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_export_1_0_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean var_export_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_export_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!var_export_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "var_export_1_0_2", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean var_export_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_export_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean var_getter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_getter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_GETTER, "<var getter>");
    r = id(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean var_setter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_setter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_SETTER, "<var setter>");
    r = id(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // var_export? (ONREADY | AT_ONREADY)? network_modifier? VAR id (COLON type)? ((EQUAL | INFER) expression)?
  //     (SETGET var_setter? (COMMA var_getter)?)?
  public static boolean var_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_STATEMENT, "<var statement>");
    r = var_statement_0(b, l + 1);
    r = r && var_statement_1(b, l + 1);
    r = r && var_statement_2(b, l + 1);
    r = r && consumeToken(b, VAR);
    r = r && id(b, l + 1);
    r = r && var_statement_5(b, l + 1);
    r = r && var_statement_6(b, l + 1);
    r = r && var_statement_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // var_export?
  private static boolean var_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_0")) return false;
    var_export(b, l + 1);
    return true;
  }

  // (ONREADY | AT_ONREADY)?
  private static boolean var_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_1")) return false;
    var_statement_1_0(b, l + 1);
    return true;
  }

  // ONREADY | AT_ONREADY
  private static boolean var_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_1_0")) return false;
    boolean r;
    r = consumeToken(b, ONREADY);
    if (!r) r = consumeToken(b, AT_ONREADY);
    return r;
  }

  // network_modifier?
  private static boolean var_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_2")) return false;
    network_modifier(b, l + 1);
    return true;
  }

  // (COLON type)?
  private static boolean var_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_5")) return false;
    var_statement_5_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean var_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((EQUAL | INFER) expression)?
  private static boolean var_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_6")) return false;
    var_statement_6_0(b, l + 1);
    return true;
  }

  // (EQUAL | INFER) expression
  private static boolean var_statement_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_statement_6_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUAL | INFER
  private static boolean var_statement_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_6_0_0")) return false;
    boolean r;
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, INFER);
    return r;
  }

  // (SETGET var_setter? (COMMA var_getter)?)?
  private static boolean var_statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_7")) return false;
    var_statement_7_0(b, l + 1);
    return true;
  }

  // SETGET var_setter? (COMMA var_getter)?
  private static boolean var_statement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETGET);
    r = r && var_statement_7_0_1(b, l + 1);
    r = r && var_statement_7_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // var_setter?
  private static boolean var_statement_7_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_7_0_1")) return false;
    var_setter(b, l + 1);
    return true;
  }

  // (COMMA var_getter)?
  private static boolean var_statement_7_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_7_0_2")) return false;
    var_statement_7_0_2_0(b, l + 1);
    return true;
  }

  // COMMA var_getter
  private static boolean var_statement_7_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_7_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && var_getter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE expression COLON
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // YIELD expression
  public static boolean yield_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yield_statement")) return false;
    if (!nextTokenIs(b, YIELD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YIELD);
    r = r && expression(b, l + 1);
    exit_section_(b, m, YIELD_STATEMENT, r);
    return r;
  }

}
