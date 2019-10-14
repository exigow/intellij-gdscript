package script

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import script.ScriptTokenSets.LINE_COMMENT
import script.ScriptTokenSets.STRING
import script.ScriptTokenSets.WHITESPACE
import script.adaptors.LexerAdaptor
import script.adaptors.ParserAdaptor
import script.grammar.ScriptParser
import script.psi.PsiFactory
import script.psi.PsiFile

class ScriptParserDefinition : ParserDefinition {

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ScriptLanguage, ScriptParser.tokenNames, ScriptParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer = LexerAdaptor()

    override fun createParser(project: Project): PsiParser = ParserAdaptor()

    override fun getWhitespaceTokens(): TokenSet = WHITESPACE

    override fun getCommentTokens(): TokenSet = LINE_COMMENT

    override fun getStringLiteralElements(): TokenSet = STRING

    override fun getFileNodeType() = IFileElementType(ScriptLanguage)

    override fun createFile(view: FileViewProvider) = PsiFile(view)

    override fun createElement(node: ASTNode) = PsiFactory.createPsiElement(node)

}
