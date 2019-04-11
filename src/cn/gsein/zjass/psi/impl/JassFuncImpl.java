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

public class JassFuncImpl extends ASTWrapperPsiElement implements JassFunc {

  public JassFuncImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitFunc(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public JassCompoundStatment getCompoundStatment() {
    return findNotNullChildByClass(JassCompoundStatment.class);
  }

  @Override
  @NotNull
  public JassFuncDef getFuncDef() {
    return findNotNullChildByClass(JassFuncDef.class);
  }

  @Override
  @Nullable
  public JassLocalDef getLocalDef() {
    return findChildByClass(JassLocalDef.class);
  }

}
