package gdscript.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import gdscript.ScriptFileType

class ScriptCreateFileAction : CreateFileFromTemplateAction("GDScript", "", ScriptFileType.icon) {

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String)
        = "Create GDScript File"

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle("New GDScript File/Class")
            .addKind("File", ScriptFileType.icon, "GDScript File")
            .addKind("Class", ScriptFileType.icon, "GDScript Class")
    }

}