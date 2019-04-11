package cn.gsein.zjass.highlighting;

import cn.gsein.zjass.lexer.JassLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static cn.gsein.zjass.psi.JassTypes.*;

/**
 * @author G. Seinfeld
 * @date 2019/04/11
 */
public class JassSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORDS = TextAttributesKey.createTextAttributesKey("JASS_KEYWORDS",
            DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey END_OF_LINE_COMMENT = TextAttributesKey.createTextAttributesKey(
            "JASS_EOL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey(
            "JASS_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey(
            "JASS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(
            "JASS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    private static final TextAttributesKey[] KEYWORDS_KEYS = new TextAttributesKey[]{KEYWORDS};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{END_OF_LINE_COMMENT};
    private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[]{BLOCK_COMMENT};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};

    private static final List<IElementType> KEYWORDS_LIST = Arrays.asList(
            TYPE_ID, CONSTANT, NOTHING, ARRAY, CALL, SET, IF, THEN, ELSE, ELSEIF, ENDIF, GLOBALS, ENDGLOBALS,
            FUNCTION, ENDFUNCTION, LOOP, ENDLOOP, EXITWHEN, EXTENDS, LOCAL, NATIVE, NULL, RETURN, RETURNS, TAKES, TYPE
    );

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new JassLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (KEYWORDS_LIST.contains(tokenType)) {
            return KEYWORDS_KEYS;
        }
        if (tokenType.equals(EOL_COMMENT)) {
            return LINE_COMMENT_KEYS;
        }
        if (tokenType.equals(MUL_COMMENT)) {
            return BLOCK_COMMENT_KEYS;
        }
        if (tokenType.equals(ID)) {
            return IDENTIFIER_KEYS;
        }
        if (tokenType.equals(INTEGER_CONST) || tokenType.equals(REAL_CONST)) {
            return NUMBER_KEYS;
        }
        return new TextAttributesKey[0];
    }
}
