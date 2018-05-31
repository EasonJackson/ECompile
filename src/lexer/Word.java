package lexer;


// Word manages lexemes for reserved words, identifiers and composite tokens like "&&".
// It is also useful in managing the written form of operators in the intermediate code like unary minus "-"
public class Word extends Token {
    public String lexeme = "";
    public static final Word
            and = new Word("&&", Tag.AND),
            or = new Word("||", Tag.OR),
            eq = new Word("==", Tag.EQ),
            ne = new Word("!=", Tag.NE),
            le = new Word("<=", Tag.LE),
            ge = new Word(">=", Tag.GE),
            minus = new Word("-", Tag.MINUS),
            True = new Word("true", Tag.TRUE),
            False = new Word("false", Tag.FALSE),
            temp = new Word("t", Tag.TEMP);

    public Word(String s, int tag) {
        super(tag);
        this.lexeme = s;
    }

    @Override
    public String toString() {
        return lexeme;
    }
}
