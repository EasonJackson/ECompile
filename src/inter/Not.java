package inter;

import lexer.Token;

public class Not extends Logical {
    public Not(Token token, Expr expr) {
        super(token, expr, expr);
    }

    public void jumping(int t, int f) {
        this.expr2.jumping(f, t);
    }

    @Override
    public String toString() {
        return this.op.toString() + " " + this.expr2.toString();
    }
}
