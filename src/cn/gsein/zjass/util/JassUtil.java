package cn.gsein.zjass.util;

import cn.gsein.zjass.lang.JassFileType;
import cn.gsein.zjass.psi.JassFile;
import cn.gsein.zjass.psi.JassFuncCall;
import cn.gsein.zjass.psi.JassFuncDecl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassUtil {

    /**
     * 获取工程中某个函数的调用
     *
     * @param project 工程
     * @return 函数调用
     */
    public static List<JassFuncCall> findFunctionCalls(Project project, String functionName) {
        List<JassFuncCall> list = findElementsOfType(project, JassFuncCall.class);
        if (list == null) return null;
        return list.stream().filter(jassFuncCall -> functionName.equals(jassFuncCall.getFuncRef().getText())).collect(Collectors.toList());
    }

    /**
     * 获取工程中某个函数的定义
     *
     * @param project 工程
     * @return 函数定义
     */
    public static List<JassFuncDecl> findFunctionDefinitions(Project project, String functionName) {
        List<JassFuncDecl> list = findElementsOfType(project, JassFuncDecl.class);
        if (list == null) return null;
        return list.stream().filter(jassFuncDef -> functionName.equals(jassFuncDef.getFuncName().getText())).collect(Collectors.toList());
    }

    /**
     * 获取工程中所有某种element
     *
     * @param project 工程
     * @return 函数调用
     */
    public static <T extends PsiElement> List<T> findElementsOfType(Project project, Class<T> tClass) {
        List<T> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(JassFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            JassFile jassFile = (JassFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (jassFile != null) {
                T[] ts = PsiTreeUtil.getChildrenOfType(jassFile, tClass);
                if (ts != null) {
                    Collections.addAll(result, ts);
                }
            }
        }
        return result;
    }


}
