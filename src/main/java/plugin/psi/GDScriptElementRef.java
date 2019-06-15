package plugin.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.IncorrectOperationException;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class GDScriptElementRef extends PsiReferenceBase<IdentifierPsiINode> {
	public GDScriptElementRef(@NotNull IdentifierPsiINode element) {
		/** WARNING: You must send up the text range or you get this error:
		 * "Cannot find manipulator for PsiElement(ID) in org.antlr.jetbrains.sample.GDScriptElementRef"...
		 *  when you click on an identifier.  During rename you get this
		 *  error too if you don't impl handleElementRename().
		 *
		 *  The range is relative to start of the token; I guess for
		 *  qualified references we might want to use just a part of the name.
		 *  Or we might look inside string literals for stuff.
		 */
		super(element, new TextRange(0, element.getText().length()));
	}

	@NotNull
	@Override
	public Object[] getVariants() {
		return new Object[0];
	}

	/** Change the REFERENCE's ID node (not the targeted def's ID node)
	 *  to reflect a rename.
	 *
	 *  Without this method, we get an error ("Cannot find manipulator...").
	 *
	 *  getElement() refers to the identifier node that references the definition.
	 */
	@Override
	public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
//		System.out.println(getClass().getSimpleName()+".handleElementRename("+myElement.getName()+"->"+newElementName+
//			                   ") on "+myElement+" at "+Integer.toHexString(myElement.hashCode()));

		return myElement.setName(newElementName);
	}

	/** Resolve a reference to the definition subtree (subclass of
	 *  IdentifierDefSubtree), do not resolve to the ID child of that
	 *  definition subtree root.
	 */
	@Nullable
	@Override
	public PsiElement resolve() {
//		System.out.println(getClass().getSimpleName()+
//		                   ".resolve("+myElement.getName()+
//		                   " at "+Integer.toHexString(myElement.hashCode())+")");
		ScopeNode scope = (ScopeNode)myElement.getContext();
		if ( scope==null ) return null;

		return scope.resolve(myElement);
	}

	@Override
	public boolean isReferenceTo(PsiElement def) {
		String refName = myElement.getName();
//		System.out.println(getClass().getSimpleName()+".isReferenceTo("+refName+"->"+def.getText()+")");
		// sometimes def comes in pointing to ID node itself. depends on what you click on
		if ( def instanceof IdentifierPsiINode && isDefSubtree(def.getParent()) ) {
			def = def.getParent();
		}
		if ( isDefSubtree(def) ) {
			PsiElement id = ((PsiNameIdentifierOwner)def).getNameIdentifier();
			String defName = id!=null ? id.getText() : null;
			return refName!=null && defName!=null && refName.equals(defName);
		}
		return false;
	}

	/** Is the targeted def a subtree associated with this ref's kind of node?
	 *  E.g., for a variable def, this should return true for VardefSubtree.
	 */
	public abstract boolean isDefSubtree(PsiElement def);
}
