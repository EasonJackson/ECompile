package inter;

import lexer.Token;
import symbols.Type;

public class Unary extends Op {
    public Expr expr;

    public Unary(Token token, Expr expr) {
        super(token, null);
        this.expr = expr;
        this.type = Type.max(Type.Int, expr.type);
        if (this.type == null) {
            error("Type error");
        }
    }

    @Override
    public Expr gen() {
        return new Unary(this.op, expr.reduce());
    }

    @Override
    public String toString() {
        return this.op.toString() + " " + this.expr.toString();
    }
}
