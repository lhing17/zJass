// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JassFuncCallImpl extends JassNamedElementImpl implements JassFuncCall {

  public JassFuncCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitFuncCall(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JassEmpty getEmpty() {
    return findChildByClass(JassEmpty.class);
  }

  @Override
  @NotNull
  public JassFuncName getFuncName() {
    return findNotNullChildByClass(JassFuncName.class);
  }

  @Override
  @NotNull
  public List<JassVarName> getVarNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassVarName.class);
  }

  public String getName() {
    return JassPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return JassPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return JassPsiImplUtil.getNameIdentifier(this);
  }

}
