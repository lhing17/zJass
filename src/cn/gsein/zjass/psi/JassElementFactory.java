package cn.gsein.zjass.psi;

import cn.gsein.zjass.lang.JassFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

/**
 * @author G. Seinfeld
 * @date 2019/05/14
 */
public class JassElementFactory {
    public static JassFuncName createFunctionName(Project project, String name) {
        final JassFile file = createFile(project, name);
        return (JassFuncName) file.getFirstChild();
    }

    public static JassFile createFile(Project project, String text) {
        String name = "dummy.j";
        return (JassFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, JassFileType.INSTANCE, text);
    }
}
