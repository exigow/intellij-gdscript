package gdscript.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static gdscript.psi.ScriptElementTypes.*;

%%

%public
%class _ScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

WHITE_SPACE=([\ \t\f]+|\\\n)
NODE_PATH=\$\"?[A-Za-z0-9_/.]*\"?
IDENTIFIER=[A-Za-z_][A-Za-z0-9_]*

REAL_NUMBER = -?[0-9_]*(\.)?([0-9_]+)?([Ee][-+]?[0-9]+)?
BINARY_NUMBER = 0b[10_]*
HEXADECIMAL_NUMBER = 0x[0-9A-Fa-f_]*

SINGLE_QUOTED_STRING = "'" ([^\\\'\r\n] | (\\[\r\n]))* ("'"|\\)?
DOUBLE_QUOTED_STRING = \" ([^\\\"\r\n] | (\\[\r\n]))* (\"|\\)?
MULTILINE_DOUBLE_QUOTED_STRING = (\"\"\") [^\\\"]* (\"\"\")?
MULTILINE_SINGLE_QUOTED_STRING = (\'\'\') [^\\\']* (\'\'\')?

LINE_COMMENT=#[^\n]*

%%
<YYINITIAL> {
  {WHITE_SPACE}                      { return WHITE_SPACE; }

  "if"                               { return IF; }
  "export"                           { return EXPORT; }
  "elif"                             { return ELIF; }
  "else"                             { return ELSE; }
  "for"                              { return FOR; }
  "while"                            { return WHILE; }
  "break"                            { return BREAK; }
  "continue"                         { return CONTINUE; }
  "pass"                             { return PASS; }
  "return"                           { return RETURN; }
  "match"                            { return MATCH; }
  "assert"                           { return ASSERT; }
  "await"                            { return AWAIT; }
  "breakpoint"                       { return BREAKPOINT; }
  "class"                            { return CLASS; }
  "class_name"                       { return CLASS_NAME; }
  "const"                            { return CONST; }
  "enum"                             { return ENUM; }
  "extends"                          { return EXTENDS; }
  "func"                             { return FUNC; }
  "self"                             { return SELF; }
  "signal"                           { return SIGNAL; }
  "static"                           { return STATIC; }
  "onready"                          { return ONREADY; }
  "var"                              { return VAR; }
  "setget"                           { return SETGET; }
  "yield"                            { return YIELD; }
  "true"                             { return TRUE; }
  "false"                            { return FALSE; }
  "null"                             { return NULL; }
  "and"                              { return AND; }
  "or"                               { return OR; }
  "not"                              { return NOT; }
  "int"                              { return INT; }
  "float"                            { return FLOAT; }
  "bool"                             { return BOOL; }
  "void"                             { return VOID; }
  "in"                               { return IN; }
  "is"                               { return IS; }
  "as"                               { return AS; }
  "tool"                             { return TOOL; }
  "master"                           { return MASTER; }
  "puppet"                           { return PUPPET; }
  "remote"                           { return REMOTE; }
  "sync"                             { return SYNC; }
  "mastersync"                       { return MASTERSYNC; }
  "puppetsync"                       { return PUPPETSYNC; }
  "remotesync"                       { return REMOTESYNC; }
  "@onready"                         { return AT_ONREADY; }
  "@tool"                            { return AT_TOOL; }
  "@export"                          { return AT_EXPORT; }
  "@export_enum"                     { return AT_EXPORT_ENUM; }
  "@export_file"                     { return AT_EXPORT_FILE; }
  "@export_dir"                      { return AT_EXPORT_DIR; }
  "@export_global_file"              { return AT_EXPORT_GLOBAL_FILE; }
  "@export_global_dir"               { return AT_EXPORT_GLOBAL_DIR; }
  "@export_multiline"                { return AT_EXPORT_MULTILINE; }
  "@export_placeholder"              { return AT_EXPORT_PLACEHOLDER; }
  "@export_range"                    { return AT_EXPORT_RANGE; }
  "@export_exp_easing"               { return AT_EXPORT_EXP_EASING; }
  "@export_color_no_alpha"           { return AT_EXPORT_COLOR_NO_ALPHA; }
  "@export_node_path"                { return AT_EXPORT_NODE_PATH; }
  "@export_flags"                    { return AT_EXPORT_FLAGS; }
  "@export_flags_2d_render"          { return AT_EXPORT_FLAGS_2D_RENDER; }
  "@export_flags_2d_physics"         { return AT_EXPORT_FLAGS_2D_PHYSICS; }
  "@export_flags_2d_navigation"      { return AT_EXPORT_FLAGS_2D_NAVIGATION; }
  "@export_flags_3d_render"          { return AT_EXPORT_FLAGS_3D_RENDER; }
  "@export_flags_3d_physics"         { return AT_EXPORT_FLAGS_3D_PHYSICS; }
  "@export_flags_3d_navigation"      { return AT_EXPORT_FLAGS_3D_NAVIGATION; }
  "@icon"                            { return AT_ICON; }
  "@master"                          { return AT_MASTER; }
  "@puppet"                          { return AT_PUPPET; }
  "@remote"                          { return AT_REMOTE; }
  "@mastersync"                      { return AT_MASTERSYNC; }
  "@puppetsync"                      { return AT_PUPPETSYNC; }
  "@remotesync"                      { return AT_REMOTESYNC; }
  "<"                                { return LESS; }
  "<="                               { return LESS_EQUAL; }
  ">"                                { return GREATER; }
  ">="                               { return GREATER_EQUAL; }
  "=="                               { return EQUAL_EQUAL; }
  "!="                               { return BANG_EQUAL; }
  "&&"                               { return AMPERSAND_AMPERSAND; }
  "||"                               { return PIPE_PIPE; }
  "!"                                { return BANG; }
  "&"                                { return AMPERSAND; }
  "|"                                { return PIPE; }
  "~"                                { return TILDE; }
  "^"                                { return CARET; }
  "<<"                               { return LESS_LESS; }
  ">>"                               { return GREATER_GREATER; }
  "+"                                { return PLUS; }
  "-"                                { return MINUS; }
  "*"                                { return STAR; }
  "/"                                { return SLASH; }
  "%"                                { return PERCENT; }
  "."                                { return DOT; }
  ".."                               { return DOT_DOT; }
  "="                                { return EQUAL; }
  "+="                               { return PLUS_EQUAL; }
  "-="                               { return MINUS_EQUAL; }
  "*="                               { return STAR_EQUAL; }
  "/="                               { return SLASH_EQUAL; }
  "%="                               { return PERCENT_EQUAL; }
  "<<="                              { return LESS_LESS_EQUAL; }
  ">>="                              { return GREATER_GREATER_EQUAL; }
  "&="                               { return AMPERSAND_EQUAL; }
  "|="                               { return PIPE_EQUAL; }
  "^="                               { return CARET_EQUAL; }
  ":="                               { return INFER; }
  "["                                { return L_BRACKET; }
  "]"                                { return R_BRACKET; }
  "{"                                { return L_BRACE; }
  "}"                                { return R_BRACE; }
  "("                                { return L_PAREN; }
  ")"                                { return R_PAREN; }
  ","                                { return COMMA; }
  ";"                                { return SEMICOLON; }
  ":"                                { return COLON; }
  "->"                               { return ARROW; }
  "_"                                { return UNDERSCORE; }
  [\n]                               { return LINE_BREAK; }
  {NODE_PATH}                        { return NODE_PATH; }
  {IDENTIFIER}                       { return IDENTIFIER; }
  {REAL_NUMBER}                      { return REAL_NUMBER; }
  {BINARY_NUMBER}                    { return BINARY_NUMBER; }
  {HEXADECIMAL_NUMBER}               { return HEXADECIMAL_NUMBER; }
  {SINGLE_QUOTED_STRING}             { return SINGLE_QUOTED_STRING; }
  {DOUBLE_QUOTED_STRING}             { return DOUBLE_QUOTED_STRING; }
  {MULTILINE_DOUBLE_QUOTED_STRING}   { return MULTILINE_DOUBLE_QUOTED_STRING; }
  {MULTILINE_SINGLE_QUOTED_STRING}   { return MULTILINE_SINGLE_QUOTED_STRING; }
  {LINE_COMMENT}                     { return LINE_COMMENT; }

}

[^] { return BAD_CHARACTER; }
