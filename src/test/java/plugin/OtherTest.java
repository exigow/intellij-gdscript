package plugin;

import plugin.ASTNodePrinter;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.TokenSet;
import com.intellij.testFramework.ParsingTestCase;

public class OtherTest extends ParsingTestCase {

    public OtherTest() {
        super("", "GDScript", new SampleParserDefinition());
    }

    public void testSingleVarDefinition() {
        ASTNode tree = convertToSyntaxTree("var x = 1");
        System.out.println(ASTNodePrinter.printDirectoryTree(tree));
    }

    public void testMultipleVarDefinitions() {
        ASTNode tree = convertToSyntaxTree("var x = 1\nvar y = 2");
        System.out.println(ASTNodePrinter.printDirectoryTree(tree));
    }

    private ASTNode convertToSyntaxTree(String code) {
        PsiFile file = createPsiFile("a.sample", code);
        ensureParsed(file);
        return file.getNode().getChildren(TokenSet.ANY)[0];
    }

}
