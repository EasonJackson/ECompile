package inter;

import lexer.Lexer;


// Node class represent elements in syntax trees.
// Node has two subclasses:
// 1. Expr: Expression
// 2. Stmt: Statement
public class Node {
    static int labels = 0;
    int lexline = 0;

    Node() {
        this.lexline = Lexer.line;
    }

    void error(String s) {
        throw new Error("near line " + lexline + ": " + s);
    }

    public int newlabel() {
        return ++labels;
    }

    public void emitlabel(int i) {
        System.out.print("L" + i + ":");
    }

    public void emit(String s) {
        System.out.println("\t" + s);
    }
}
