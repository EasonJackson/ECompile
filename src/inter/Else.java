package inter;

import symbols.Type;

public class Else extends Stmt {
    Expr expr;
    Stmt stmt1, stmt2;

    public Else(Expr expr, Stmt stmt1, Stmt stmt2) {
        this.expr = expr;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
        if (this.expr.type != Type.Bool) {
            this.expr.error("boolean required in if");
        }
    }

    public void gen(int b, int a) {
        int label1 = newlabel();
        int label2 = newlabel();
        this.expr.jumping(0, label2);
        emitlabel(label1);
        this.stmt1.gen(label1, a);
        emit("goto L" + a);
        emitlabel(label2);
        this.stmt2.gen(label2, a);
    }
}
