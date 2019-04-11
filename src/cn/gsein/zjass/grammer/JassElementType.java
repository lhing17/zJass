package cn.gsein.zjass.grammer;

import cn.gsein.zjass.lang.JassLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class JassElementType extends IElementType {
    public JassElementType(@NotNull @NonNls String debugName) {
        super(debugName, JassLanguage.INSTANCE);
    }
}
