package script.completion

import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.patterns.PlatformPatterns.psiElement
import script.completion.provider.*
import script.psi.elements.InvokePsiElement
import script.psi.elements.TypePsiElement
import script.psi.elements.ValuePsiElement


class CompletionContributor : com.intellij.codeInsight.completion.CompletionContributor() {

    init {
        extend(BASIC, INSIDE_TYPE, ClassProvider)
        extend(BASIC, INSIDE_TYPE, PrimitiveProvider)
        extend(BASIC, INSIDE_INVOKE, ConstructorCallProvider)
        extend(BASIC, INSIDE_INVOKE, FunctionCallProvider)
        extend(BASIC, INSIDE_VALUE, ConstantProvider)
        extend(BASIC, INSIDE_VALUE, ConstructorCallProvider)
        extend(BASIC, INSIDE_VALUE, FunctionCallProvider)
        extend(BASIC, INSIDE_VALUE, SelfTrueFalseProvider)
    }

    private companion object {

        private val INSIDE_TYPE = psiElement().inside(TypePsiElement::class.java)
        private val INSIDE_INVOKE = psiElement().inside(InvokePsiElement::class.java)
        private val INSIDE_VALUE = psiElement().inside(ValuePsiElement::class.java)

    }

}
