package cn.gsein.zjass.reference;

import cn.gsein.zjass.psi.JassTypes;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassReferenceContributor extends PsiReferenceContributor {
    private static Logger logger = LoggerFactory.getLogger(JassReferenceContributor.class);
    public JassReferenceContributor() {
        logger.info("I'm the referenceContributor");
    }

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement().withElementType(JassTypes.FUNC_CALL), new JassFunctionReferenceProvider());
    }
}
