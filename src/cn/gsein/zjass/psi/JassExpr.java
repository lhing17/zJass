// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JassExpr extends PsiElement {

  @Nullable
  JassBoolExpr getBoolExpr();

  @Nullable
  JassCodeExpr getCodeExpr();

  @Nullable
  JassHandleExpr getHandleExpr();

  @Nullable
  JassNullExpr getNullExpr();

  @Nullable
  JassNumberExpr getNumberExpr();

  @Nullable
  JassStringExpr getStringExpr();

}
