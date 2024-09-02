package com.github.davidqmora.luna.language

import com.intellij.lexer.FlexAdapter
import com.github.davidqmora.luna.language.LuaLexer

class LuaLexerAdapter: FlexAdapter(LuaLexer(null)) {}