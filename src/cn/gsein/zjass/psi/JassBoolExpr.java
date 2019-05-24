// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
