package cn.gsein.zjass.highlighting;

import cn.gsein.zjass.lang.JassIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * @author G. Seinfeld
 * @date 2019/04/11
 */
public class JassColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("keywords", JassSyntaxHighlighter.KEYWORDS),
            new AttributesDescriptor("block comment", JassSyntaxHighlighter.BLOCK_COMMENT),
            new AttributesDescriptor("end of line comment", JassSyntaxHighlighter.END_OF_LINE_COMMENT),
    };
    @Nullable
    @Override
    public Icon getIcon() {
        return JassIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new JassSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "globals\n" +
                "    constant integer ID = 1\n" +
                "endglobals\n" +
                "\n" +
                "// This is an end of line comment\n" +
                "/*\n" +
                " This is a multi-line comment\n" +
                " */\n" +
                "function v takes nothing returns nothing\n" +
                "    local real id = 10086\n" +
                "    call v(ID,ID)\n" +
                "    set ID = ID()\n" +
                "endfunction";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Jass";
    }
}
