package lexerTest;


import lexer.Lexer;
import lexer.Token;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LexerTest {
    private Lexer lexer = new Lexer();

    @Test
    public void scanTest() {
        String[] inputs = {"&&", "||", "==", "!=", "<=", ">=",
                           "|",  "&",  "=",  "!",  "<",  ">"};
        InputStream in;
        for (String input : inputs) {
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            try {
                Token tok = lexer.scan();
                System.out.print(tok);
                System.out.print(" : ");
                System.out.print(input);
                System.out.print('\n');
                //assert (tok.toString().equals(input));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
