package plugin

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import plugin.parser.GDScriptLanguageLexer
import plugin.parser.GDScriptLanguageParser
import plugin.psi.ArgdefSubtree
import plugin.psi.BlockSubtree
import plugin.psi.CallSubtree
import plugin.psi.FunctionSubtree
import plugin.psi.GDScriptPsiFileRoot
import plugin.psi.VardefSubtree
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class GDScriptParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer {
        val lexer = GDScriptLanguageLexer(null)
        return ANTLRLexerAdaptor(GDScriptLanguage, lexer)
    }

    override fun createParser(project: Project): PsiParser {
        val parser = GDScriptLanguageParser(null)
        return object : ANTLRParserAdaptor(GDScriptLanguage, parser) {
            override fun parse(parser: Parser, root: IElementType): ParseTree {
                // start rule depends on root passed in; sometimes we want to create an ID node etc...
                return if (root is IFileElementType) {
                    (parser as GDScriptLanguageParser).script()
                } else (parser as GDScriptLanguageParser).primary()
                // let's hope it's an ID as needed by "rename function"
            }
        }
    }

    /** "Tokens of those types are automatically skipped by PsiBuilder."  */
    override fun getWhitespaceTokens(): TokenSet {
        return WHITESPACE
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return STRING
    }

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    /** What is the IFileElementType of the root parse tree node? It
     * is called from [.createFile] at least.
     */
    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    /** Create the root of your PSI tree (a PsiFile).
     *
     * From IntelliJ IDEA Architectural Overview:
     * "A PSI (Program Structure Interface) file is the root of a structure
     * representing the contents of a file as a hierarchy of elements
     * in a particular programming language."
     *
     * PsiFile is to be distinguished from a FileASTNode, which is a parse
     * tree node that eventually becomes a PsiFile. From PsiFile, we can get
     * it back via: [PsiFile.getNode].
     */
    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return GDScriptPsiFileRoot(viewProvider)
    }

    /** Convert from *NON-LEAF* parse node (AST they call it)
     * to PSI node. Leaves are created in the AST factory.
     * Rename re-factoring can cause this to be
     * called on a TokenIElementType since we want to rename ID nodes.
     * In that case, this method is called to create the root node
     * but with ID type. Kind of strange, but we can simply create a
     * ASTWrapperPsiElement to make everything work correctly.
     *
     * RuleIElementType.  Ah! It's that ID is the root
     * IElementType requested to parse, which means that the root
     * node returned from parsetree->PSI conversion.  But, it
     * must be a CompositeElement! The adaptor calls
     * rootMarker.done(root) to finish off the PSI conversion.
     * See [ANTLRParserAdaptor.parse]
     *
     * If you don't care to distinguish PSI nodes by type, it is
     * sufficient to create a [ANTLRPsiNode] around
     * the parse tree node
     */
    override fun createElement(node: ASTNode): PsiElement {
        val elType = node.elementType
        if (elType is TokenIElementType) {
            return ANTLRPsiNode(node)
        }
        if (elType !is RuleIElementType) {
            return ANTLRPsiNode(node)
        }
        when (elType.ruleIndex) {
            GDScriptLanguageParser.RULE_function -> return FunctionSubtree(node, elType)
            GDScriptLanguageParser.RULE_vardef -> return VardefSubtree(node, elType)
            GDScriptLanguageParser.RULE_formal_arg -> return ArgdefSubtree(node, elType)
            GDScriptLanguageParser.RULE_block -> return BlockSubtree(node)
            GDScriptLanguageParser.RULE_call_expr -> return CallSubtree(node)
            else -> return ANTLRPsiNode(node)
        }
    }

    companion object {
        val FILE = IFileElementType(GDScriptLanguage)

        var ID: TokenIElementType

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(GDScriptLanguage,
                    GDScriptLanguageParser.tokenNames,
                    GDScriptLanguageParser.ruleNames)
            val tokenIElementTypes = PSIElementTypeFactory.getTokenIElementTypes(GDScriptLanguage)
            ID = tokenIElementTypes[GDScriptLanguageLexer.ID]
        }

        val COMMENTS = PSIElementTypeFactory.createTokenSet(
                GDScriptLanguage,
                GDScriptLanguageLexer.COMMENT,
                GDScriptLanguageLexer.LINE_COMMENT)

        val WHITESPACE = PSIElementTypeFactory.createTokenSet(
                GDScriptLanguage,
                GDScriptLanguageLexer.WS)

        val STRING = PSIElementTypeFactory.createTokenSet(
                GDScriptLanguage,
                GDScriptLanguageLexer.STRING)
    }
}
