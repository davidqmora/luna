package com.github.davidqmora.luna.language

import com.intellij.openapi.fileTypes.LanguageFileType

class LuaFileType : LanguageFileType(LuaLanguage.INSTANCE) {

    companion object {
        val INSTANCE: LanguageFileType = LuaFileType()
    }

    override fun getName() = "Lua File"
    override fun getDescription() = "Lua language file"
    override fun getDefaultExtension() = "lua"
    override fun getIcon() = LuaIcons.FILE
}