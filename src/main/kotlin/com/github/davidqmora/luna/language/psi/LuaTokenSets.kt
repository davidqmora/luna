package com.github.davidqmora.luna.language.psi

import com.intellij.psi.tree.TokenSet

class LuaTokenSets {
    companion object {
        val IDENTIFIERS  = TokenSet.create(LuaTypes.KEY)
        val COMMENTS = TokenSet.create(LuaTypes.COMMENT)
    }
}