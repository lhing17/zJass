// This is a generated file. Not intended for manual editing.
package cn.gsein.zjass.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JassStatement extends PsiElement {

  @Nullable
  JassCallStatement getCallStatement();

  @Nullable
  JassComment getComment();

  @Nullable
  JassConditionStatement getConditionStatement();

  @Nullable
  JassDebugStatement getDebugStatement();

  @Nullable
  JassExitwhenStatement getExitwhenStatement();

  @Nullable
  JassLoopStatement getLoopStatement();

  @Nullable
  JassRuleReturn getRuleReturn();

  @Nullable
  JassSetVar getSetVar();

}
