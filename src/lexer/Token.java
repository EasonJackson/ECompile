package lexer;

public class Token {
    public final int tag;

    Token(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + (char) tag;
    }
}
