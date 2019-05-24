// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cn.gsein.zjass.psi.JassTypes.*;
import cn.gsein.zjass.psi.*;

public class JassFuncDefImpl extends JassNamedElementImpl implements JassFuncDef {

  public JassFuncDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitFuncDef(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
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

  @Override
  @NotNull
  public List<JassVarType> getVarTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassVarType.class);
  }

  @Override
  public String getName() {
    return JassPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(@NotNull String newName) {
    return JassPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return JassPsiImplUtil.getNameIdentifier(this);
  }

}
