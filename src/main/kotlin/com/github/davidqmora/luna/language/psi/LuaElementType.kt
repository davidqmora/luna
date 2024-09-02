package com.github.davidqmora.luna.language.psi

import com.github.davidqmora.luna.language.LuaLanguage
import com.intellij.psi.tree.IElementType

class LuaElementType(debugName: String): IElementType(debugName, LuaLanguage.INSTANCE) {}