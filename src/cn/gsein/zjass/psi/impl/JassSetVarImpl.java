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

public class JassSetVarImpl extends ASTWrapperPsiElement implements JassSetVar {

  public JassSetVarImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitSetVar(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public JassExpr getExpr() {
    return findNotNullChildByClass(JassExpr.class);
  }

  @Override
  @Nullable
  public JassIntExpr getIntExpr() {
    return findChildByClass(JassIntExpr.class);
  }

  @Override
  @NotNull
  public JassVarRef getVarRef() {
    return findNotNullChildByClass(JassVarRef.class);
  }

}
