package cn.gsein.zjass.reference;

import cn.gsein.zjass.psi.JassFuncName;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassReferenceProvider extends PsiReferenceProvider {
    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement,
                                                 @NotNull ProcessingContext processingContext) {
        if (psiElement instanceof JassFuncName) {
            JassFuncName jassFuncName = (JassFuncName) psiElement;
            String functionName = jassFuncName.getText();
            if (StringUtils.isNotEmpty(functionName)) {
                return new PsiReference[]{new JassFunctionReference(jassFuncName, TextRange.EMPTY_RANGE)};
            }
        }
        return PsiReference.EMPTY_ARRAY;
    }

}
