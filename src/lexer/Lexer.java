package lexer;

import symbols.Type;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {
    public static int line = 1;

    private char peek = ' ';
    Hashtable<String, Word> words = new Hashtable<>();

    public Lexer() {
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

    // Method readch() is used to read next input character into variable peek
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

    // Method scan() recognize numbers, identifiers, and reserved words.
    public Token scan() throws IOException {
        for (; ; readch()) {
            // Skip space and tab
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line += 1;
            } else {
                break;
            }
        }

        // Deal with composite tokens
        // "&&", "||", "==", "!=", "<=", ">="
        // If scan() encounters any characters among "&", "|", "=", "!", "<", ">", it will scan the next character
        // and try to match with the current for a pair.
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

        // Deal with numbers (integer and float)
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

        // Deal with words
        // If scan() gets a word in the reserved words list, it return the Word from the list
        // Else returns a new word and reserves it in the list
        if (Character.isLetter(peek)) {
            StringBuilder sb = new StringBuilder();
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

        // Remaining character is returned as a new Token
        Token token = new Token(peek);
        peek = ' ';
        return token;
    }
}
