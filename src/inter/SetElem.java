package inter;

import symbols.Array;
import symbols.Type;

public class SetElem extends Stmt {
    public Id array;
    public Expr index;
    public Expr expr;

    public SetElem(Access x, Expr y) {
        this.array = x.array;
        this.index = x.index;
        this.expr = y;
        if (check(x.type, this.expr.type) == null) {
            error("type error");
        }
    }

    public Type check(Type type1, Type type2) {
        if (type1 instanceof Array || type2 instanceof Array) {
            return null;
        } else if (type1 == type2) {
            return type2;
        } else if (Type.numeric(type1) && Type.numeric(type2)) {
            return type2;
        } else {
            return null;
        }
    }

    public void gen(int b, int a) {
        String s1 = this.index.reduce().toString();
        String s2 = this.expr.reduce().toString();
        emit(this.array.toString() + "[" + s1 + "]=" + s2);
    }
}
