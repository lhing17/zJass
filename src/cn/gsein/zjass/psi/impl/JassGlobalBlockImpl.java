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

public class JassGlobalBlockImpl extends ASTWrapperPsiElement implements JassGlobalBlock {

  public JassGlobalBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitGlobalBlock(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JassComment> getCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassComment.class);
  }

  @Override
  @NotNull
  public List<JassGlobalDecl> getGlobalDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassGlobalDecl.class);
  }

}
