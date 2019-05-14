package cn.gsein.zjass.reference;

import cn.gsein.zjass.psi.JassTypes;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import org.jetbrains.annotations.NotNull;

/**
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement().withElementType(JassTypes.FUNC_NAME), new JassFunctionReferenceProvider());
    }
}
