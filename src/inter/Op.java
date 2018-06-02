package inter;

import lexer.Token;
import symbols.Type;

public class Op extends Expr {
    public Op(Token token, Type type) {
        super(token, type);
    }

    // Method reduce() calls gen() to generate a term,
    // and emits an instruction to assign the term to a new temporary name,
    // finally returns the temporary
    // Expr: a + b
    // reduce() -> t = a + b
    public Expr reduce() {
        Expr x = gen();
        Temp tmp = new Temp(this.type);
        emit(tmp.toString() + " = " + x.toString());
        return tmp;
    }
}
