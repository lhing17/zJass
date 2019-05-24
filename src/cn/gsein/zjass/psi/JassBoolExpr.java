// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface JassBoolExpr extends PsiElement {

  @Nullable
  JassBoolExpr getBoolExpr();

  @Nullable
  JassFuncCall getFuncCall();

  @NotNull
  List<JassNumberExpr> getNumberExprList();

  @NotNull
  List<JassStringExpr> getStringExprList();

  @Nullable
  JassVarName getVarName();

}
