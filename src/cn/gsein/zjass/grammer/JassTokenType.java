package cn.gsein.zjass.grammer;

import cn.gsein.zjass.lang.JassLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class JassTokenType extends IElementType {
    public JassTokenType(@NotNull @NonNls String debugName) {
        super(debugName, JassLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "JassTokenType." + super.toString();
    }
}
