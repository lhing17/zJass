// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JassFuncCall extends PsiElement {

  @Nullable
  JassEmpty getEmpty();

  @NotNull
  JassFuncName getFuncName();

  @NotNull
  List<JassVarName> getVarNameList();

  @NotNull
  List<JassVarValue> getVarValueList();

}
