package grammaticalAnalysis.grammatical;

import exceptions.SysYException;
import grammaticalAnalysis.SymbolTable;
import lexicalAnalysis.lexical.Word;
import myclasses.Pair;

public class MainFuncDefNode extends FuncDefNode {

    private Word ident;

    private BlockNode blockNode;

    public MainFuncDefNode(Word ident, BlockNode blockNode, int line) {
        super(line);
        this.ident = ident;
        this.blockNode = blockNode;
    }

    public Word getIdent() {
        return ident;
    }

    @Override
    public String toString() {
        return "MainFuncDefNode";
    }

    public boolean checkErrorB(SymbolTable currentSymbolTable) {
        if (currentSymbolTable.isRedefine(ident)) {
            errors.add(new Pair<>(ident.getLineNumber(), SysYException.ExceptionCode.b));
            return true;
        } else {
            return false;
        }
    }

}
