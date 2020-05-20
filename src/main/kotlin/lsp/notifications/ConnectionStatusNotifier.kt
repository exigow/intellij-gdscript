package lsp.notifications

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

internal object ConnectionStatusNotifier {

    private val BALLOON_GROUP = NotificationGroup("LSP connection status", NotificationDisplayType.BALLOON, true)

    fun notify(project: Project, message: String) {
        BALLOON_GROUP.createNotification(message, NotificationType.INFORMATION)
            .notify(project)
    }

}