package plugin.structview;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class SampleStructureViewRootElement extends SampleStructureViewElement {
	public SampleStructureViewRootElement(PsiFile element) {
		super(element);
	}

	@NotNull
	@Override
	public ItemPresentation getPresentation() {
		return new SampleRootPresentation((PsiFile)element);
	}
}
