// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.JassIncludeStatement;
import cn.gsein.zjass.psi.JassVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class JassIncludeStatementImpl extends ASTWrapperPsiElement implements JassIncludeStatement {

  public JassIncludeStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitIncludeStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

}
