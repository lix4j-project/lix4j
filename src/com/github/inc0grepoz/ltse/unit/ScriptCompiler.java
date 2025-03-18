package com.github.inc0grepoz.ltse.unit;

import java.util.LinkedList;

import com.github.inc0grepoz.ltse.Script;
import com.github.inc0grepoz.ltse.ast.AST;
import com.github.inc0grepoz.ltse.ast.ASTNode;
import com.github.inc0grepoz.ltse.ast.NodeBreakerType;
import com.github.inc0grepoz.ltse.exception.SyntaxError;

public class ScriptCompiler
{

    public static void compile(AST ast, Script script, UnitRoot root)
    {
        compileSection_r(script, ast, root);
    }

    static Unit compileUnit_r(Script script, ASTNode node, UnitSection parent)
    {
        if (!node.hasTokens())
        {
            return compileSection_r(script, node, new UnitSection(parent));
        }

        switch (node.getTokens().peek())
        {
        case "break":
            return UnitBreak.compile(script, node, parent);
        case "continue":
            return UnitContinue.compile(script, node, parent);
        case "else":
            throw new SyntaxError("There can be no \"else\" without an \"if\"");
        case "for":
            return UnitLoopFor.compile(script, node, parent);
        case "function":
            return UnitFunction.compile(script, node, parent);
        case "if":
            return UnitConditionalIf.compile(script, node, parent);
        case "include":
            return UnitInclude.compile(script, node, parent);
        case "return":
            return UnitReturn.compile(script, node, parent);
        case "switch":
            throw new SyntaxError("Switching is not supported");
        case "while":
            return UnitLoopWhile.compile(script, node, parent);
        default:
            return UnitOperation.compile(script, node, parent);
        }
    }

    static void appendSectionUnits(Script script, ASTNode node, Unit parent)
    {
        if (parent instanceof UnitSection)
        {
            UnitSection section = (UnitSection) parent;

            if (node.getNodeBreakerType() == NodeBreakerType.BLOCK)
            {
                ASTNode next = node.getParent().getChildNodes().poll();
                compileSection_r(script, next, section);
            }
            else
            {
                if (!node.getTokens().isEmpty())
                {
                    compileUnit_r(script, node, section);
                }
            }
        }
        else
        {
            throw new IllegalStateException("Attempted to extend a statement with a block of code");
        }
    }

    static UnitSection compileSection_r(Script script, ASTNode node, UnitSection parent)
    {
        LinkedList<ASTNode> childs = node.getChildNodes();

        while (!childs.isEmpty())
        {
            compileUnit_r(script, childs.poll(), parent);
        }

        return parent;
    }

}
