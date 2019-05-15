package cn.gsein.zjass.highlighting;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

/**
 * @author G. Seinfeld
 * @date 2019/05/15
 */
public interface JassHighlightingData {
    TextAttributesKey KEYWORDS = TextAttributesKey.createTextAttributesKey("JASS_KEYWORDS",
            DefaultLanguageHighlighterColors.KEYWORD);
    TextAttributesKey END_OF_LINE_COMMENT = TextAttributesKey.createTextAttributesKey(
            "JASS_EOL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    TextAttributesKey BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey(
            "JASS_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey(
            "JASS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(
            "JASS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
}
