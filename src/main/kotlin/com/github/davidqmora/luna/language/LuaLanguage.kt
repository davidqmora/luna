package com.github.davidqmora.luna.language

import com.intellij.lang.Language

class LuaLanguage : Language("Lua") {
    companion object {
        val INSTANCE = LuaLanguage()
    }
}