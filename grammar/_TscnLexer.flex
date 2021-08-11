package tscn.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static tscn.psi.TscnElementTypes.*;

%%

%{
  public _TscnLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _TscnLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
IDENTIFIER=[A-Za-z_][A-Za-z0-9_]*
NUMBER=-?[0-9]+(\.[0-9]+)?
SINGLE_QUOTED_RESOURCE_STRING=\"res:"//"([^\"\\]|\\.)*\"
DOUBLE_QUOTED_RESOURCE_STRING='res:"//"([^'\\]|\\.)*'
SINGLE_QUOTED_STRING='([^'\\]|\\.)*'
DOUBLE_QUOTED_STRING=\"([^\"\\]|\\.)*\"
COMMENT=;[^\n]*

%%
<YYINITIAL> {
  {WHITE_SPACE}                        { return WHITE_SPACE; }

  "("                                  { return L_PAREN; }
  ")"                                  { return R_PAREN; }
  "["                                  { return L_BRACKET; }
  "]"                                  { return R_BRACKET; }
  "{"                                  { return L_CURLY; }
  "}"                                  { return R_CURLY; }
  "="                                  { return EQUAL; }
  "/"                                  { return SLASH; }
  ","                                  { return COMMA; }
  ":"                                  { return COLON; }
  "ExtResource"                        { return EXT_RESOURCE; }
  "SubResource"                        { return SUB_RESOURCE; }
  "node"                               { return NODE_KEYWORD; }
  "ext_resource"                       { return EXT_RESOURCE_KEYWORD; }
  "sub_resource"                       { return SUB_RESOURCE_KEYWORD; }
  "gd_scene"                           { return GD_SCENE_KEYWORD; }
  "gd_resource"                        { return GD_RESOURCE_KEYWORD; }
  "resource"                           { return RESOURCE_KEYWORD; }
  "true"                               { return TRUE; }
  "false"                              { return FALSE; }
  "null"                               { return NULL; }

  {SPACE}                              { return SPACE; }
  {IDENTIFIER}                         { return IDENTIFIER; }
  {NUMBER}                             { return NUMBER; }
  {SINGLE_QUOTED_RESOURCE_STRING}      { return SINGLE_QUOTED_RESOURCE_STRING; }
  {DOUBLE_QUOTED_RESOURCE_STRING}      { return DOUBLE_QUOTED_RESOURCE_STRING; }
  {SINGLE_QUOTED_STRING}               { return SINGLE_QUOTED_STRING; }
  {DOUBLE_QUOTED_STRING}               { return DOUBLE_QUOTED_STRING; }
  {COMMENT}                            { return COMMENT; }

}

[^] { return BAD_CHARACTER; }
