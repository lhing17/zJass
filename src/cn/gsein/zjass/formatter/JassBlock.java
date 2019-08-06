package cn.gsein.zjass.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author G. Seinfeld
 * @date 2019/08/06
 */
public class JassBlock extends AbstractBlock {

    private SpacingBuilder spacingBuilder;

    protected JassBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment) {
        super(node, wrap, alignment);
    }

    @Override
    protected List<Block> buildChildren() {
        return null;
    }

    @Override
    public Indent getIndent() {
        return super.getIndent();
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block block, @NotNull Block block1) {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
