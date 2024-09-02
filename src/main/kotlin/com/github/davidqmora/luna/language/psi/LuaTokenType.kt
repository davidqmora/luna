package com.github.davidqmora.luna.language.psi

import com.github.davidqmora.luna.language.LuaLanguage
import com.intellij.psi.tree.IElementType

class LuaTokenType(debugName: String) : IElementType(debugName, LuaLanguage.INSTANCE) {
    override fun toString(): String {
        return "LuaTokenType." + super.toString()
    }
}