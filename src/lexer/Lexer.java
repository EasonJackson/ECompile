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

    }

    boolean readch(char c) throws IOException {

    }

    public Token scan() throws IOException {

    }
}
