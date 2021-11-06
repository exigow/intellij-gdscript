// This is a generated file. Not intended for manual editing.
package gdscript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import gdscript.psi.impl.*;

public interface ScriptElementTypes {

  IElementType ARRAY_ARGUMENT = new ScriptElementType("ARRAY_ARGUMENT");
  IElementType ARRAY_EXPRESSION = new ScriptElementType("ARRAY_EXPRESSION");
  IElementType ASSERT_STATEMENT = new ScriptElementType("ASSERT_STATEMENT");
  IElementType ASSIGN_STATEMENT = new ScriptElementType("ASSIGN_STATEMENT");
  IElementType AWAIT_STATEMENT = new ScriptElementType("AWAIT_STATEMENT");
  IElementType CLASSNAME_STATEMENT = new ScriptElementType("CLASSNAME_STATEMENT");
  IElementType CLASS_STATEMENT = new ScriptElementType("CLASS_STATEMENT");
  IElementType CONST_STATEMENT = new ScriptElementType("CONST_STATEMENT");
  IElementType DICTIONARY_ENTRY = new ScriptElementType("DICTIONARY_ENTRY");
  IElementType DICTIONARY_EXPRESSION = new ScriptElementType("DICTIONARY_EXPRESSION");
  IElementType ELIF_STATEMENT = new ScriptElementType("ELIF_STATEMENT");
  IElementType ELSE_STATEMENT = new ScriptElementType("ELSE_STATEMENT");
  IElementType ENUM_ENTRY = new ScriptElementType("ENUM_ENTRY");
  IElementType ENUM_STATEMENT = new ScriptElementType("ENUM_STATEMENT");
  IElementType EXPRESSION = new ScriptElementType("EXPRESSION");
  IElementType EXPRESSION_STATEMENT = new ScriptElementType("EXPRESSION_STATEMENT");
  IElementType EXTENDS_STATEMENT = new ScriptElementType("EXTENDS_STATEMENT");
  IElementType FOR_STATEMENT = new ScriptElementType("FOR_STATEMENT");
  IElementType FUNC_ARGUMENT = new ScriptElementType("FUNC_ARGUMENT");
  IElementType FUNC_STATEMENT = new ScriptElementType("FUNC_STATEMENT");
  IElementType ICON_STATEMENT = new ScriptElementType("ICON_STATEMENT");
  IElementType ID = new ScriptElementType("ID");
  IElementType IF_STATEMENT = new ScriptElementType("IF_STATEMENT");
  IElementType INVOCATION_EXPRESSION = new ScriptElementType("INVOCATION_EXPRESSION");
  IElementType KEY = new ScriptElementType("KEY");
  IElementType LAMBDA_EXPRESSION = new ScriptElementType("LAMBDA_EXPRESSION");
  IElementType LUA_DICTIONARY_ENTRY = new ScriptElementType("LUA_DICTIONARY_ENTRY");
  IElementType LUA_DICTIONARY_EXPRESSION = new ScriptElementType("LUA_DICTIONARY_EXPRESSION");
  IElementType MATCH_LABEL_ARGUMENT = new ScriptElementType("MATCH_LABEL_ARGUMENT");
  IElementType MATCH_LABEL_STATEMENT = new ScriptElementType("MATCH_LABEL_STATEMENT");
  IElementType MATCH_STATEMENT = new ScriptElementType("MATCH_STATEMENT");
  IElementType RETURN_STATEMENT = new ScriptElementType("RETURN_STATEMENT");
  IElementType SIGNAL_STATEMENT = new ScriptElementType("SIGNAL_STATEMENT");
  IElementType STRING = new ScriptElementType("STRING");
  IElementType TOOL_STATEMENT = new ScriptElementType("TOOL_STATEMENT");
  IElementType TYPE = new ScriptElementType("TYPE");
  IElementType VAR_EXPORT = new ScriptElementType("VAR_EXPORT");
  IElementType VAR_GETTER = new ScriptElementType("VAR_GETTER");
  IElementType VAR_SETTER = new ScriptElementType("VAR_SETTER");
  IElementType VAR_STATEMENT = new ScriptElementType("VAR_STATEMENT");
  IElementType WHILE_STATEMENT = new ScriptElementType("WHILE_STATEMENT");
  IElementType YIELD_STATEMENT = new ScriptElementType("YIELD_STATEMENT");

