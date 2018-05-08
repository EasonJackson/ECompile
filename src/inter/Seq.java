package inter;

public class Seq extends Stmt {
    Stmt stmt1, stmt2;

    public Seq(Stmt stmt1, Stmt stmt2) {
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

    public void gen(int b, int a) {
        if (this.stmt1 == Stmt.Null) {
            stmt2.gen(b, a);
        } else if (this.stmt2 == Stmt.Null) {
            stmt1.gen(b, a);
        } else {
            int label = newlabel();
            this.stmt1.gen(b, label);
            emitlabel(label);
            this.stmt2.gen(label, a);
        }
    }
}
