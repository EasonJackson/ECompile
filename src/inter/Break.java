package inter;

public class Break extends Stmt {
    Stmt stmt;

    public Break() {
        if (Stmt.Enclosing == null) {
            error("unenclosed break");
            this.stmt = Stmt.Enclosing;
        }
    }

    public void gen(int b, int a) {
        emit("goto L" + this.stmt.after);
    }
}
