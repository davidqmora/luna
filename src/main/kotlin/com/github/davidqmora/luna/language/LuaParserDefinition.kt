package com.github.davidqmora.luna.language

import com.github.davidqmora.luna.language.parser.LuaParser
import com.github.davidqmora.luna.language.psi.LuaFile
import com.github.davidqmora.luna.language.psi.LuaTokenSets
import com.github.davidqmora.luna.language.psi.LuaTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class LuaParserDefinition: ParserDefinition {
    companion object {
        val FILE = IFileElementType(LuaLanguage.INSTANCE)
    }


    override fun createLexer(project: Project?): Lexer {
        return LuaLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return LuaParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return LuaTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return LuaTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return LuaFile(viewProvider)
    }
}