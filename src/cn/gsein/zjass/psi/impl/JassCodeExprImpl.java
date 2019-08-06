// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cn.gsein.zjass.psi.JassTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import cn.gsein.zjass.psi.*;

public class JassCodeExprImpl extends ASTWrapperPsiElement implements JassCodeExpr {

  public JassCodeExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitCodeExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JassAnyExprAtom getAnyExprAtom() {
    return findChildByClass(JassAnyExprAtom.class);
  }

  @Override
  @Nullable
  public JassCodeLiteral getCodeLiteral() {
    return findChildByClass(JassCodeLiteral.class);
  }

  @Override
  @Nullable
  public JassCodeParens getCodeParens() {
    return findChildByClass(JassCodeParens.class);
  }

}
