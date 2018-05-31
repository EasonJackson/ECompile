package lexer;


// Class Real is for floating point numbers
public class Real extends Token {
    public final float value;

    Real(float value) {
        super(Tag.REAL);
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
