package inter;

import symbols.Type;

public class Do extends Stmt {
    Expr expr;
    Stmt stmt;

    public Do() {
        this.expr = null;
        this.stmt = null;
    }

    public void init(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
        if (this.expr.type != Type.Bool) {
            this.expr.error("boolean required in do");
        }
    }

    public void gen(int b, int a) {
        this.after = a;
        int label = newlabel();
        this.stmt.gen(b, label);
        emitlabel(label);
        this.expr.jumping(b, 0);
    }
}
