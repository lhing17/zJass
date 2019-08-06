package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * PSI的工具类
 *
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassPsiImplUtil {
    public static String getName(JassFuncDecl def) {
        return def.getFuncName().getText();
    }

    public static PsiElement setName(JassFuncDecl def, @NotNull String newName) {
        ASTNode keyNode = def.getNode().findChildByType(JassTypes.FUNC_NAME);
        if (keyNode != null) {
            JassFuncName funcName = JassElementFactory.createFunctionName(def.getProject(), newName);
            ASTNode newFuncNameNode = funcName.getNode();
            def.getNode().replaceChild(keyNode, newFuncNameNode);
        }
        return def;
    }


    public static PsiElement getNameIdentifier(JassFuncDecl def) {
        ASTNode keyNode = def.getNode().findChildByType(JassTypes.FUNC_NAME);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(JassFuncCall call) {
        ASTNode keyNode = call.getNode().findChildByType(JassTypes.FUNC_NAME);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}
