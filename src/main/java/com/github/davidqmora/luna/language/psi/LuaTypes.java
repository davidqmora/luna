// This is a generated file. Not intended for manual editing.
package com.github.davidqmora.luna.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.davidqmora.luna.language.psi.impl.*;

public interface LuaTypes {

  IElementType PROPERTY = new LuaElementType("PROPERTY");

  IElementType COMMENT = new LuaTokenType("COMMENT");
  IElementType CRLF = new LuaTokenType("CRLF");
  IElementType KEY = new LuaTokenType("KEY");
  IElementType SEPARATOR = new LuaTokenType("SEPARATOR");
  IElementType VALUE = new LuaTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new LuaPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
