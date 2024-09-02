package com.github.davidqmora.luna.language.psi

import com.github.davidqmora.luna.language.LuaFileType
import com.github.davidqmora.luna.language.LuaLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class LuaFile(viewProvider: FileViewProvider): PsiFileBase(viewProvider, LuaLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return LuaFileType.INSTANCE
    }

    override fun toString(): String {
        return "Lua File"
    }
}