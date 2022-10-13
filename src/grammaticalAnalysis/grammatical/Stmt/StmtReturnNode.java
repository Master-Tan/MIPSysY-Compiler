package grammaticalAnalysis.grammatical.Stmt;

import exceptions.SysYException;
import grammaticalAnalysis.SymbolTable;
import grammaticalAnalysis.grammatical.ExpNode;
import grammaticalAnalysis.grammatical.StmtNode;
import myclasses.Pair;

public class StmtReturnNode extends StmtNode {

    private ExpNode expNode;

    public StmtReturnNode(ExpNode expNode, int line) {
        super(line);
        this.expNode = expNode;
    }

    public StmtReturnNode(int line) {
        super(line);
        this.expNode = null;
    }

    public ExpNode getExpNode() {
        return expNode;
    }

    @Override
    public boolean checkErrorF(SymbolTable currentSymbolTable) {
        if (currentSymbolTable.isInVoidFun() && expNode != null) {
            errors.add(new Pair<>(this.getLine(), SysYException.ExceptionCode.f));
            return true;
        } else {
            return false;
        }
    }
}
