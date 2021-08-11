// This is a generated file. Not intended for manual editing.
package tscn.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import tscn.psi.impl.*;

public interface TscnElementTypes {

  IElementType ATTRIBUTE = new TscnElementType("ATTRIBUTE");
  IElementType DICTIONARY_EXPRESSION = new TscnElementType("DICTIONARY_EXPRESSION");
  IElementType ENTRY = new TscnElementType("ENTRY");
  IElementType EXT_ENTRY = new TscnElementType("EXT_ENTRY");
  IElementType EXT_EXPRESSION = new TscnElementType("EXT_EXPRESSION");
  IElementType FUNCTION_EXPRESSION = new TscnElementType("FUNCTION_EXPRESSION");
  IElementType KEY = new TscnElementType("KEY");
  IElementType LIST_EXPRESSION = new TscnElementType("LIST_EXPRESSION");
  IElementType PAIR_EXPRESSION = new TscnElementType("PAIR_EXPRESSION");
  IElementType PROPERTY = new TscnElementType("PROPERTY");
  IElementType RESOURCE_STRING = new TscnElementType("RESOURCE_STRING");
  IElementType SUB_ENTRY = new TscnElementType("SUB_ENTRY");
  IElementType SUB_EXPRESSION = new TscnElementType("SUB_EXPRESSION");
  IElementType VALUE = new TscnElementType("VALUE");

  IElementType COLON = new TscnTokenType(":");
  IElementType COMMA = new TscnTokenType(",");
  IElementType COMMENT = new TscnTokenType("COMMENT");
  IElementType DOUBLE_QUOTED_RESOURCE_STRING = new TscnTokenType("DOUBLE_QUOTED_RESOURCE_STRING");
  IElementType DOUBLE_QUOTED_STRING = new TscnTokenType("DOUBLE_QUOTED_STRING");
  IElementType EQUAL = new TscnTokenType("=");
  IElementType EXT_RESOURCE = new TscnTokenType("ExtResource");
  IElementType EXT_RESOURCE_KEYWORD = new TscnTokenType("ext_resource");
  IElementType FALSE = new TscnTokenType("false");
  IElementType GD_RESOURCE_KEYWORD = new TscnTokenType("gd_resource");
  IElementType GD_SCENE_KEYWORD = new TscnTokenType("gd_scene");
  IElementType IDENTIFIER = new TscnTokenType("IDENTIFIER");
  IElementType L_BRACKET = new TscnTokenType("[");
  IElementType L_CURLY = new TscnTokenType("{");
  IElementType L_PAREN = new TscnTokenType("(");
  IElementType NODE_KEYWORD = new TscnTokenType("node");
  IElementType NULL = new TscnTokenType("null");
  IElementType NUMBER = new TscnTokenType("NUMBER");
  IElementType RESOURCE_KEYWORD = new TscnTokenType("resource");
  IElementType R_BRACKET = new TscnTokenType("]");
  IElementType R_CURLY = new TscnTokenType("}");
  IElementType R_PAREN = new TscnTokenType(")");
  IElementType SINGLE_QUOTED_RESOURCE_STRING = new TscnTokenType("SINGLE_QUOTED_RESOURCE_STRING");
  IElementType SINGLE_QUOTED_STRING = new TscnTokenType("SINGLE_QUOTED_STRING");
  IElementType SLASH = new TscnTokenType("/");
  IElementType SUB_RESOURCE = new TscnTokenType("SubResource");
  IElementType SUB_RESOURCE_KEYWORD = new TscnTokenType("sub_resource");
  IElementType TRUE = new TscnTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTRIBUTE) {
        return new TscnAttributeImpl(node);
      }
      else if (type == DICTIONARY_EXPRESSION) {
        return new TscnDictionaryExpressionImpl(node);
      }
      else if (type == ENTRY) {
        return new TscnEntryImpl(node);
      }
      else if (type == EXT_ENTRY) {
        return new TscnExtEntryImpl(node);
      }
      else if (type == EXT_EXPRESSION) {
        return new TscnExtExpressionImpl(node);
      }
      else if (type == FUNCTION_EXPRESSION) {
        return new TscnFunctionExpressionImpl(node);
      }
      else if (type == KEY) {
        return new TscnKeyImpl(node);
      }
      else if (type == LIST_EXPRESSION) {
        return new TscnListExpressionImpl(node);
      }
      else if (type == PAIR_EXPRESSION) {
        return new TscnPairExpressionImpl(node);
      }
      else if (type == PROPERTY) {
        return new TscnPropertyImpl(node);
      }
      else if (type == RESOURCE_STRING) {
        return new TscnResourceStringImpl(node);
      }
      else if (type == SUB_ENTRY) {
        return new TscnSubEntryImpl(node);
      }
      else if (type == SUB_EXPRESSION) {
        return new TscnSubExpressionImpl(node);
      }
      else if (type == VALUE) {
        return new TscnValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
