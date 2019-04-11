package cn.gsein.zjass.lang;

import com.intellij.lang.Language;

public class JassLanguage extends Language {
    public static final JassLanguage INSTANCE = new JassLanguage();

    private JassLanguage(){
        super("Jass");
    }
}
