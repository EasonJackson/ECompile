package inter;

import lexer.Token;
import symbols.Type;

public class Op extends Expr {
    public Op(Token token, Type type) {
        super(token, type);
    }

    public Expr reduce() {
        Expr x = gen();
        Temp tmp = new Temp(this.type);
        emit(tmp.toString() + " = " + x.toString());
        return tmp;
    }
}
