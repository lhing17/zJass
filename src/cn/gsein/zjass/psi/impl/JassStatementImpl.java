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

public class JassStatementImpl extends ASTWrapperPsiElement implements JassStatement {

  public JassStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JassCallStatement getCallStatement() {
    return findChildByClass(JassCallStatement.class);
  }

  @Override
  @Nullable
  public JassComment getComment() {
    return findChildByClass(JassComment.class);
  }

  @Override
  @Nullable
  public JassConditionStatement getConditionStatement() {
    return findChildByClass(JassConditionStatement.class);
  }

  @Override
  @Nullable
  public JassDebugStatement getDebugStatement() {
    return findChildByClass(JassDebugStatement.class);
  }

  @Override
  @Nullable
  public JassExitwhenStatement getExitwhenStatement() {
    return findChildByClass(JassExitwhenStatement.class);
  }

  @Override
  @Nullable
  public JassLoopStatement getLoopStatement() {
    return findChildByClass(JassLoopStatement.class);
  }

  @Override
  @Nullable
  public JassRuleReturn getRuleReturn() {
    return findChildByClass(JassRuleReturn.class);
  }

  @Override
  @Nullable
  public JassSetVar getSetVar() {
    return findChildByClass(JassSetVar.class);
  }

}
