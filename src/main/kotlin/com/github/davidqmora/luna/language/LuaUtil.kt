package com.github.davidqmora.luna.language

import com.github.davidqmora.luna.language.psi.LuaFile
import com.github.davidqmora.luna.language.psi.LuaProperty
import com.github.davidqmora.luna.language.psi.impl.LuaPsiImplUtil.Companion.getKey
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.annotations.Unmodifiable
import org.jsoup.internal.StringUtil
import java.util.*
import kotlin.collections.ArrayList

class LuaUtil {
    companion object {
        fun findProperties(project: Project, key: String): List<LuaProperty> {
            val result: MutableList<LuaProperty> = ArrayList()
            val virtualFiles: MutableCollection<VirtualFile> = FileTypeIndex.getFiles(LuaFileType.INSTANCE, GlobalSearchScope.allScope(project))
            for (virtualFile in virtualFiles) {
                val psiFile: LuaFile = (PsiManager.getInstance(project).findFile(virtualFile) ?: continue) as LuaFile
                val properties: @Unmodifiable MutableCollection<LuaProperty> = PsiTreeUtil.findChildrenOfType(psiFile, LuaProperty::class.java)
                for (property in properties) {
                    if (key == getKey(property)) {
                        result.add(property)
                    }
                }
            }
            return result
        }

        fun findProperties(project: Project): List<LuaProperty> {
            val result: MutableList<LuaProperty> = ArrayList()
            val virtualFiles: MutableCollection<VirtualFile> = FileTypeIndex.getFiles(LuaFileType.INSTANCE, GlobalSearchScope.allScope(project))
            for (virtualFile in virtualFiles) {
                val psiFile: LuaFile = (PsiManager.getInstance(project).findFile(virtualFile) ?: continue) as LuaFile
                val properties: @Unmodifiable MutableCollection<LuaProperty> = PsiTreeUtil.findChildrenOfType(psiFile, LuaProperty::class.java)
                result.addAll(properties)
            }
            return result
        }

        fun findDocumentationComments(property: LuaProperty): String {
            val result: MutableList<String> = LinkedList()
            var element: PsiElement = property.prevSibling
            while (element is PsiComment || element is PsiWhiteSpace) {
                if (element is PsiComment) {
                    val commentText = element.text.replaceFirst("[!# ]+", "")
                    result.add(commentText)
                }
                element = element.prevSibling
            }
            return StringUtil.join(result, "\n")
        }
    }
}