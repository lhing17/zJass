package cn.gsein.zjass.reference;

import cn.gsein.zjass.lang.JassIcons;
import cn.gsein.zjass.psi.JassFuncDef;
import cn.gsein.zjass.util.JassUtil;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理jass函数的引用
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassFunctionReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    public JassFunctionReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
    }

    public JassFunctionReference(@NotNull PsiElement element) {
        super(element);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean b) {
        Project project = myElement.getProject();
        final List<JassFuncDef> defs = JassUtil.findFunctionDefinitions(project, myElement.getText());
        List<ResolveResult> results = new ArrayList<>();
        if (defs != null) {
            for (JassFuncDef def : defs) {
                results.add(new PsiElementResolveResult(def));
            }
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<JassFuncDef> defs = JassUtil.findElementsOfType(project, JassFuncDef.class);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final JassFuncDef def : defs) {
            if (StringUtils.isNotEmpty(def.getText())) {
                variants.add(LookupElementBuilder.create(def).
                        withIcon(JassIcons.FILE).
                        withTypeText(def.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
