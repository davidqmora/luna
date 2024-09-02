package com.github.davidqmora.luna.language.psi.impl

import com.github.davidqmora.luna.language.psi.LuaProperty
import com.github.davidqmora.luna.language.psi.LuaTypes
import com.intellij.lang.ASTNode

class LuaPsiImplUtil {
    companion object {
        fun getKey(element: LuaProperty): String? {
            val keyNode: ASTNode? = element.node.findChildByType(LuaTypes.KEY)
            return keyNode?.text?.replace("\\\\ ", " ")
        }

        fun getValue(element: LuaProperty): String? {
            val valueNode: ASTNode? = element.node.findChildByType(LuaTypes.VALUE)
            return valueNode?.text
        }
    }
}