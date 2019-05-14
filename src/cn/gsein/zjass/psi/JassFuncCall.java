// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface JassFuncCall extends JassNamedElement {

  @Nullable
  JassEmpty getEmpty();

  @NotNull
  JassFuncName getFuncName();

  @NotNull
  List<JassVarName> getVarNameList();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
