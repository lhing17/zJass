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

public class JassFuncDefImpl extends ASTWrapperPsiElement implements JassFuncDef {

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

}
