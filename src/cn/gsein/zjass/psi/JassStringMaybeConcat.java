// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JassStringMaybeConcat extends PsiElement {

  @NotNull
  List<JassStringAtom> getStringAtomList();

  @NotNull
  List<JassStringConcatOp> getStringConcatOpList();

}
