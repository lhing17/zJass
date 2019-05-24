// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JassBoolExprImpl extends ASTWrapperPsiElement implements JassBoolExpr {

  public JassBoolExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitBoolExpr(this);
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
  public JassFuncCall getFuncCall() {
    return findChildByClass(JassFuncCall.class);
  }

  @Override
  @NotNull
  public List<JassNumberExpr> getNumberExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassNumberExpr.class);
  }

  @Override
  @NotNull
  public List<JassStringExpr> getStringExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassStringExpr.class);
  }

  @Override
  @Nullable
  public JassVarName getVarName() {
    return findChildByClass(JassVarName.class);
  }

}
