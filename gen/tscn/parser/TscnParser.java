// This is a generated file. Not intended for manual editing.
package tscn.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static tscn.psi.TscnElementTypes.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TscnParser implements PsiParser, LightPsiParser {

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
  // key EQUAL value
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && value(b, l + 1);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY pair_expression? (COMMA pair_expression)* R_CURLY
  public static boolean dictionary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && dictionary_expression_1(b, l + 1);
    r = r && dictionary_expression_2(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, DICTIONARY_EXPRESSION, r);
    return r;
  }

  // pair_expression?
  private static boolean dictionary_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_1")) return false;
    pair_expression(b, l + 1);
    return true;
  }

  // (COMMA pair_expression)*
  private static boolean dictionary_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dictionary_expression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_expression_2", c)) break;
    }
    return true;
  }

  // COMMA pair_expression
  private static boolean dictionary_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pair_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET (NODE_KEYWORD | GD_SCENE_KEYWORD | GD_RESOURCE_KEYWORD | RESOURCE_KEYWORD | IDENTIFIER) attribute* R_BRACKET property*
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && entry_1(b, l + 1);
    r = r && entry_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    r = r && entry_4(b, l + 1);
    exit_section_(b, m, ENTRY, r);
    return r;
  }

  // NODE_KEYWORD | GD_SCENE_KEYWORD | GD_RESOURCE_KEYWORD | RESOURCE_KEYWORD | IDENTIFIER
  private static boolean entry_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_1")) return false;
    boolean r;
    r = consumeToken(b, NODE_KEYWORD);
    if (!r) r = consumeToken(b, GD_SCENE_KEYWORD);
    if (!r) r = consumeToken(b, GD_RESOURCE_KEYWORD);
    if (!r) r = consumeToken(b, RESOURCE_KEYWORD);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  // attribute*
  private static boolean entry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entry_2", c)) break;
    }
    return true;
  }

  // property*
  private static boolean entry_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entry_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // list_expression
  //     | dictionary_expression
  //     | function_expression
  //     | sub_expression
  //     | ext_expression
  //     | primitive
  static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    r = list_expression(b, l + 1);
    if (!r) r = dictionary_expression(b, l + 1);
    if (!r) r = function_expression(b, l + 1);
    if (!r) r = sub_expression(b, l + 1);
    if (!r) r = ext_expression(b, l + 1);
    if (!r) r = primitive(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET EXT_RESOURCE_KEYWORD attribute* R_BRACKET property*
  public static boolean ext_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_entry")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_BRACKET, EXT_RESOURCE_KEYWORD);
    r = r && ext_entry_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    r = r && ext_entry_4(b, l + 1);
    exit_section_(b, m, EXT_ENTRY, r);
    return r;
  }

  // attribute*
  private static boolean ext_entry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_entry_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ext_entry_2", c)) break;
    }
    return true;
  }

  // property*
  private static boolean ext_entry_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_entry_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ext_entry_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EXT_RESOURCE L_PAREN sub_ext_id R_PAREN
  public static boolean ext_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_expression")) return false;
    if (!nextTokenIs(b, EXT_RESOURCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EXT_RESOURCE, L_PAREN);
    r = r && sub_ext_id(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, EXT_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER L_PAREN expression? (COMMA expression)* R_PAREN
  public static boolean function_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_expression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, L_PAREN);
    r = r && function_expression_2(b, l + 1);
    r = r && function_expression_3(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, FUNCTION_EXPRESSION, r);
    return r;
  }

  // expression?
  private static boolean function_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_expression_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean function_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_expression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_expression_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_expression_3", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean function_expression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_expression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (SLASH (IDENTIFIER | NUMBER))*
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && key_1(b, l + 1);
    exit_section_(b, m, KEY, r);
    return r;
  }

  // (SLASH (IDENTIFIER | NUMBER))*
  private static boolean key_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_1", c)) break;
    }
    return true;
  }

  // SLASH (IDENTIFIER | NUMBER)
  private static boolean key_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLASH);
    r = r && key_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER | NUMBER
  private static boolean key_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET expression? (COMMA expression)* R_BRACKET
  public static boolean list_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expression")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && list_expression_1(b, l + 1);
    r = r && list_expression_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, LIST_EXPRESSION, r);
    return r;
  }

  // expression?
  private static boolean list_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expression_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean list_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_expression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_expression_2", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean list_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression COLON expression
  public static boolean pair_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAIR_EXPRESSION, "<pair expression>");
    r = expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // resource_string
  //     | string
  //     | NULL
  //     | TRUE
  //     | FALSE
  //     | NUMBER
  static boolean primitive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive")) return false;
    boolean r;
    r = resource_string(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // key EQUAL value
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && value(b, l + 1);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  /* ********************************************************** */
  // SINGLE_QUOTED_RESOURCE_STRING | DOUBLE_QUOTED_RESOURCE_STRING
  public static boolean resource_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_string")) return false;
    if (!nextTokenIs(b, "<resource string>", DOUBLE_QUOTED_RESOURCE_STRING, SINGLE_QUOTED_RESOURCE_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE_STRING, "<resource string>");
    r = consumeToken(b, SINGLE_QUOTED_RESOURCE_STRING);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_RESOURCE_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // top_level_rule*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!top_level_rule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SINGLE_QUOTED_STRING | DOUBLE_QUOTED_STRING
  static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, "", DOUBLE_QUOTED_STRING, SINGLE_QUOTED_STRING)) return false;
    boolean r;
    r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET SUB_RESOURCE_KEYWORD attribute* R_BRACKET property*
  public static boolean sub_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_entry")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_BRACKET, SUB_RESOURCE_KEYWORD);
    r = r && sub_entry_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    r = r && sub_entry_4(b, l + 1);
    exit_section_(b, m, SUB_ENTRY, r);
    return r;
  }

  // attribute*
  private static boolean sub_entry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_entry_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sub_entry_2", c)) break;
    }
    return true;
  }

  // property*
  private static boolean sub_entry_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_entry_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sub_entry_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SUB_RESOURCE L_PAREN sub_ext_id R_PAREN
  public static boolean sub_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_expression")) return false;
    if (!nextTokenIs(b, SUB_RESOURCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SUB_RESOURCE, L_PAREN);
    r = r && sub_ext_id(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, SUB_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | string
  static boolean sub_ext_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_ext_id")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = string(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // entry | ext_entry | sub_entry | property
  static boolean top_level_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_rule")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, L_BRACKET)) return false;
    boolean r;
    r = entry(b, l + 1);
    if (!r) r = ext_entry(b, l + 1);
    if (!r) r = sub_entry(b, l + 1);
    if (!r) r = property(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
