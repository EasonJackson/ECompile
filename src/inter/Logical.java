package inter;

import lexer.Token;
import symbols.Type;

public class Logical extends Expr{
    public Expr expr1, expr2;

    Logical(Token token, Expr expr1, Expr expr2) {
        super(token, null);
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.type = check(this.expr1.type, this.expr2.type);
        if (this.type == null) {
            error("Type error");
        }
    }

    public Type check(Type type1, Type type2) {
        if (type1 == Type.Bool && type2 == Type.Bool) {
            return Type.Bool;
        } else {
            return null;
        }
    }

    @Override
    public Expr gen() {
        int f = newlabel(), a = newlabel();
        Temp temp = new Temp(this.type);
        this.jumping(0, f);
        emit(temp.toString() + " = true");
        emit("goto L" + a);
        emitlabel(f);
        emit(temp.toString() + " = false");
        emitlabel(a);
        return temp;
    }

    @Override
    public String toString() {
        return this.expr1.toString() + " " + this.op.toString() + " " + this.expr2.toString();
    }
}
