package inter;

import lexer.Tag;
import lexer.Word;
import symbols.Type;

public class Access extends Op {
    public Id array;
    public Expr index;

    public Access(Id array, Expr index, Type type) {
        super(new Word("[]", Tag.INDEX), type);
        this.array = array;
        this.index = index;
    }

    @Override
    public Expr gen() {
        return new Access(this.array, index.reduce(), this.type);
    }

    public void jumping(int t, int f) {
        emitjumps(reduce().toString(), t, f);
    }

    @Override
    public String toString() {
        return this.array.toString() + "[" + this.index.toString() + "]";
    }
}
