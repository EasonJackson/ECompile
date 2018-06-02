package inter;

import lexer.Token;
import symbols.Type;


// Class Arith implements binary operators like "+" and "*"
public class Arith extends Op {
    public Expr expr1, expr2;

    // Constructor initialize type will placeholder null
    // It check type compatibility: if true it will return the max type of two expressions
    public Arith(Token token, Expr expr1, Expr expr2) {
        super(token, null);
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.type = Type.max(this.expr1.type, this.expr2.type);
        if (this.type == null) {
            error("Type error");
        }
    }

    public Expr get() {
        return new Arith(op, this.expr1.reduce(), this.expr2.reduce());
    }

    public String toString() {
        return this.expr1.toString() + " " + this.op.toString() + " " + this.expr2.toString();
    }
}
