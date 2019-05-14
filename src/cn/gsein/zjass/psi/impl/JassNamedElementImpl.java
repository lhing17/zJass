package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.JassNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public abstract class JassNamedElementImpl extends ASTWrapperPsiElement implements JassNamedElement {
    public JassNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
