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

public class JassFuncCallImpl extends ASTWrapperPsiElement implements JassFuncCall {

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

  @Override
  @NotNull
  public List<JassVarValue> getVarValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassVarValue.class);
  }

}
