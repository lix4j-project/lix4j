package com.github.inc0grepoz.ltse.unit;

import java.io.IOException;
import java.util.LinkedList;

import com.github.inc0grepoz.ltse.Script;
import com.github.inc0grepoz.ltse.ast.ASTNode;
import com.github.inc0grepoz.ltse.exception.SyntaxError;
import com.github.inc0grepoz.ltse.unit.expression.ExpressionResolver;
import com.github.inc0grepoz.ltse.value.Accessor;

public class UnitInclude extends Unit
{

    static UnitInclude compile(Script script, ASTNode node, UnitSection parent)
    {
        LinkedList<String> tokens = node.getTokens();
        tokens.poll(); // include

        if (tokens.size() != 1)
        {
            throw new SyntaxError("Include statements should be followed by valid filepaths");
        }

        Accessor fpa = ExpressionResolver.resolve(script, tokens);
        String filepath = (String) fpa.linkedAccess(null, null);

        try
        {
            script.include(filepath);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not include " + filepath);
        }

        return null;
    }

    private UnitInclude(UnitSection parent)
    {
        super(null);

        throw new UnsupportedOperationException();
    }

}
