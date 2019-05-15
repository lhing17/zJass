package cn.gsein.zjass.reference;

import cn.gsein.zjass.psi.JassFuncCall;
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
public class JassFunctionReferenceProvider extends PsiReferenceProvider {
    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement,
                                                 @NotNull ProcessingContext processingContext) {
        if (psiElement instanceof JassFuncCall) {
            JassFuncCall jassFuncCall = (JassFuncCall) psiElement;
            String functionName = jassFuncCall.getFuncName().getText();
            if (StringUtils.isNotEmpty(functionName)) {
                return new PsiReference[]{new JassFunctionReference(jassFuncCall)};
            }
        }
        return PsiReference.EMPTY_ARRAY;
    }

}
