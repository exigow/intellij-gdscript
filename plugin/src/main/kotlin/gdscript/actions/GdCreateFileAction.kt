package gdscript.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import gdscript.GdIcons

class GdCreateFileAction : CreateFileFromTemplateAction("GDScript", "", GdIcons.FILE_ICON) {

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String)
        = "Create GDScript File"

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle("New GDScript File/Class")
            .addKind("File", GdIcons.FILE_ICON, "GDScript File")
            .addKind("Class", GdIcons.FILE_ICON, "GDScript Class")
    }

}