// This is a generated file. Not intended for manual editing.
package tscn.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static tscn.psi.TscnElementTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

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
  // L_CURLY dictionary_entry? (COMMA dictionary_entry)* R_CURLY
  static boolean dictionary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && dictionary_1(b, l + 1);
    r = r && dictionary_2(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, null, r);
    return r;
  }

  // dictionary_entry?
  private static boolean dictionary_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_1")) return false;
    dictionary_entry(b, l + 1);
    return true;
  }

  // (COMMA dictionary_entry)*
  private static boolean dictionary_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dictionary_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dictionary_2", c)) break;
    }
    return true;
  }

  // COMMA dictionary_entry
  private static boolean dictionary_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && dictionary_entry(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression COLON expression
  static boolean dictionary_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionary_entry")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET entry_name attribute* R_BRACKET property*
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && entry_name(b, l + 1);
    r = r && entry_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    r = r && entry_4(b, l + 1);
    exit_section_(b, m, ENTRY, r);
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
  // NODE_KEYWORD | GD_SCENE_KEYWORD | GD_RESOURCE_KEYWORD | RESOURCE_KEYWORD | IDENTIFIER
  public static boolean entry_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTRY_NAME, "<entry name>");
    r = consumeToken(b, NODE_KEYWORD);
    if (!r) r = consumeToken(b, GD_SCENE_KEYWORD);
    if (!r) r = consumeToken(b, GD_RESOURCE_KEYWORD);
    if (!r) r = consumeToken(b, RESOURCE_KEYWORD);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // list | dictionary | function | sub_resource_function | ext_resource_function | resource_string | SINGLE_QUOTED_STRING | DOUBLE_QUOTED_STRING | NUMBER | TRUE | FALSE | NULL
  static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    r = list(b, l + 1);
    if (!r) r = dictionary(b, l + 1);
    if (!r) r = function(b, l + 1);
    if (!r) r = sub_resource_function(b, l + 1);
    if (!r) r = ext_resource_function(b, l + 1);
    if (!r) r = resource_string(b, l + 1);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NULL);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET EXT_RESOURCE_KEYWORD attribute* R_BRACKET property*
  public static boolean ext_resource_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_resource_entry")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_BRACKET, EXT_RESOURCE_KEYWORD);
    r = r && ext_resource_entry_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    r = r && ext_resource_entry_4(b, l + 1);
    exit_section_(b, m, EXT_RESOURCE_ENTRY, r);
    return r;
  }

  // attribute*
  private static boolean ext_resource_entry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_resource_entry_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ext_resource_entry_2", c)) break;
    }
    return true;
  }

  // property*
  private static boolean ext_resource_entry_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_resource_entry_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ext_resource_entry_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EXT_RESOURCE L_PAREN NUMBER R_PAREN
  public static boolean ext_resource_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ext_resource_function")) return false;
    if (!nextTokenIs(b, EXT_RESOURCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EXT_RESOURCE, L_PAREN, NUMBER, R_PAREN);
    exit_section_(b, m, EXT_RESOURCE_FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER L_PAREN expression? (COMMA expression)* R_PAREN
  static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, L_PAREN);
    r = r && function_2(b, l + 1);
    r = r && function_3(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression?
  private static boolean function_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean function_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_3", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean function_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_3_0")) return false;
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
  static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && list_1(b, l + 1);
    r = r && list_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression?
  private static boolean list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_2", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
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
  // (entry | ext_resource_entry | sub_resource_entry)*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  // entry | ext_resource_entry | sub_resource_entry
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    r = entry(b, l + 1);
    if (!r) r = ext_resource_entry(b, l + 1);
    if (!r) r = sub_resource_entry(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET SUB_RESOURCE_KEYWORD attribute* R_BRACKET property*
  public static boolean sub_resource_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_resource_entry")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_BRACKET, SUB_RESOURCE_KEYWORD);
    r = r && sub_resource_entry_2(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    r = r && sub_resource_entry_4(b, l + 1);
    exit_section_(b, m, SUB_RESOURCE_ENTRY, r);
    return r;
  }

  // attribute*
  private static boolean sub_resource_entry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_resource_entry_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sub_resource_entry_2", c)) break;
    }
    return true;
  }

  // property*
  private static boolean sub_resource_entry_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_resource_entry_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sub_resource_entry_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SUB_RESOURCE L_PAREN NUMBER R_PAREN
  public static boolean sub_resource_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_resource_function")) return false;
    if (!nextTokenIs(b, SUB_RESOURCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SUB_RESOURCE, L_PAREN, NUMBER, R_PAREN);
    exit_section_(b, m, SUB_RESOURCE_FUNCTION, r);
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
