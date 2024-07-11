package de.khudhur.projects.Visitor;

import java.util.Stack;

interface Expr{
    void accept(ExprVisitor v);
}

interface ExprVisitor{
    void visit(NumExpr expr);
    void visit(MulExpr expr);
    void visit(AddExpr expr);
}

class NumExpr implements Expr {
    private final int d;
    public NumExpr(int d){this.d = d;}
    public int getValue() {return d;}

    @Override
    public void accept(ExprVisitor v) {
        v.visit(this);
    }
}

record MulExpr(Expr e1, Expr e2) implements Expr {

    public void accept(ExprVisitor v) {
        v.visit(this);
    }
}

record AddExpr(Expr e1, Expr e2) implements Expr {

    public void accept(ExprVisitor v) {
        v.visit(this);
    }
}
 class EvalVisitor implements ExprVisitor {
    private final Stack<Integer> erg = new Stack<>();

    public void visit(NumExpr e) { erg.push(e.getValue()); }
    public void visit(MulExpr e) {
        e.e1().accept(this);  e.e1().accept(this);
        erg.push(erg.pop() * erg.pop());
    }
    public void visit(AddExpr e) {
        e.e1().accept(this);  e.e1().accept(this);
        erg.push(erg.pop() + erg.pop());
    }
    public int getResult() { return erg.peek(); }
}

class PrintVisitor implements ExprVisitor {
    private final Stack<String> erg = new Stack<>();

    public void visit(NumExpr e) { erg.push("NumExpr(" + e.getValue() + ")"); }
    public void visit(MulExpr e) {
        e.e1().accept(this);  e.e1().accept(this);
        erg.push("MulExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }
    public void visit(AddExpr e) {
        e.e1().accept(this);  e.e1().accept(this);
        erg.push("AddExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }
    public String getResult() { return erg.peek(); }
}


public class VisitorPattern {
    public static void main(String[] args) {
        Expr expr = new AddExpr(
                new MulExpr(
                        new NumExpr(5),
                        new NumExpr(4)),
                        new NumExpr(3)
                );
        EvalVisitor v1 = new EvalVisitor();
        expr.accept(v1);
        int erg = v1.getResult();
        PrintVisitor v2 = new PrintVisitor();
        expr.accept(v2);
        String s = v2.getResult();
        System.err.println(erg);
    }
}
