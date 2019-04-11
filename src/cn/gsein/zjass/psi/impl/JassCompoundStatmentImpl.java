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

public class JassCompoundStatmentImpl extends ASTWrapperPsiElement implements JassCompoundStatment {

  public JassCompoundStatmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitCompoundStatment(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JassAssignStatement> getAssignStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassAssignStatement.class);
  }

  @Override
  @NotNull
  public List<JassCallStatement> getCallStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassCallStatement.class);
  }

  @Override
  @NotNull
  public List<JassConditionStatement> getConditionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassConditionStatement.class);
  }

  @Override
  @NotNull
  public List<JassLoopStatement> getLoopStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JassLoopStatement.class);
  }

  @Override
  @Nullable
  public JassReturnStatement getReturnStatement() {
    return findChildByClass(JassReturnStatement.class);
  }

}
