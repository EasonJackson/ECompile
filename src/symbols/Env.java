package symbols;

import inter.Id;
import lexer.Token;

import java.util.Hashtable;

public class Env {
    private Hashtable<Token, Id> table;
    protected Env prev;

    public Env(Env n) {
        table = new Hashtable<>();
        prev = n;
    }

    public void put(Token token, Id id) {
        table.put(token, id);
    }

    public Id get(Token token) {
        for (Env e = this; e != null; e = e.prev) {
            Id found = e.table.get(token);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
