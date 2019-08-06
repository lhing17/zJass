package cn.gsein.zjass.reference;

import cn.gsein.zjass.lang.JassIcons;
import cn.gsein.zjass.psi.JassFuncCall;
import cn.gsein.zjass.psi.JassFuncDecl;
import cn.gsein.zjass.util.JassUtil;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
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
public class JassFunctionReference extends PsiReferenceBase<JassFuncCall> {
    public JassFunctionReference(@NotNull JassFuncCall element) {
        super(element);
    }
    @Nullable
    @Override
    public PsiElement resolve() {
        Project project = myElement.getProject();
        final List<JassFuncDecl> defs = JassUtil.findFunctionDefinitions(project, myElement.getFuncRef().getText());
        List<ResolveResult> results = new ArrayList<>();
        if (defs != null) {
            for (JassFuncDecl def : defs) {
                results.add(new PsiElementResolveResult(def));
            }
        }
        return results.size() > 0 ? results.get(0).getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<JassFuncDecl> defs = JassUtil.findElementsOfType(project, JassFuncDecl.class);
        List<LookupElement> variants = new ArrayList<>();
        for (final JassFuncDecl def : defs) {
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
