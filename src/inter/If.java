package inter;

import symbols.Type;

public class If extends Stmt {
    Expr expr;
    Stmt stmt;

    public If(Stmt stmt, Expr expr) {
        this.expr = expr;
        this.stmt = stmt;

        if (this.expr.type != Type.Bool) {
            this.expr.error("boolean required in if");
        }
    }

    public void gen(int b, int a) {
        int label = newlabel();
        this.expr.jumping(0, a);
        emitlabel(label);
        stmt.gen(label, a);
    }
}
