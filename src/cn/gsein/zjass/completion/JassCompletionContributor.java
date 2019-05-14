package cn.gsein.zjass.completion;

import cn.gsein.zjass.lang.JassLanguage;
import cn.gsein.zjass.psi.JassTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 *  代码补全
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassCompletionContributor extends CompletionContributor {
    public JassCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(JassTypes.FUNC_NAME).withLanguage(JassLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters completionParameters, @NotNull ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
                        completionResultSet.addElement(LookupElementBuilder.create("Hello"));
                    }
                });
    }
}
