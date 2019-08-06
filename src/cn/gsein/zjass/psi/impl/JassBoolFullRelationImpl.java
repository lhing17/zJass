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

public class JassBoolFullRelationImpl extends ASTWrapperPsiElement implements JassBoolFullRelation {

  public JassBoolFullRelationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JassVisitor visitor) {
    visitor.visitBoolFullRelation(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JassVisitor) accept((JassVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JassBoolBoolRelation getBoolBoolRelation() {
    return findChildByClass(JassBoolBoolRelation.class);
  }

  @Override
  @Nullable
  public JassBoolCodeRelation getBoolCodeRelation() {
    return findChildByClass(JassBoolCodeRelation.class);
  }

  @Override
  @Nullable
  public JassBoolHandleRelation getBoolHandleRelation() {
    return findChildByClass(JassBoolHandleRelation.class);
  }

  @Override
  @Nullable
  public JassBoolNullRelation getBoolNullRelation() {
    return findChildByClass(JassBoolNullRelation.class);
  }

  @Override
  @Nullable
  public JassBoolNumRelation getBoolNumRelation() {
    return findChildByClass(JassBoolNumRelation.class);
  }

  @Override
  @Nullable
  public JassBoolStringRelation getBoolStringRelation() {
    return findChildByClass(JassBoolStringRelation.class);
  }

}
