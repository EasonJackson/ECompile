/**
 *
 * A simply and easy use compiler front end
 * @Author Eason
 * @Time April 2018
 *
 * / Language grammar /
 * // Program //
 * program -> block
 * block -> { decls stmts }
 * decls -> decls decl | es
 * decl -> type id ;
 * type -> type [ nUID ] | basic
 * stmts -> stmts stmt | es
 *
 * // Statement //
 * stmt -> loc = bool ;
 *         | if ( bool ) stmt
 *         | if ( bool ) stmt else stmt
 *         | while ( bool ) stmt
 *         | do stmt while ( bool )
 *         | break ;
 *         | block
 * loc -> loc [ boo I ] | id
 *
 * // Expression //
 * bool -> bool || join | join
 * join -> join && equality | equality
 * equality -> equality == rel | equality ! = rel | rel
 * rel -> expr < expr | expr <= expr | expr >= expr
 * expr -> expr | expr
 * expr -> expr + term | expr - term | term
 * term -> term * unary | term / unary | unary
 * unary -> ! unary | - unary | factor
 * factor -> ( bool ) | loc | num | real | true | false
 */
package main;


import lexer.Lexer;
import parser.Parser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        try {
            System.out.println("Start interpreter");
            Parser parser = new Parser(lexer);
            parser.program();
            System.out.write('\n');
        } catch(IOException ex){
            ex.printStackTrace();
            return;
        }


    }
}
