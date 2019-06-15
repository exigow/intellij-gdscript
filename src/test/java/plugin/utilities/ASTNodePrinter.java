package plugin.utilities;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;

public class ASTNodePrinter {

    public static String printDirectoryTree(ASTNode folder) {
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);
        return sb.toString();
    }

    private static void printDirectoryTree(ASTNode folder, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append(toPrettyName(folder.getPsi().getNode().getElementType().toString()));
        sb.append("\n");
        for (ASTNode file : folder.getChildren(TokenSet.ANY))
            if (file.getChildren(TokenSet.ANY).length > 0)
                printDirectoryTree(file, indent + 1, sb);
            else
                printFile(file.getText(), indent + 1, sb);
    }

    private static void printFile(String name, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append(toPrettyName(name));
        sb.append("\n");
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++)
            sb.append("   ");
        return sb.toString();
    }

    private static String toPrettyName(String name) {
        if (name.length() == 1) {
            char c = name.charAt(0);
            if (Character.isWhitespace(c))
                return Character.getName(c).toLowerCase();
        }
        return name;
    }

}
