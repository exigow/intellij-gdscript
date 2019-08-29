package gdscript

import com.intellij.openapi.fileTypes.FileTypeConsumer

class FileTypeFactory : com.intellij.openapi.fileTypes.FileTypeFactory() {

    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(LanguageFileType, LanguageFileType.defaultExtension)
    }

}
