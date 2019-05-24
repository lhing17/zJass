// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JassCompoundStatment extends PsiElement {

  @NotNull
  List<JassAssignStatement> getAssignStatementList();

  @NotNull
  List<JassCallStatement> getCallStatementList();

  @NotNull
  List<JassComment> getCommentList();

  @NotNull
  List<JassConditionStatement> getConditionStatementList();

  @NotNull
  List<JassLoopStatement> getLoopStatementList();

  @Nullable
  JassReturnStatement getReturnStatement();

}
