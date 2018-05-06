package inter;

import lexer.Token;
import symbols.Array;
import symbols.Type;

public class Rel extends Logical {
    public Rel(Token token, Expr expr1, Expr expr2) {
        super(token, expr1, expr2);
    }

    public Type check(Type type1, Type type2) {
        if (type1 instanceof Array ||type2 instanceof Array) {
            return null;
        } else if (type1 == type2) {
            return Type.Bool;
        } else {
            return null;
        }
    }

    public void jumping(int t, int f) {
        Expr a = this.expr1.reduce();
        Expr b = this.expr2.reduce();

        String test = a.toString() + " " + this.op.toString() + " " + b.toString();
        emitjumps(test, t, f);
    }
}
