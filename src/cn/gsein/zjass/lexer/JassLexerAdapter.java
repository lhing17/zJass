package cn.gsein.zjass.lexer;

import com.intellij.lexer.FlexAdapter;

/**
 * @author G. Seinfeld
 * @date 2019/04/11
 */
public class JassLexerAdapter extends FlexAdapter {
    public JassLexerAdapter() {
        super(new JassLexer(null));
    }
}
