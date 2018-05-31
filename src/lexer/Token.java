package lexer;

public class Token {
    public final int tag;

    // Token instance is initialized with a tag
    public Token(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + (char) tag;
    }
}