  IElementType AMPERSAND = new ScriptTokenType("&");
  IElementType AMPERSAND_AMPERSAND = new ScriptTokenType("&&");
  IElementType AMPERSAND_EQUAL = new ScriptTokenType("&=");
  IElementType AND = new ScriptTokenType("and");
  IElementType ARROW = new ScriptTokenType("->");
  IElementType AS = new ScriptTokenType("as");
  IElementType ASSERT = new ScriptTokenType("assert");
  IElementType AT_EXPORT = new ScriptTokenType("@export");
  IElementType AT_EXPORT_COLOR_NO_ALPHA = new ScriptTokenType("@export_color_no_alpha");
  IElementType AT_EXPORT_DIR = new ScriptTokenType("@export_dir");
  IElementType AT_EXPORT_ENUM = new ScriptTokenType("@export_enum");
  IElementType AT_EXPORT_EXP_EASING = new ScriptTokenType("@export_exp_easing");
  IElementType AT_EXPORT_FILE = new ScriptTokenType("@export_file");
  IElementType AT_EXPORT_FLAGS = new ScriptTokenType("@export_flags");
  IElementType AT_EXPORT_FLAGS_2D_NAVIGATION = new ScriptTokenType("@export_flags_2d_navigation");
  IElementType AT_EXPORT_FLAGS_2D_PHYSICS = new ScriptTokenType("@export_flags_2d_physics");
  IElementType AT_EXPORT_FLAGS_2D_RENDER = new ScriptTokenType("@export_flags_2d_render");
  IElementType AT_EXPORT_FLAGS_3D_NAVIGATION = new ScriptTokenType("@export_flags_3d_navigation");
  IElementType AT_EXPORT_FLAGS_3D_PHYSICS = new ScriptTokenType("@export_flags_3d_physics");
  IElementType AT_EXPORT_FLAGS_3D_RENDER = new ScriptTokenType("@export_flags_3d_render");
  IElementType AT_EXPORT_GLOBAL_DIR = new ScriptTokenType("@export_global_dir");
  IElementType AT_EXPORT_GLOBAL_FILE = new ScriptTokenType("@export_global_file");
  IElementType AT_EXPORT_MULTILINE = new ScriptTokenType("@export_multiline");
  IElementType AT_EXPORT_NODE_PATH = new ScriptTokenType("@export_node_path");
  IElementType AT_EXPORT_PLACEHOLDER = new ScriptTokenType("@export_placeholder");
  IElementType AT_EXPORT_RANGE = new ScriptTokenType("@export_range");
  IElementType AT_ICON = new ScriptTokenType("@icon");
  IElementType AT_MASTER = new ScriptTokenType("@master");
  IElementType AT_MASTERSYNC = new ScriptTokenType("@mastersync");
  IElementType AT_ONREADY = new ScriptTokenType("@onready");
  IElementType AT_PUPPET = new ScriptTokenType("@puppet");
  IElementType AT_PUPPETSYNC = new ScriptTokenType("@puppetsync");
  IElementType AT_REMOTE = new ScriptTokenType("@remote");
  IElementType AT_REMOTESYNC = new ScriptTokenType("@remotesync");
  IElementType AT_TOOL = new ScriptTokenType("@tool");
  IElementType AWAIT = new ScriptTokenType("await");
  IElementType BANG = new ScriptTokenType("!");
  IElementType BANG_EQUAL = new ScriptTokenType("!=");
  IElementType BINARY_NUMBER = new ScriptTokenType("BINARY_NUMBER");
  IElementType BOOL = new ScriptTokenType("bool");
  IElementType BREAK = new ScriptTokenType("break");
  IElementType BREAKPOINT = new ScriptTokenType("breakpoint");
  IElementType CARET = new ScriptTokenType("^");
  IElementType CARET_EQUAL = new ScriptTokenType("^=");
  IElementType CLASS = new ScriptTokenType("class");
  IElementType CLASS_NAME = new ScriptTokenType("class_name");
  IElementType COLON = new ScriptTokenType(":");
  IElementType COMMA = new ScriptTokenType(",");
  IElementType CONST = new ScriptTokenType("const");
  IElementType CONTINUE = new ScriptTokenType("continue");
  IElementType DOT = new ScriptTokenType(".");
  IElementType DOT_DOT = new ScriptTokenType("..");
  IElementType DOUBLE_QUOTED_STRING = new ScriptTokenType("DOUBLE_QUOTED_STRING");
  IElementType ELIF = new ScriptTokenType("elif");
  IElementType ELSE = new ScriptTokenType("else");
  IElementType ENUM = new ScriptTokenType("enum");
  IElementType EQUAL = new ScriptTokenType("=");
  IElementType EQUAL_EQUAL = new ScriptTokenType("==");
  IElementType EXPORT = new ScriptTokenType("export");
  IElementType EXTENDS = new ScriptTokenType("extends");
  IElementType FALSE = new ScriptTokenType("false");
  IElementType FLOAT = new ScriptTokenType("float");
  IElementType FOR = new ScriptTokenType("for");
  IElementType FUNC = new ScriptTokenType("func");
  IElementType GREATER = new ScriptTokenType(">");
  IElementType GREATER_EQUAL = new ScriptTokenType(">=");
  IElementType GREATER_GREATER = new ScriptTokenType(">>");
  IElementType GREATER_GREATER_EQUAL = new ScriptTokenType(">>=");
  IElementType HEXADECIMAL_NUMBER = new ScriptTokenType("HEXADECIMAL_NUMBER");
  IElementType IDENTIFIER = new ScriptTokenType("IDENTIFIER");
  IElementType IF = new ScriptTokenType("if");
  IElementType IN = new ScriptTokenType("in");
  IElementType INFER = new ScriptTokenType(":=");
  IElementType INT = new ScriptTokenType("int");
  IElementType IS = new ScriptTokenType("is");
  IElementType LESS = new ScriptTokenType("<");
  IElementType LESS_EQUAL = new ScriptTokenType("<=");
  IElementType LESS_LESS = new ScriptTokenType("<<");
  IElementType LESS_LESS_EQUAL = new ScriptTokenType("<<=");
  IElementType LINE_BREAK = new ScriptTokenType("LINE_BREAK");
  IElementType LINE_COMMENT = new ScriptTokenType("LINE_COMMENT");
  IElementType L_BRACE = new ScriptTokenType("{");
  IElementType L_BRACKET = new ScriptTokenType("[");
  IElementType L_PAREN = new ScriptTokenType("(");
  IElementType MASTER = new ScriptTokenType("master");
  IElementType MASTERSYNC = new ScriptTokenType("mastersync");
  IElementType MATCH = new ScriptTokenType("match");
  IElementType MINUS = new ScriptTokenType("-");
  IElementType MINUS_EQUAL = new ScriptTokenType("-=");
  IElementType MULTILINE_DOUBLE_QUOTED_STRING = new ScriptTokenType("MULTILINE_DOUBLE_QUOTED_STRING");
  IElementType MULTILINE_SINGLE_QUOTED_STRING = new ScriptTokenType("MULTILINE_SINGLE_QUOTED_STRING");
  IElementType NODE_PATH = new ScriptTokenType("NODE_PATH");
  IElementType NOT = new ScriptTokenType("not");
  IElementType NULL = new ScriptTokenType("null");
  IElementType ONREADY = new ScriptTokenType("onready");
  IElementType OR = new ScriptTokenType("or");
  IElementType PASS = new ScriptTokenType("pass");
  IElementType PERCENT = new ScriptTokenType("%");
  IElementType PERCENT_EQUAL = new ScriptTokenType("%=");
  IElementType PIPE = new ScriptTokenType("|");
  IElementType PIPE_EQUAL = new ScriptTokenType("|=");
  IElementType PIPE_PIPE = new ScriptTokenType("||");
  IElementType PLUS = new ScriptTokenType("+");
  IElementType PLUS_EQUAL = new ScriptTokenType("+=");
  IElementType PUPPET = new ScriptTokenType("puppet");
  IElementType PUPPETSYNC = new ScriptTokenType("puppetsync");
  IElementType REAL_NUMBER = new ScriptTokenType("REAL_NUMBER");
  IElementType REMOTE = new ScriptTokenType("remote");
  IElementType REMOTESYNC = new ScriptTokenType("remotesync");
  IElementType RETURN = new ScriptTokenType("return");
  IElementType R_BRACE = new ScriptTokenType("}");
  IElementType R_BRACKET = new ScriptTokenType("]");
  IElementType R_PAREN = new ScriptTokenType(")");
  IElementType SELF = new ScriptTokenType("self");
  IElementType SEMICOLON = new ScriptTokenType(";");
  IElementType SETGET = new ScriptTokenType("setget");
  IElementType SIGNAL = new ScriptTokenType("signal");
  IElementType SINGLE_QUOTED_STRING = new ScriptTokenType("SINGLE_QUOTED_STRING");
  IElementType SLASH = new ScriptTokenType("/");
  IElementType SLASH_EQUAL = new ScriptTokenType("/=");
  IElementType STAR = new ScriptTokenType("*");
  IElementType STAR_EQUAL = new ScriptTokenType("*=");
  IElementType STATIC = new ScriptTokenType("static");
  IElementType SYNC = new ScriptTokenType("SYNC");
  IElementType TILDE = new ScriptTokenType("~");
  IElementType TOOL = new ScriptTokenType("tool");
  IElementType TRUE = new ScriptTokenType("true");
  IElementType UNDERSCORE = new ScriptTokenType("_");
  IElementType VAR = new ScriptTokenType("var");
  IElementType VOID = new ScriptTokenType("void");
  IElementType WHILE = new ScriptTokenType("while");
  IElementType YIELD = new ScriptTokenType("yield");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_ARGUMENT) {
        return new ScriptArrayArgumentImpl(node);
      }
      else if (type == ARRAY_EXPRESSION) {
        return new ScriptArrayExpressionImpl(node);
      }
      else if (type == ASSERT_STATEMENT) {
        return new ScriptAssertStatementImpl(node);
      }
      else if (type == ASSIGN_STATEMENT) {
        return new ScriptAssignStatementImpl(node);
      }
      else if (type == AWAIT_STATEMENT) {
        return new ScriptAwaitStatementImpl(node);
      }
      else if (type == CLASSNAME_STATEMENT) {
        return new ScriptClassnameStatementImpl(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new ScriptClassStatementImpl(node);
      }
      else if (type == CONST_STATEMENT) {
        return new ScriptConstStatementImpl(node);
      }
      else if (type == DICTIONARY_ENTRY) {
        return new ScriptDictionaryEntryImpl(node);
      }
      else if (type == DICTIONARY_EXPRESSION) {
        return new ScriptDictionaryExpressionImpl(node);
      }
      else if (type == ELIF_STATEMENT) {
        return new ScriptElifStatementImpl(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new ScriptElseStatementImpl(node);
      }
      else if (type == ENUM_ENTRY) {
        return new ScriptEnumEntryImpl(node);
      }
      else if (type == ENUM_STATEMENT) {
        return new ScriptEnumStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ScriptExpressionImpl(node);
      }
      else if (type == EXPRESSION_STATEMENT) {
        return new ScriptExpressionStatementImpl(node);
      }
      else if (type == EXTENDS_STATEMENT) {
        return new ScriptExtendsStatementImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ScriptForStatementImpl(node);
      }
      else if (type == FUNC_ARGUMENT) {
        return new ScriptFuncArgumentImpl(node);
      }
      else if (type == FUNC_STATEMENT) {
        return new ScriptFuncStatementImpl(node);
      }
      else if (type == ICON_STATEMENT) {
        return new ScriptIconStatementImpl(node);
      }
      else if (type == ID) {
        return new ScriptIdImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ScriptIfStatementImpl(node);
      }
      else if (type == INVOCATION_EXPRESSION) {
        return new ScriptInvocationExpressionImpl(node);
      }
      else if (type == KEY) {
        return new ScriptKeyImpl(node);
      }
      else if (type == LAMBDA_EXPRESSION) {
        return new ScriptLambdaExpressionImpl(node);
      }
      else if (type == LUA_DICTIONARY_ENTRY) {
        return new ScriptLuaDictionaryEntryImpl(node);
      }
      else if (type == LUA_DICTIONARY_EXPRESSION) {
        return new ScriptLuaDictionaryExpressionImpl(node);
      }
      else if (type == MATCH_LABEL_ARGUMENT) {
        return new ScriptMatchLabelArgumentImpl(node);
      }
      else if (type == MATCH_LABEL_STATEMENT) {
        return new ScriptMatchLabelStatementImpl(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new ScriptMatchStatementImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new ScriptReturnStatementImpl(node);
      }
      else if (type == SIGNAL_STATEMENT) {
        return new ScriptSignalStatementImpl(node);
      }
      else if (type == STRING) {
        return new ScriptStringImpl(node);
      }
      else if (type == TOOL_STATEMENT) {
        return new ScriptToolStatementImpl(node);
      }
      else if (type == TYPE) {
        return new ScriptTypeImpl(node);
      }
      else if (type == VAR_EXPORT) {
        return new ScriptVarExportImpl(node);
      }
      else if (type == VAR_GETTER) {
        return new ScriptVarGetterImpl(node);
      }
      else if (type == VAR_SETTER) {
        return new ScriptVarSetterImpl(node);
      }
      else if (type == VAR_STATEMENT) {
        return new ScriptVarStatementImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ScriptWhileStatementImpl(node);
      }
      else if (type == YIELD_STATEMENT) {
        return new ScriptYieldStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
