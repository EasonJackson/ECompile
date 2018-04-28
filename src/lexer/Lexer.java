package lexer;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {
    public static int line = 1;

    char peek = ' ';
    Hashtable<String, Word> words = new Hashtable<>();

    Lexer() {
        words.put("if", new Word("if", Tag.IF));
        words.put("else", new Word("else", Tag.ELSE));
        words.put("while", new Word("while", Tag.WHILE));
        words.put("do", new Word("do", Tag.DO));
        words.put("break", new Word("break", Tag.BREAK));
        words.put(Word.True.lexeme, Word.True);
        words.put(Word.False.lexeme, Word.False);
        words.put(Type.Int.lexeme, Type.Int);
        words.put(Type.Bool.lexeme, Type.Bool);
        words.put(Type.Char.lexeme, Type.Char);
        words.put(Type.Float.lexeme, Type.Float);
    }

    void readch() throws IOException {
        peek = (char) System.in.read();
    }

    boolean readch(char c) throws IOException {
        readch();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        for (; ; readch()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line += 1;
            } else {
                break;
            }
        }

        switch (peek) {
            case '&':
                if (readch('&')) {
                    return Word.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Word.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readch('=')) {
                    return Word.eq;
                } else {
                    return new Token('=');
                }
            case '!':
                if (readch('=')) {
                    return Word.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readch('=')) {
                    return Word.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readch('=')) {
                    return Word.ge;
                } else {
                    return new Token('>');
                }
        }

        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));

            if (peek != '.') {
                return new Num(v);
            }

            float x = v;
            float d = 10F;

            for ( ; ; ) {
                readch();
                if (!Character.isDigit(peek)) {
                    break;
                }
                x = x + Character.digit(peek, 10) / d;
                d *= 10;
            }
            return new Real(x);
        }

        if (Character.isLetter(peek)) {
            StringBuffer sb = new StringBuffer();
            do {
                sb.append(peek);
                readch();
            } while (Character.isLetterOrDigit(peek));
            String s = sb.toString();
            Word w = words.get(s);
            if (w != null) {
                return w;
            }
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }

        Token token = new Token(peek);
        peek = ' ';
        return token;
    }
}
