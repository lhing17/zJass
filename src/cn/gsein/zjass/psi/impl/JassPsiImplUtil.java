package cn.gsein.zjass.psi.impl;

import cn.gsein.zjass.psi.JassElementFactory;
import cn.gsein.zjass.psi.JassFuncCall;
import cn.gsein.zjass.psi.JassFuncName;
import cn.gsein.zjass.psi.JassTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * PSI的工具类
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassPsiImplUtil {
    public static String getName(JassFuncCall call){
        return call.getFuncName().getText();
    }

    public static PsiElement setName(JassFuncCall call, @NotNull String newName){
        ASTNode keyNode = call.getNode().findChildByType(JassTypes.FUNC_NAME);
        if (keyNode != null) {
            JassFuncName funcName = JassElementFactory.createFunctionName(call.getProject(), newName);
            ASTNode newFuncNameNode = funcName.getNode();
            call.getNode().replaceChild(keyNode, newFuncNameNode);
        }
        return call;
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
