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

public class JassStringMaybeConcatImpl extends ASTWrapperPsiElement implements JassStringMaybeConcat {

  public JassStringMaybeConcatImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitStringMaybeConcat(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JassStringAtom> getStringAtomList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassStringAtom.class);
  }

  @Override
  @NotNull
  public List<JassStringConcatOp> getStringConcatOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassStringConcatOp.class);
  }

}
