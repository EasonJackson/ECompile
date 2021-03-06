package symbols;

import lexer.Tag;
import lexer.Word;

public class Type extends Word {
    public int width = 0;

    Type(String s, int tag, int w) {
        super(s, tag);
        this.width = w;
    }

    public static final Type
        Int = new Type("int", Tag.BASIC, 4),
        Float = new Type("float", Tag.BASIC, 8),
        Char = new Type("char", Tag.BASIC, 1),
        Bool = new Type("bool", Tag.BASIC, 1);

    // Check whether the type p is a numeric type
    public static boolean numeric(Type p) {
        if (p == Type.Char || p == Type.Int || p == Type.Float) {
            return true;
        }
        return false;
    }

    // Detect the max type between two numeric types
    public static Type max(Type p1, Type p2) {
        if (!numeric(p1) || !numeric(p2)) {
            return null;
        } else if (p1 == Type.Float || p2 == Type.Float) {
            return Type.Float;
        } else if (p1 == Type.Int || p2 == Type.Int) {
            return Type.Int;
        } else {
            return Type.Char;
        }
    }
}
