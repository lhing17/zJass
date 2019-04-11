package cn.gsein.zjass.psi;

import cn.gsein.zjass.lang.JassFileType;
import cn.gsein.zjass.lang.JassLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author G. Seinfeld
 * @date 2019/04/11
 */
public class JassFile extends PsiFileBase {
    public JassFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, JassLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JassFileType.INSTANCE;
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

    @Override
    public String toString() {
        return "Jass File";
    }
}
