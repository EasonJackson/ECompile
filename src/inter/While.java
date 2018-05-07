package inter;

import symbols.Type;

public class While extends Stmt {
    Expr expr;
    Stmt stmt;

    public While() {
        this.expr = null;
        this.stmt = null;
    }

    public void init(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
        if (this.expr.type != Type.Bool) {
            this.expr.error("boolean required in while");
        }
    }

    public void get(int b, int a) {
        this.after = a;
        this.expr.jumping(0, a);
        int label = newlabel();
        emitlabel(label);
        this.stmt.gen(label, b);
        emit("goto L" + b);
    }
}
