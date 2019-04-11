// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.JassAssignStatement;
import cn.gsein.zjass.psi.JassVarName;
import cn.gsein.zjass.psi.JassVarValue;
import cn.gsein.zjass.psi.JassVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class JassAssignStatementImpl extends ASTWrapperPsiElement implements JassAssignStatement {

  public JassAssignStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitAssignStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public JassVarName getVarName() {
    return findNotNullChildByClass(JassVarName.class);
  }

  @Override
  @NotNull
  public JassVarValue getVarValue() {
    return findNotNullChildByClass(JassVarValue.class);
  }

}
