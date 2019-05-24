// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.JassComment;
import cn.gsein.zjass.psi.JassGlobalBlock;
import cn.gsein.zjass.psi.JassGlobalDecl;
import cn.gsein.zjass.psi.JassVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
