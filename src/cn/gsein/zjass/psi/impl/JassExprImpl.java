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

public class JassExprImpl extends ASTWrapperPsiElement implements JassExpr {

  public JassExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JassBoolExpr getBoolExpr() {
    return findChildByClass(JassBoolExpr.class);
  }

  @Override
  @Nullable
  public JassCodeExpr getCodeExpr() {
    return findChildByClass(JassCodeExpr.class);
  }

  @Override
  @Nullable
  public JassHandleExpr getHandleExpr() {
    return findChildByClass(JassHandleExpr.class);
  }

  @Override
  @Nullable
  public JassNullExpr getNullExpr() {
    return findChildByClass(JassNullExpr.class);
  }

  @Override
  @Nullable
  public JassNumberExpr getNumberExpr() {
    return findChildByClass(JassNumberExpr.class);
  }

  @Override
  @Nullable
  public JassStringExpr getStringExpr() {
    return findChildByClass(JassStringExpr.class);
  }

}
