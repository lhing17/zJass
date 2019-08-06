package cn.gsein.zjass.highlighting;

import cn.gsein.zjass.lexer.JassLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static cn.gsein.zjass.highlighting.JassHighlightingData.*;
import static cn.gsein.zjass.psi.JassTypes.*;

/**
 * @author G. Seinfeld
 * @date 2019/04/11
 */
public class JassSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final List<IElementType> KEYWORDS_LIST = Arrays.asList(
            CONSTANT, NOTHING, ARRAY, CALL, SET, IF, THEN, ELSE, ELSEIF, ENDIF, GLOBALS, ENDGLOBALS, NOT,
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
        if (KEYWORDS_LIST.contains(tokenType)) return SyntaxHighlighterBase.pack(KEYWORDS);
        if (tokenType.equals(EOL_COMMENT)) return SyntaxHighlighterBase.pack(END_OF_LINE_COMMENT);
        if (tokenType.equals(MUL_COMMENT)) return SyntaxHighlighterBase.pack(BLOCK_COMMENT);
        if (tokenType.equals(ID)) return SyntaxHighlighterBase.pack(IDENTIFIER);
        if (tokenType.equals(INT_LITERAL) || tokenType.equals(REAL_LITERAL)) return SyntaxHighlighterBase.pack(NUMBER);
        return new TextAttributesKey[0];
    }
}
