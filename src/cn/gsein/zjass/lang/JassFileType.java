package cn.gsein.zjass.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JassFileType extends LanguageFileType {

    public static final JassFileType INSTANCE = new JassFileType();

    private JassFileType() {
        super(JassLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Jass file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Jass language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "j";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return JassIcons.FILE;
    }
}
